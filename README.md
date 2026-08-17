# Java Learning Project

A personal Java learning repository containing examples, experiments, and notes
covering core Java concepts from OOP fundamentals to concurrency.

All examples use plain Java — no frameworks, no build tools required beyond a JDK.
Each example is self-contained with a `main()` method you can run directly.

---

## Who is this for?

Anyone learning Java who wants practical, runnable examples organized by concept.
Comments throughout the code are written in Vietnamese (the author's native language).

---

## Requirements

- Java 8 or higher (most examples)
- Java 21 for the virtual thread experiment in `exceptions/CheckedExceptionExample.java`
- IntelliJ IDEA (the project is configured as a plain IDEA module)

---

## Project Structure

```
src/
├── oop/
│   ├── basics/           Static vs instance, constructors, access modifiers
│   ├── inheritance/      Inheritance, polymorphism, super keyword
│   ├── abstraction/      Abstract classes, template method pattern
│   ├── interfaces/       Interfaces, default methods, diamond problem
│   └── nestedclasses/    Inner, static nested, anonymous, local classes
│
├── enums/                Enum with fields, enum comparison and type safety
├── exceptions/           Checked vs unchecked, finally block
├── generics/             Generic classes, methods, bounded type parameters
├── collections/          List, Map, Set, HashMap collision internals
├── functional/           Lambda expressions, scoping, evolution from anonymous classes
├── annotations/          Custom annotations, runtime processing via reflection
├── concurrency/          Synchronized methods/blocks, locks, Singleton pattern
│
└── experiments/
    ├── algorithms/       LeetCode practice (sliding window)
    ├── accessmodifier/   HackerRank private inner class solution
    ├── collections/      AbstractList/Set/Map exploration
    ├── functional/       HackerRank lambda solution
    ├── interfaces/       Structural vs nominal typing experiment
    ├── tools/            SonarLint IDE plugin test
    ├── git/              Git operations practice artifact
    └── scratch/          Small one-off code experiments
```

---

## Learning Path

Follow this order for the best progression from fundamentals to advanced topics:

| Step | Topic | Package |
|------|-------|---------|
| 1 | OOP Basics — static, constructors, access modifiers | `src/oop/basics/` |
| 2 | Inheritance & Polymorphism | `src/oop/inheritance/` |
| 3 | Abstract Classes | `src/oop/abstraction/` |
| 4 | Interfaces | `src/oop/interfaces/` |
| 5 | Nested Classes | `src/oop/nestedclasses/` |
| 6 | Enums | `src/enums/` |
| 7 | Exception Handling | `src/exceptions/` |
| 8 | Generics | `src/generics/` |
| 9 | Collections | `src/collections/` |
| 10 | Lambda & Functional Programming | `src/functional/` |
| 11 | Annotations & Reflection | `src/annotations/` |
| 12 | Concurrency & Synchronization | `src/concurrency/` |
| 13 | Experiments | `src/experiments/` |

See [`docs/learning-path.md`](docs/learning-path.md) for a detailed breakdown of each topic.

---

## How to Run Examples

Each file has a `main()` method. In IntelliJ IDEA:

1. Open the file
2. Click the green ▶ button next to `main()`
3. View output in the Run console

Or from the command line (from project root):
```bash
javac -d out src/oop/basics/StaticVsInstanceExample.java
java -cp out oop.basics.StaticVsInstanceExample
```

---

## Documentation

Per-topic documentation lives in `docs/`:

- [`docs/learning-path.md`](docs/learning-path.md)
- [`docs/oop/README.md`](docs/oop/README.md)
- [`docs/generics/README.md`](docs/generics/README.md)
- [`docs/collections/README.md`](docs/collections/README.md)
- [`docs/functional/README.md`](docs/functional/README.md)
- [`docs/enums/README.md`](docs/enums/README.md)
- [`docs/exceptions/README.md`](docs/exceptions/README.md)
- [`docs/annotations/README.md`](docs/annotations/README.md)
- [`docs/concurrency/README.md`](docs/concurrency/README.md)

---

## Experiments

The `src/experiments/` directory contains code that is NOT canonical learning material:

- HackerRank / LeetCode submissions
- IDE plugin tests
- One-off scratch experiments
- Incomplete explorations

These are preserved for reference but should not be treated as examples to follow.
