# Tutorial 09
## A. Finding Patterns
In groups, determine a possible pattern that could be used to solve each of the following problems:

- Sorting collections of records in different orders.
> Strategy pattern. This what Java does with the `Collections.sort()` method. A `Comparator` can be provided to determine the order in which elements are sorted.

- Listing the contents of a file system.
  > Composite pattern. Both folders and files are filesystem entries. Files form the leaves, folders can contain files or other folders.

- Traversing through a linked list without knowing the underlying representation.
  > Iterator pattern. An iterator can be written and the collection can be traversed using iterator.next().

- Updating a UI component when the state of a program changes.
  > Observer pattern. If the state of the program is the subject and the UI an observer, the UI will be notified of any changes to the state and update accordingly.

- Allowing users to remap their movement controls to different buttons on a game controller.
  > Command pattern. Each action (e.g. "jumping") needs to be decoupled from the source of input into its own object.

- Creating a skeleton implementation for a payment processing algorithm that varies in logic based on the type (e.g. credit card, PayPal)
  > Template pattern. The template implements the common parts of the payment processing, and call on subclasses like card and PayPal which would implement the parts that differ.

- A frozen yogurt shop model which alters the cost and weight of a bowl of frozen yogurt based on the toppings that customers choose to add before checkout.
  > Decorator pattern. Toppings (new behaviours) are added dynamically at runtime by users (customers).

Then pick one and start to think about potential entities and draw up a rough UML diagram.

## B. Code and Design Smells
In groups, discuss the following examples. Identify the code smells and any underlying design problems associated with them.

a)

> Mark, Bill and Jeff are working on a PetShop application. The PetShop has functionality to feed, clean and exercise different types of animals. Mark notices that each time he adds a new species of animal to his system, he also has to rewrite all the methods in the PetShop so it can take care of the new animal.
> Code smell - Divergent change
>
> Design problem - Open Closed Principle, high coupling

b)

```java
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private String streetAddress;
    private String suburb;
    private String city;
    private String country;
    private int postcode;

    public Person(String firstName, String lastName, int age, int birthDay, int birthMonth, int birthYear,
            String streetAddress, String suburb, String city, String country, int postcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.streetAddress = streetAddress;
        this.suburb = suburb;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
    }
    // Some various methods below
    // ....
}
```
> Data clumps, long parameter list
>
> Refactor by making more classes for birthday and address ("Extract Class"/ "Introduce Parameter Object")
>
> Design problem - DRY and KISS

c)

```java
public class MathLibrary {
    List<Book> books;

    int sumTitles {
        int total = 0
        for (Book b : books) {
            total += b.title.titleLength;
        }
        return total;
    }
}

public class Book {
    Title title; // Our system just models books as titles (content doesn't matter)
}

public class Title {
    int titleLength;

    int getTitleLength() {
        return titleLength;
    }

    void setTitleLength(int tL) {
        titleLength = tL;
    }
}
```
> Some examples of code smells you can talk about
>
> - Inappropriate intimacy (accessing public fields)
> - Message chains - students might bring up Law of Demeter here
> - Data classes/Lazy classes
>   Design smell - High coupling, from encapsulation being broken\
>   Fixes - make things private, just delete the classes and represent titles as strings

Now discuss as a class:

- How do these code smells cause problems when developing code?
  > Discuss concepts like reusability, maintainability, extensibility (how fast does it take a new developer to understand what is happening)\
  > Note how b and c are opposite problems (not enough classes vs too many classes) - you can take any refactoring too far

- Is a code smell always emblematic of a design problem?
  > No - e.g "switch statements" and "comments" are often listed as code smells but are not always actually smells

## C. Visitor Pattern
In this scenario we have `Computer`s, `Keyboard`s and `Mouse`s which all are of type `ComputerComponent`. We want to be able to 'visit' different types of Computer components by logging the following messages:

```
Looking at computer Corelli with memory 500 GB.
Looking at keyboard Mechanical keyboard which has 36 keys.
Looking at mouse Bluetooth mouse.
```

In particular though, anyone which is visiting a `Computer` must be **validated** prior to being able to visit.

Extend/modify the starter code to use the Visitor Pattern to allow different computer components to be visited.
> See [solution](solutions/src/)

## D. Revision Exercises
Complete some of the Theory Revision questions [here](https://cgi.cse.unsw.edu.au/~cs2511/redirect/?path=COMP2511/25T1/students/_/revision-exercises).
> Solutions are in the repo
