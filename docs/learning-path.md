# Learning Path

This document describes the recommended order for reading examples in this repository.
Each step builds on the previous one.

---

## Step 1 — OOP Basics

**Package:** `src/oop/basics/`

Start here to understand the fundamental building blocks of Java classes.

| File | What it demonstrates |
|------|----------------------|
| `PrivateAccessModifierExample.java` | `private` modifier — class accessing its own private members |
| `StaticVsInstanceExample.java` | `static` vs instance variables — class-level vs object-level state |
| `ConstructorExample.java` | Constructors with parameters, static initializer block |

---

## Step 2 — Inheritance & Polymorphism

**Package:** `src/oop/inheritance/`

| File | What it demonstrates |
|------|----------------------|
| `InheritancePolymorphismExample.java` | Subclassing, method overriding, upcasting, downcasting, field shadowing |
| `SuperKeywordExample.java` | `super` field and method access, field shadowing vs method polymorphism |

---

## Step 3 — Abstract Classes

**Package:** `src/oop/abstraction/`

| File | What it demonstrates |
|------|----------------------|
| `AbstractClassExample.java` | Abstract class + Template Method pattern |
| `AbstractClassChain.java` | 3-level abstract inheritance chain — deferred implementation |
| `AbstractVsInterfaceExample.java` | In-depth abstract class: upcasting, downcasting, field shadowing, anonymous subclass |

---

## Step 4 — Interfaces

**Package:** `src/oop/interfaces/`

Read in this order:

| File | What it demonstrates |
|------|----------------------|
| `DoItInterface.java` | Interface constants, abstract methods, static methods, default methods |
| `ValidInterface.java` | Interface extending another interface (marker interface) |
| `InterfaceUsageExample.java` | Implementing an interface hierarchy, interface constant access |
| `InterfaceA.java` / `InterfaceB.java` | Two interfaces with conflicting default methods |
| `MultipleInterfaceExample.java` | Multiple interface implementation, diamond problem resolution |

---

## Step 5 — Nested Classes

**Package:** `src/oop/nestedclasses/`

| File | What it demonstrates |
|------|----------------------|
| `InnerVsStaticNestedExample.java` | Non-static inner class vs static nested class |
| `AnonymousClassExample.java` | Anonymous class vs local (named) class |
| `LocalClassExample.java` | Local class, effectively-final variable capture |

---

## Step 6 — Enums

**Package:** `src/enums/`

| File | What it demonstrates |
|------|----------------------|
| `EnumWithFieldExample.java` | Enum with constructor and field — attaching data to constants |
| `EnumComparisonExample.java` | `==` vs `.equals()` for enum comparison, type safety |

---

## Step 7 — Exception Handling

**Package:** `src/exceptions/`

| File | What it demonstrates |
|------|----------------------|
| `FinallyBlockExample.java` | `finally` always runs, even when `catch` re-throws |
| `CheckedExceptionExample.java` | Checked vs unchecked exceptions, `throws` declaration |

---

## Step 8 — Generics

**Package:** `src/generics/`

Read in this order:

| File | What it demonstrates |
|------|----------------------|
| `GenericBoxExample.java` | Basic generic class with one type parameter `<T>` |
| `TwoTypeParameterExample.java` | Generic class with two type parameters `<K, V>` |
| `BoundedTypeParameterExample.java` | `<T extends Comparable<T>>` — bounded type parameter |
| `WriterInterface.java` | Generic interface definition |
| `GenericInterfaceExample.java` | Generic class implementing a generic interface |

---

## Step 9 — Collections

**Package:** `src/collections/`

| File | What it demonstrates |
|------|----------------------|
| `ListExample.java` | `ArrayList` — ordered, allows duplicates, index-based access |
| `SetExample.java` | `HashSet` — no duplicates, allows null, unordered |
| `MapExample.java` | `HashMap`, `LinkedHashMap`, `TreeMap` — ordering comparison |
| `HashMapCollisionDemo.java` | HashMap internals — hash collision, hashCode + equals contract |

---

## Step 10 — Lambda & Functional Programming

**Package:** `src/functional/`

| File | What it demonstrates |
|------|----------------------|
| `LambdaEvolutionExample.java` | Named class → lambda → Stream API progression |
| `LambdaScopeExample.java` | Lambda variable scoping, `this` vs outer `this`, effectively-final |

---

## Step 11 — Annotations & Reflection

**Package:** `src/annotations/`

Read in this order:

| File | What it demonstrates |
|------|----------------------|
| `JsonNameAnnotation.java` | Defining a custom annotation with `@Retention` and `@Target` |
| `JsonNameProcessor.java` | Reading annotations at runtime with reflection |
| `AnnotationUsageExample.java` | Using the annotation on a class and field, running the processor |

---

## Step 12 — Concurrency & Synchronization

**Package:** `src/concurrency/`

| File | What it demonstrates |
|------|----------------------|
| `SynchronizedMethodExample.java` | `synchronized` instance vs static method — object lock vs class lock |
| `SynchronizedBlockExample.java` | `synchronized` block — different lock objects, concurrent vs serialized |
| `SynchronizationExperiment.java` | All three locking strategies compared side by side |
| `SingletonPattern.java` | Thread-safe Singleton — double-checked locking + `volatile` |

---

## Step 13 — Experiments

**Package:** `src/experiments/`

These are not canonical examples. Browse them for additional context:

| Sub-package | Contents |
|-------------|----------|
| `algorithms/` | LeetCode sliding window solution |
| `accessmodifier/` | HackerRank private inner class challenge |
| `functional/` | HackerRank lambda expressions challenge |
| `collections/` | Direct `AbstractList`/`Set`/`Map` anonymous subclass exploration |
| `interfaces/` | Structural vs nominal typing exploration (incomplete) |
| `scratch/` | One-off experiments (`Arrays.asList`, `++i` vs `i++`) |
| `tools/` | SonarLint IDE plugin smoke test |
| `git/` | Git operations practice artifact |
