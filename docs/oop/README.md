# OOP — Object-Oriented Programming

## What is this topic?

OOP is the foundation of Java. Everything in Java is organized around classes and objects.
This section covers the core pillars: encapsulation, inheritance, abstraction, and polymorphism.

---

## Sub-topics

### Basics (`src/oop/basics/`)

Fundamental class mechanics before getting into relationships between classes.

| Concept | Description |
|---------|-------------|
| Access modifiers | `private` restricts access to within the class |
| Static vs instance | `static` fields/methods belong to the class; instance fields belong to each object |
| Constructors | Initialize object state; static blocks run once on class load |

### Inheritance (`src/oop/inheritance/`)

| Concept | Description |
|---------|-------------|
| `extends` | A subclass inherits all non-private members of its parent |
| Method overriding | Subclass provides its own version of a parent method |
| Runtime polymorphism | The actual method called is determined by the object's runtime type, not the reference type |
| Field shadowing | Fields are NOT polymorphic — access uses the reference type |
| Upcasting | `Animal a = new Cat()` — widen to parent type |
| Downcasting | `Cat c = (Cat) a` — narrow back to the subtype (unsafe if type is wrong) |
| `super` | Access parent fields/methods explicitly from within a child class |

### Abstraction (`src/oop/abstraction/`)

| Concept | Description |
|---------|-------------|
| Abstract class | Cannot be instantiated; may have abstract (no body) and concrete methods |
| Abstract method | Subclasses MUST provide an implementation |
| Template Method pattern | Abstract parent defines the algorithm skeleton; subclasses fill in the steps |
| Abstract chain | An abstract class can extend another abstract class without implementing its methods |

### Interfaces (`src/oop/interfaces/`)

| Concept | Description |
|---------|-------------|
| Interface | Pure contract — defines what a class can do, not how |
| Interface constants | `public static final` implicitly |
| Abstract methods | Implementing classes must provide all implementations |
| Default methods (Java 8+) | Concrete method on an interface with a fallback implementation |
| Static methods (Java 8+) | Utility methods on the interface itself |
| Interface inheritance | An interface can `extend` another interface |
| Multiple implementation | A class can `implement` multiple interfaces |
| Diamond problem | When two interfaces declare the same default method — implementor must override |

### Nested Classes (`src/oop/nestedclasses/`)

| Concept | Description |
|---------|-------------|
| Non-static inner class | Tied to an outer instance; can access all outer members |
| Static nested class | Independent of outer instance; can only access outer static members |
| Anonymous class | One-shot implementation of an interface or abstract class, defined inline |
| Local class | Named class defined inside a method; can capture effectively-final local variables |

---

## Examples

| Example | Location | What it demonstrates |
|---------|----------|----------------------|
| `PrivateAccessModifierExample` | `oop/basics/` | private constructor, field, method |
| `StaticVsInstanceExample` | `oop/basics/` | static shared state vs per-object state |
| `ConstructorExample` | `oop/basics/` | constructor parameters, static init block |
| `InheritancePolymorphismExample` | `oop/inheritance/` | full inheritance + polymorphism demo |
| `SuperKeywordExample` | `oop/inheritance/` | super keyword, field vs method polymorphism |
| `AbstractClassExample` | `oop/abstraction/` | template method pattern |
| `AbstractClassChain` | `oop/abstraction/` | 3-level abstract inheritance chain |
| `AbstractVsInterfaceExample` | `oop/abstraction/` | abstract class in depth |
| `DoItInterface` | `oop/interfaces/` | all four interface member types |
| `MultipleInterfaceExample` | `oop/interfaces/` | diamond default method resolution |
| `InnerVsStaticNestedExample` | `oop/nestedclasses/` | inner class vs static nested class |
| `AnonymousClassExample` | `oop/nestedclasses/` | anonymous vs local class |
| `LocalClassExample` | `oop/nestedclasses/` | local class, effectively-final capture |

---

## Learning Order

1. `oop/basics/` — understand a single class first
2. `oop/inheritance/` — understand class relationships
3. `oop/abstraction/` — understand abstract design
4. `oop/interfaces/` — understand contracts
5. `oop/nestedclasses/` — understand class nesting patterns

---

## Abstract Class vs Interface — Quick Reference

| | Abstract Class | Interface |
|--|----------------|-----------|
| Instance fields | Yes | No (only constants) |
| Constructor | Yes | No |
| Multiple inheritance | No (single extends) | Yes (multiple implements) |
| Default method body | Yes (concrete methods) | Yes (default keyword, Java 8+) |
| When to use | Shared state + partial implementation | Pure contract / behavior |
