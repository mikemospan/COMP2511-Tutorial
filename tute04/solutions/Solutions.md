# Tutorial 04

## A. Design Principles

### Part 1: Law of Demeter

In the `unsw.training` package there is some skeleton code for a training system.

- Every employee must attend a whole day training seminar run by a qualified trainer
- Each trainer is running multiple seminars with no more than 10 attendees per seminar

In the `TrainingSystem` class there is a method to book a seminar for an employee given the dates on which they are available. This method violates the principle of least knowledge (Law of Demeter).

1. How and why does it violate this principle?

   > The `TrainingSystem` class extracts instances of `Seminar` from instances of `Trainer` and calls the methods of `Seminar`. Furthermore it extracts the start date from instances of `Seminar` and calls its methods. More informally, the `TrainingSystem` class is interacting with classes other than its "friends".

2. In violating this principle, what other properties of this design are not desirable?

   > - The design is needlessly tightly coupled as `TrainingSystem` is dependent on both `Trainer` and `Seminar`.
   > - `TrainingSystem` suffers from low cohesion as any change to the system requires a change to this class.
   > - The `Seminar` class has no control over the number attendees. It relies on `TrainingSystem` to ensure there are never more than 10. This makes `Seminar` hard to re-use as any future client has to ensure they don't exceed the maximum of 10 attendees. This is an example of poor encapsulation.

3. Refactor the code so that the principle is no longer violated. How has this affected other properties of the design?

   > See code [here](solutions/src/unsw/training).
   >
   > - The design is no longer tightly coupled. `TrainingSystem` no longer has any knowledge of `Seminar`.
   > - Each of the classes now has a clear purpose in booking a training seminar, thus improving cohesion.
   > - The `Seminar` class itself is now responsible for ensuring that the number of attendees does not exceed 10. This is an example of a class maintaining its invariant. We'll come back to that when discussing programming by contract.

4. More generally, are getters essentially a means of violating the principle of least knowledge? Does this make using getters bad design?
   > Getters that return an object (as opposed to a primitive) likely only serve the purpose of letting clients invoke methods on that object, so a valid point can be made that getters can only be used as a means for violating the principle of least knowledge. A counter argument is that getters make classes more reusable. A client may need to do something with an object for which it has no method. In that case, getters can allow the client use the class in a way that was not originally foreseen, even if it does violate the principle of least knowledge.
   >
   > Another way in which a getter can be an example of bad design is in `Seminar` above. By having a `getAttendees()` method implemented as a simple getter, any client is able to add additional attendees to the list of attendees, potentially exceeding the maximum of 10. Unfortunately, Java does not offer any good solutions to this problem. Either `getAttendees()` has to create a copy of the list, or it can use `Collections.unmodifiableList(...)` to wrap the list up in a class that prevents any modification to the list. The former solution is inefficient as it needlessly copies data. The latter can be surprising to the client as the returned list still has an `add(...)` method, but it causes a runtime error every time it is used. Other languages resolve this problem by having proper immutable or read-only lists.

### Part 2: Liskov Substitution Principle

Look at the `OnlineSeminar` class. How does this violate the Liskov Substitution Principle?

> This class violates the Liskov Substitution Principle. Specifically a `Seminar` is defined as having a list of attendees, but `OnlineSeminar` does not require this. A client interacting with a `Seminar` would expect the seminar to be booked like any other. This is an example of classes having an IS-A relationship informally, but not a valid inheritance relationship when taking into account what the classes actually do and represent.

## B. Composite Pattern
Inside `src/calculator`, use the Composite Pattern to write a simple calculator that evaluates an expression. Your calculator should be able to:

- Add two expressions
- Subtract two expressions
- Multiply two expressions
- Divide two expressions

There should be a `Calculator` class as well which can have an expression passed in, and calculate that expression.

Design a solution, create stubs, write failing unit tests, then implement the functions.

> See [solutions/src/calculator](solutions/src/calculator/)

## C. Factory Pattern

Inside `src/thrones`, there is some code to model a simple chess-like game. In this game different types of characters move around on a grid fighting each other. When one character moves into the square occupied by another they attack that character and inflict damage based on random chance. There are four types of characters:

- A king can move one square in any direction (including diagonally), and always causes 8 points of damage when attacking.
- A knight can move like a knight in chess (in an L shape), and has a 1 in 2 chance of inflicting 10 points of damage when attacking.
- A queen can move to any square in the same column, row or diagonal as she is currently on, and has a 1 in 3 chance of inflicting 12 points of damage and a 2 out of 3 chance of inflicting 6 points of damage.
- A dragon can only move up, down, left or right, and has a 1 in 6 chance of inflicting 20 points of damage.

We won't concern ourselves with the logic of the game in this exercise per se, but instead the creation of objects.

We want to refactor the code so that when the characters are created, they are put in a random location in a grid of length 5.

1. How does the Factory Pattern (AKA Factory Method) allow us to abstract construction of objects, and how will it improve our design with this new requirement?
2. Use the Factory Pattern to create a series of object factories for each of the character types, and change the `main` method of `Game.java` to use these factories.
   > See [solutions/src/thrones](solutions/src/thrones/)
