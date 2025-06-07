# Tutorial 03
## A. Design by Contract
1. What is Design by Contract?
> Providing an interface for others to use with clear preconditions, postconditions and invariants which, when adhered to, guarantees correct and expected behaviour

2. Discuss how Design By Contract was applied in assignment-i.
> Key things to note:
>
> - Interface functions have been specified in `Blackout`. As long as you match that interface, you can implement the function however you choose.
>
> - You have been told you don't have to account for invalid Satellite/Device IDs, and that no 2 devices would ever occupy the same position. These are examples of preconditions which you don't have to account for (the behaviour of the ADT is undefined in these cases).

3. Discuss what preconditions, postconditions and invariants are.
> Preconditions - conditions on the inputs which guarantee postconditions will be true
>
> Postconditions - guarantees from the actual software on what you can expect from a function (given preconditions)
>
> Invariants - guarantees from the actual software that are always maintained before and after a function call
> (they may not always hold *during* the function call, but the user shouldn't need to worry about that)

4. Consider a `Bird` class which has a function `fly`, which has a precondition that it is given a height to fly at greater than 5 metres in height, and a postcondition that it is now considered flying at that height. If I have a `Penguin` class which overrides that the `fly` method so that its preconditions are that it can only accept a height of 0 metres (since penguins can't fly) and its postconditions are that nothing changes, I have
    - *strengthened* my preconditions, as not every potential input for `Bird` works for `Penguin` (in fact, none of them do)
    - *weakened* my postconditions, as `Penguin` has an outcome which `Bird` doesn't
Discuss why strengthening preconditions and weakening postconditions violates good inheritance design
> - Strengthening preconditions violates LSP, as if I replaced a `Bird` with a `Penguin`, any calls to fly with an input of 5 metres will no longer be valid
> - Similarly, weakning postconditions violates LSP as replacing a `Bird` with a `Penguin` means that the object is no longer considered flying, which can break further code which relies on it now flying

5. In the `people` package, there are a few classes which represent the people at a university
    - Briefly discuss the preconditions and postconditions of the constructors, getters and setters in `Person.java`
    - Fill in the preconditions and postconditions for `setSalary` in `Person.java`
    - Discuss the validity of the subclasses of `Person`, and why they are/aren't valid subclasses
    - Fix any issues you identified before
> See [`people`](src/people/Person.java)

6. Will you need to write unit tests for something that doesn't meet the preconditions? Explain why.
> No, as the point is that inputs which don't meet the preconditions are not accounted for

7. If we were to try make our code more defensive, we could throw an exception on any inputs not satisfying the preconditions. Discuss whether these exceptions are now considered defined behaviour or not, and whether you now need to account for it in your postconditions.
> When you update your postconditions, include the possible exception cases Note that exception cases are still cases for which the preconditions aren't met - this is the subject of a bit of debate, because technically exceptional behaviour is 'accounted for' and defined which means the preconditions (user of the ADT) don't have to worry about it, but also looking at it from a formal 'proving-things about programs' perspective, an input which causes an exception to be raised doesn't map to an output, which means it's not formally 'defined' behaviour. So what this essentially means is that an input that doesn't meet the 'correct' preconditions will cause an exception to be raised (in a defensive programming style) but the behaviour of the ADT is still defined.
>
> From a library-writing perspective this sort of 'contract except I tell you where you went wrong you if you mess up' style of design is useful for 2 reasons. One is that it prevents weird stuff from happening that breaks everything, and the second is that it helps users of the ADT debug their code. Just like how when you enter jibberish on a date field in a web form it says 'error: invalid date' etc etc instead of a 500 Internal Server Error, or when you divide by 0 in Python or Java you get a ZeroDivisionError, rather than some message from the OS.

## B. Domain Modelling
In this problem, we are going to create an Object-Oriented domain model for a system with the following requirements.

With success in student projects like Sunswift and Redback, UNSW have decided that they would like to build a system that can show all of the student-built cars (and others) that they have in order to showcase to prospective students interested in STEM and attract students from other universities. They have asked you, as a designer, to produce a model for what this system will look like.

### Requirements
A Car has one or more engines and a producer. The producer is a manufacturing company who has a brand name. Engines are produced by a manufacturer and have a speed. There are only two types of engines within UNSW's cars:

- **Thermal Engines**, which have a default max speed of 114, although they can be produced with a different max speed, and the max speed can change to any value between 100 and 250.
- **Electrical Engines**, which have a default max speed of 180. This is the speed at which they are produced, and the max speed can change to any value that is divisible by 6.

Cars are able to drive to a particular location `x`, `y`.

Since UNSW is a world-leader in technology innovation, they want you to be able to model the behaviour of Time Travelling for *any* vehicle, and to model a time travelling car. A vehicle that travels in time *stays in the same location* but travels to a `LocalDateTime`.

**Create a UML diagram which models the domain**.

During the lab, you will build on this UML diagram to incorporate further requirements.
> See [solution image](solutions/tute03-soln.png)

## C. Wondrous
The **Wondrous Sequence** is generated by the simple rule:

- If the current term is even, the next term is half the current term.
- If the current term is odd, the next term is three times the current term, plus 1.

For example, the sequence generated by starting with `3` is:

```txt
3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
```

If the starting term is `1`, then an empty list is returned.

Inside `src/wondrous/Wondrous.java` there is an implementation of this algorithm. Inside `src/wondrous/test/WondrousTest.java` there is a single test for the function. The test currently fails.

### Part 1 - IDE Programming
Explore the IDE tools built into VSCode:
1. Put a breakpoint on line 13 and run the tests in Debug Mode.
2. Briefly discuss different features of Debug Mode:
    - The variables section
    - The debug console
    - The 'watch' section
    - The call stack
    - Debug control
3. Use the debug tools and the given algorithm to determine why the test is failing, and fix the bug.
> See [`Wondrous.java`](solutions/src/wondrous/Wondrous.java) and [`WondrousTest.java`](solutions/src/wondrous/test/WondrousTest.java)

### Part 2 - Writing Tests with JUnit
There is a further bug in the function not caught by the given unit test. Find the other bug, and write a corresponding unit test inside `WondrousTest`.

[You can learn more about JUnit here](https://www.vogella.com/tutorials/JUnit/article.html).

### Part 3 - Exceptional Conditions
Modify the method such that if `start` is less than 1, an `IllegalArgumentException` is thrown. Write a corresponding test for this inside `WondrousTest`.

In many cases when we throw an exception we need to update the method signature and existing tests but here we don't - why is this?
> See [Why is it not necessary to catch the IllegalArgumentException?](https://stackoverflow.com/questions/19190280/why-is-it-not-necessary-to-catch-the-illegalargumentexception/19190346)
