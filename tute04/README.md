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

## B. Strategy Pattern
Inside `src/restaurant` is a solution for a restaurant payment system with the following requirements:

- The restaurant has a menu, stored in a JSON file. Each meal on the menu has a name and price
- The system displays all of the standard meal names and their prices to the user so they can make their order
- The user can enter their order as a series of meals, and the system returns their cost
- The prices on meals often vary in different circumstances. The restaurant has three different price settings (so far):
    - Standard - normal rates
    - Holiday - 15% surcharge on all items for all customers
    - Happy Hour - where registered members get a 40% discount, while standard customers get 30%
- The prices displayed on the menu are the ones for standard customers in all settings

Currently, the code uses switch statements to handle each of the different four cases.
- How does the code violate the open/closed principle?
- How does this make the code brittle?

 i) Refactor the code to use the Strategy Pattern to handle the three settings.

Here is the strategy interface to get you started:

```java
public interface ChargingStrategy {
    /**
     * The cost of a meal.
     */
    public double cost(List<Meal> order, boolean payeeIsMember);

    /**
     * Modifying factor of charges for standard customers.
     */
    public double standardChargeModifier();
}
```

 ii) Extend the system to add the following pricing strategy:
  - Prize Draw: A special promotion where every *100th* customer (since the start of the promotion) gets their meal for free!

## C. Composite Pattern
Inside `src/calculator`, use the Composite Pattern to write a simple calculator that evaluates an expression. Your calculator should be able to:

- Add two expressions
- Subtract two expressions
- Multiply two expressions
- Divide two expressions

There should be a `Calculator` class as well which can have an expression passed in, and calculate that expression.

Design a solution, create stubs, write failing unit tests, then implement the functions.

## D. Factory Pattern

Inside `src/thrones`, there is some code to model a simple chess-like game. In this game different types of characters move around on a grid fighting each other. When one character moves into the square occupied by another they attack that character and inflict damage based on random chance. There are four types of characters:

- A king can move one square in any direction (including diagonally), and always causes 8 points of damage when attacking.
- A knight can move like a knight in chess (in an L shape), and has a 1 in 2 chance of inflicting 10 points of damage when attacking.
- A queen can move to any square in the same column, row or diagonal as she is currently on, and has a 1 in 3 chance of inflicting 12 points of damage and a 2 out of 3 chance of inflicting 6 points of damage.
- A dragon can only move up, down, left or right, and has a 1 in 6 chance of inflicting 20 points of damage.

We won't concern ourselves with the logic of the game in this exercise per se, but instead the creation of objects.

We want to refactor the code so that when the characters are created, they are put in a random location in a grid of length 5.
1. How does the Factory Pattern (AKA Factory Method) allow us to abstract construction of objects, and how will it improve our design with this new requirement?
2. Use the Factory Pattern to create a series of object factories for each of the character types, and change the `main` method of `Game.java` to use these factories.
