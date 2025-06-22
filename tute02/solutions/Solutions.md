# Tutorial 02

## A. Code Review

Your tutor will provide you a link or open up the `src/shapes`, and use the `Shape` and `Rectangle` classes.

In groups, analyse the classes to answer the following questions:

### `super` vs `this`

1. What is the difference between `super` and `this`?
2. What about `super(...)` and `this(...)`?
3. What will the `main` code in `Rectangle print and why?
   > 1. `super`: The instance of the super class
   >    `this`: The instance of this class (like self in python)
   > 2. `super(...)` Runs the respective method in the super class
   >    `this(...)` Runs the respective method in this class with the given parameters (used for method overloading)
   > 3. It will go into the `Rectangle` constructor with 3 arguments, which will then call the `Rectangle` constructor with 1 argument, which finally calls the `Shape` constructor

### Abstract Classes vs Interfaces

4. What is the purpose of using an abstract class in this code?
5. What are some downsides of the use of the abstract class here?
6. What is the difference between an abstract class and an interface? Why would you use one or the other?
   > 4. It allows the user to enforce the inclusion of a method `getArea` without having to define a default implementation, forcing subclasses to provide an implementation
   > 5. We can run into the diamond inheritance problem, which means that Java forces us to only be able to inherit from one class (including abstract classes)
   > 6. An interface cannot provide _any_ implementation or fields - only methods which need to exist in classes which implement the interface. On the other hand, abstract classes can provide some implementations of methods and have fields, with the _option_ to not provide implementation of some (or all) methods.
   >    You use an interface to allow multiple inheritance of method names (but not implementation), and you use abstract classes wherever you want to have an inheritance structure where some implementation is provided in a super class

### `static` keyword

7. Can you override a static method?
8. What is the output of running `r2.getArea()` in `main`?
9. What is the output of running `Shape.getCount()` in `main`?
   > 7. No - the method is attached to the class, not the instance.
   > 8. It will print 400, making use of the `Shape` constructor as it always will use the runtime type of the object, not the pointer type's method
   > 9. It will print 2 as each constructor call updates the static `count`, which is shared across instances. Hence, the first one updates 0 to 1, and the second updates 1 to 2. This is in contrast to non-static variables which have different values across instances - in that case, the count would be 1 for the two separate instances.

## B. JavaDoc & Commenting

Within the `src` directory, you have been provided with an `Employee` class, where an employee has a name and salary.

The class has been documented with [JavaDoc](https://www.oracle.com/au/technical-resources/articles/java/javadoc-tool.html).

In this course we are not going to require that you write JavaDoc, except when specified.

- What are the main features of JavaDoc present in Employee.java?

  > Just discuss as it pertains to Employee.java (params, return types)

- What is meant by the term "self-documenting code"?

  > Code that documents itself - it is readable inherently, through use of meaning variable and function names.

- Discuss as a class whether code should always have comments / JavaDoc
  > Comments can go stale - the code is updated but the comment remains the same, meaning they become irrelevant/misleading
  >
  > It could be argued that the requirement for a comment means that the code is not self-documenting (i.e. is not readable enough).
  >
  > Rule of thumb - is the code understandable to someone who has never seen the code before, who is at the same level as you? This can become a bit blurry when there is very domain-specific code and you have to understand the domain (what the code is trying to achieve) to understand the code, no matter how well your variables are named. Comments can be helpful here. Food for thought.

## C. Basic Inheritance & Polymorphism

This exercise continues on from the `Employee` class in Exercise B.

Create a `Manager` class that is a subclass of `Employee` and has a field for the manager's hire date.

> See [`Manager.java`](solutions/employee/Manager.java)

Use VSCode to create the getters and setters.

- What constructors are appropriate?

  > Because we are inheriting from Employee, Java forces us to write a constructor that calls `super(...)`, so we have to write at least one. In this case, it makes sense to have a constructor that takes the name, salary and hire date, but you could also argue there should be one that just takes the name and salary and sets the hire date to the current day. It depends on context of how the class will be used whether you want the former, the latter, or both constructors.

- Is it appropriate to have a getter for the hire date? What about a setter?

  > One can assume that if the hire date is stored it is information that will be needed at some point, so a getter is necessary. However, unlike the name or salary, it is unlikely that the hire date will be updated, so a setter would only serve to break that reasonable assumption about the class.

- Why might adding certain getters and setters be bad design?
  > Getters and setters can break encapsulation, especially when they are used to get and set inappropriate fields. It should be emphasised to students that they should be created only when strictly needed.

## D. toString and Equals

This exercise continues on from the work in Exercise C.

Override the `toString()` method inherited from `Object` in both classes.

> See [`Manager.java`](solutions/employee/Manager.java) and [`Employee.java`](solutions/employee/Employee.java)

- What should the result of `toString()` contain?

  > The [documentation](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#toString--) for the `toString()` method states that it should return a string that "textually represents" the object. In this case, it should contain the name, salary and hire date (in the case of `Manager`), but also the runtime class of the object.

- Does the method in `Manager` call the one in `Employee`?
  > In order to satisfy the above requirement and not introduce unnecessary repetition, the superclass method must be called.

We will now look at equality checks in Java.

- What does the `==` operator do when comparing objects?

  > Compares the objects references. I.e., the result will be true if and only if the two objects being compared are the same instance. Only use this when you want to compare by reference.

- Where have you seen this sort of behaviour before in other languages? How is the underlying data checked for equality in that scenario?

  > This is similar to strings in C. We don’t use `==` with strings in C as this compares the pointers to the start of each string. To compare the contents of the string for equality, we’d use `strcmp()`.

- How can we compare two objects for equality?

  > Using the `equals()` method, a method that comes from the `Object` class and is therefore inherited by every other class with the ability to be overridden.

- What does it mean for objects to be considered equal?

  > There’s a formal definition for what the `equals()` method needs to do as defined by the documentation. As long as the implementation adheres to those properties, then you could define equality for your set of objects in any way that makes sense for your purpose. However, the most common way is to compare all of the fields of the object to see if they are equal, i.e., comparing the contents of the objects in a similar way to how strings are compared in C. That is `Employee`s will be considered equal if their fields are equal.

- What is the relationship between a super type and a sub type in terms of equality? Can a concrete instance of an `Employee` be equal to an instance of a `Manager`
  > Although a subtype can also be treated as the supertype, they are inherently unequal. A subtype is a more specific version and hence can’t be treated as an equal to a concrete instance of the supertype. In this example, a `Manager` is a more specific version of an `Employee` with additional fields. However, even if the `Manager` did not have additional fields, there should be something that the `Manager` does to differentiate it from the `Employee`. That is a `Manager` and an `Employee` with the same data in their fields, should still be considered unequal.

Override the `equals()` method inherited from `Object` in both classes.

- What key things should the `equals()` method do?

  > Typical Structure of the equals method will include:
  >
  > - Check that the passed in object is not null.
  >   - `if (object == null) return false`
  > - Check if the passed in object is the same instance as the calling object.
  >   - `if (this == object) return true`
  > - Check the concrete type of the calling object matches the concrete type of the passed in object.
  >   - `if (!this.getClass().equals(object.getClass())) return false`
  >   - Note this is the robust way to allow subclasses to invoke `super.equals()`.
  > - Once confirmed that the passed in object is of the same type (so it can be cast safely), cast the passed in object to the same type as the current class so the fields of that class can be compared between the calling object and the passed in object.

- How should the type of the input object be checked? How should it be compared to the type of the calling object?

  > **Do not use** `instanceof` to check the types of objects in the `equals()` method.
  >
  > Get the concrete type of any object by calling its `getClass()` method. This will give you the runtime type of the object, regardless of what the type is of the variable that it is stored in. Use `getClass()` on the calling object (`this`) and on the passed in object and compare the results for equality to see if both objects have the same type.

- How can the method in `Manager` utilise code in `Employee` to avoid repetition?
  > In the `equals()` method for the `Manager` we can call `super.equals(object)` to check if the Employee parts of the passed in `Object` are equal to that of the calling `Manager` so we don’t have to rewrite all of the field comparisons in the `Manager` class. The subclass may also not have access to the fields in the super class, and there may not be getters to retrieve them, so you’d have to call `super.equals(object)`. We don’t want to have to expose stuff to our subclass if we don’t have to, so being able to call the `equals` method defined in the superclass gives us the best design and allows for code reuse.
  >
  > Note that `super.equals()` still has to check that the passed in object matches the type of the calling object, but the calling object is now a `Manager` and the code that is being run is the equals method that was written in the `Employee` class. Despite being written in the `Employee` class, the code `this.getClass()` actually gives us a Manager because this is referring to the calling object, not the class. So, `this.getClass()` gets us the runtime type of the calling object which in this case is a Manager

## E. Access Modifiers & Packages

In the [src/access](src/access/) package, answer the questions marked `TODO`.

> See code [here](solutions/access/)
>
> ![](solutions/image.png)
