# Lambda & Functional Programming

## What is this topic?

Java 8 introduced lambda expressions, which allow you to treat behavior as data —
passing functions as arguments without the boilerplate of anonymous classes.

---

## Concepts

| Concept | Description |
|---------|-------------|
| Functional interface | Any interface with exactly ONE abstract method (`@FunctionalInterface`) |
| Lambda expression | `(params) -> body` — a concise anonymous function |
| Method reference | `ClassName::method` — shorthand for a lambda that just calls a method |
| `java.util.function` | Built-in functional interfaces: `Predicate<T>`, `Function<T,R>`, `Consumer<T>`, `Supplier<T>` |
| Effectively final | A local variable captured by a lambda cannot be reassigned after capture |
| `this` in lambda | Refers to the ENCLOSING class instance, not the lambda itself |
| Stream API | Fluent API for processing collections: `filter`, `map`, `forEach`, `collect` |

---

## Evolution of Filtering

The progression from verbose to concise:

```
1. Named class implementing Predicate         (most verbose, most reusable)
2. Anonymous class                            (verbose, one-off)
3. Lambda expression                          (concise)
4. Method reference                           (most concise when body is a single method call)
5. Stream API chain                           (idiomatic modern Java)
```

---

## Examples

| Example | Location | What it demonstrates |
|---------|----------|----------------------|
| `LambdaEvolutionExample` | `functional/` | Full progression: named class → anonymous → lambda → Stream |
| `LambdaScopeExample` | `functional/` | Lambda scope: method params, outer class fields, `this`, effectively-final |

---

## Key Functional Interfaces (java.util.function)

| Interface | Signature | Use case |
|-----------|-----------|----------|
| `Predicate<T>` | `boolean test(T t)` | Filtering |
| `Function<T,R>` | `R apply(T t)` | Transforming |
| `Consumer<T>` | `void accept(T t)` | Consuming (e.g., printing) |
| `Supplier<T>` | `T get()` | Producing a value |
| `BiFunction<T,U,R>` | `R apply(T t, U u)` | Two-input transform |

---

## Learning Order

1. `LambdaEvolutionExample` — see the full picture of the lambda evolution
2. `LambdaScopeExample` — understand what a lambda can and cannot access

---

## Common Pitfalls

- A lambda can only capture variables that are effectively final. Reassigning after
  the lambda is defined causes a compile error.
- `this` inside a lambda is NOT the lambda — it is the enclosing class instance.
  Inside an anonymous class, `this` IS the anonymous class instance.
- Checked exceptions cannot be thrown from standard functional interfaces like
  `Predicate` or `Function` — wrap in a try-catch or use a custom functional interface.
