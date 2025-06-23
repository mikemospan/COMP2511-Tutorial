# Tutorial 04

## A. Design Principles

### Part 1: Law of Demeter

In the `unsw.training` package there is some skeleton code for a training system.

- Every employee must attend a whole day training seminar run by a qualified trainer
- Each trainer is running multiple seminars with no more than 10 attendees per seminar

In the `TrainingSystem` class there is a method to book a seminar for an employee given the dates on which they are available. This method violates the principle of least knowledge (Law of Demeter).

1. How and why does it violate this principle?
2. In violating this principle, what other properties of this design are not desirable?
3. Refactor the code so that the principle is no longer violated. How has this affected other properties of the design?
4. More generally, are getters essentially a means of violating the principle of least knowledge? Does this make using getters bad design?

### Part 2: Liskov Substitution Principle

Look at the `OnlineSeminar` class. How does this violate the Liskov Substitution Principle?

## B. Composite Pattern
Inside `src/calculator`, use the Composite Pattern to write a simple calculator that evaluates an expression. Your calculator should be able to:

- Add two expressions
- Subtract two expressions
- Multiply two expressions
- Divide two expressions

There should be a `Calculator` class as well which can have an expression passed in, and calculate that expression.

Design a solution, create stubs, write failing unit tests, then implement the functions.

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
