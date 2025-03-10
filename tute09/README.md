# Tutorial 09
## A. Finding Patterns
In groups, determine a possible pattern that could be used to solve each of the following problems:

- Sorting collections of records in different orders.
- Listing the contents of a file system.
- Traversing through a linked list without knowing the underlying representation.
- Updating a UI component when the state of a program changes.
- Allowing users to remap their movement controls to different buttons on a game controller.
- Creating a skeleton implementation for a payment processing algorithm that varies in logic based on the type (e.g. credit card, PayPal)
- A frozen yogurt shop model which alters the cost and weight of a bowl of frozen yogurt based on the toppings that customers choose to add before checkout.

Then pick one and start to think about potential entities and draw up a rough UML diagram.

## B. Code and Design Smells
In groups, discuss the following examples. Identify the code smells and any underlying design problems associated with them.

a)

> Mark, Bill and Jeff are working on a PetShop application. The PetShop has functionality to feed, clean and exercise different types of animals. Mark notices that each time he adds a new species of animal to his system, he also has to rewrite all the methods in the PetShop so it can take care of the new animal.

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

c)

```java
public class MathLibrary {
    List<Book> books;

    int sumTitles() {
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

Now discuss as a class:

- How do these code smells cause problems when developing code?

- Is a code smell always emblematic of a design problem?

## C. Visitor Pattern
In this scenario we have `Computer`s, `Keyboard`s and `Mouse`s which all are of type `ComputerComponent`. We want to be able to 'visit' different types of Computer components by logging the following messages:

```
Looking at computer Corelli with memory 500 GB.
Looking at keyboard Mechanical keyboard which has 36 keys.
Looking at mouse Bluetooth mouse.
```

In particular though, anyone which is visiting a `Computer` must be **validated** prior to being able to visit.

Extend/modify the starter code to use the Visitor Pattern to allow different computer components to be visited.

## D. Revision Exercises
Complete some of the Theory Revision questions [here](https://cgi.cse.unsw.edu.au/~cs2511/redirect/?path=COMP2511/25T1/students/_/revision-exercises).
