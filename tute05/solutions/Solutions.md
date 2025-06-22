# Tutorial 05

## A. Streams and Lambdas

1. Inside `src/stream/App.java`, rewrite the following code using the `.forEach()` method and a lambda:

```java
List<String> strings = new ArrayList<String>(Arrays.asList(new String[] {"1", "2", "3", "4", "5"}));
for (String string : strings) {
    System.out.println(string);
}
```

2. In the above example, discuss two different ways to write lambda expressions.

   > One-liner or with curly braces

3. What is a stream? Rewrite the following code to use a stream and the `map` function.

```java
List<String> strings2 = new ArrayList<String>(Arrays.asList(new String[] {"1", "2", "3", "4", "5"}));
List<Integer> ints = new ArrayList<Integer>();
for (String string : strings2) {
    ints.add(Integer.parseInt(string));
}
```

4. Modify your answer to (3) to use a scope operator instead of a normal lambda.
   > See [`App.java`](solutions/src/stream/App.java)

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
> See [solutions/src/restaurant](solutions/src/restaurant/)

## C. Observer Pattern
In `src/youtube`, create a model for the following requirements of a Youtube-like video creating and watching service using the Observer Pattern:

- A Producer has a name, a series of subscribers and videos
- When a producer posts a new video, all of the subscribers are notified that a new video was posted
- A User has a name, and can subscribe to any Producer
- A video has a name, length and producer

Write a simple test with print statements inside `YoutubeTest.java`.

Once this is done, think about what if we want to be able to produce videos and subscribe to videos as well (the way youtube actually works). In groups, draw a UML diagram refactoring the code so that the `Producer` and `User` classes are merged, whilst still using the Observer Pattern.

> See [solutions/src/youtube](solutions/src/youtube/)
