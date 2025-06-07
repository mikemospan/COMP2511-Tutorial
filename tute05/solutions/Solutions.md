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

## B. Singleton Pattern & Concurrency
Consider the Bank Account class from Lab 04. What if multiple people try to access the bank account at the same time? Inside `src/heist` are three classes:

- `BankAccount`, from Lab 04.
- `BankAccountAccessor`. Objects of this type are an instance of an access to a bank account to withdraw money a given number of times by given amounts.
- `BankAccountThreadedAccessor`, which `extends Thread`, and overrides the method `run` to create a new instance of `BankAccountAccessor` and access the bank.

Currently when you run the code, you will find that each thread accesses the bank at the same time (which doesn't make sense). Most of the time this just means that each accessor tries to make as many transactions as they can before the bank runs out of money:

```
The balance is: $100
Rio is accessing the bank.
Denver is accessing the bank.
Tokyo is accessing the bank.
Tokyo successfully withdrew $6
Denver successfully withdrew $49
Rio successfully withdrew $20
Tokyo successfully withdrew $6
Denver failed to withdraw $49.
Rio failed to withdraw $20.
Tokyo successfully withdrew $6
Rio failed to withdraw $20.
Denver is leaving the bank, the balance is $13
Tokyo successfully withdrew $6
Rio failed to withdraw $20.
Tokyo successfully withdrew $6
Rio failed to withdraw $20.
Tokyo failed to withdraw $6.
Rio is leaving the bank, the balance is $1
Tokyo is leaving the bank, the balance is $1
```

In some cases though, some strange behaviour is produced by this **race condition**:

```
Denver is accessing the bank.
Tokyo is accessing the bank.
The final balance is: $100
Rio is accessing the bank.
Rio successfully withdrew $20
Tokyo successfully withdrew $6
Denver successfully withdrew $49
Tokyo successfully withdrew $6
Denver failed to withdraw $49.
Rio successfully withdrew $20
Rio failed to withdraw $20.
Denver is leaving the bank, the balance is -1
Tokyo failed to withdraw $6.
Rio failed to withdraw $20.
Tokyo failed to withdraw $6.
Rio failed to withdraw $20.
Tokyo failed to withdraw $6.
Tokyo failed to withdraw $6.
Rio is leaving the bank, the balance is -1
Tokyo is leaving the bank, the balance is -1
```

Use the Singleton Pattern to ensure that only one person can access the bank at a time. You can assume for simplicity's sake that only one access to *any* bank account can ever be made at a given time.
> See [solutions/src/heist](solutions/src/heist/)

## C. Evolution of Requirements
This exercise continues on from Exercise D of last week.

Suppose a requirements change was introduce that necessitated support for different sorts of armour.

- A helmet reduces the amount of damage inflicted upon a character by 1 point.
- Chain mail reduces the amount of damage by half (rounded down).
- A chest plate caps the amount of damage to 7, but also slows the character down. If the character is otherwise capable of moving more than one square at a time then this armour restricts each move to distances of 3 squares or less (by manhattan distance).

Use the Decorator Pattern to realise these new requirements. Assume that, as this game takes place in a virtual world, there are no restrictions on the number of pieces of armour a character can wear and that the "order" in which armour is worn affects how it works. You may need to make a small change to the existing code.
> See [solutions/src/thrones](solutions/src/thrones/)

## D. Observer Pattern
In `src/youtube`, create a model for the following requirements of a Youtube-like video creating and watching service using the Observer Pattern:
- A Producer has a name, a series of subscribers and videos
- When a producer posts a new video, all of the subscribers are notified that a new video was posted
- A User has a name, and can subscribe to any Producer
- A video has a name, length and producer

Write a simple test with print statements inside `YoutubeTest.java`.

Once this is done, think about what if we want to be able to produce videos and subscribe to videos as well (the way youtube actually works). In groups, draw a UML diagram refactoring the code so that the `Producer` and `User` classes are merged, whilst still using the Observer Pattern.
> See [solutions/src/youtube](solutions/src/youtube/)
