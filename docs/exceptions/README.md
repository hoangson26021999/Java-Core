# Exception Handling

## What is this topic?

Exceptions are how Java signals that something went wrong at runtime.
The exception handling mechanism (`try-catch-finally`) lets you respond to
errors without crashing the program.

---

## Concepts

### Exception hierarchy

```
Throwable
├── Error            (JVM-level; do not catch)
└── Exception
    ├── IOException          ← Checked exception
    ├── SQLException         ← Checked exception
    └── RuntimeException     ← Unchecked exception
        ├── NullPointerException
        ├── ArithmeticException
        └── IllegalArgumentException
```

| Type | Description |
|------|-------------|
| Checked exception | Must be declared with `throws` or handled with `try-catch`. Compiler enforces this. |
| Unchecked exception | Extends `RuntimeException`. No declaration required. |
| `finally` block | Always runs — whether an exception was thrown, caught, or re-thrown |
| Re-throw | Catch an exception, then `throw` a different one (wrapping) |

---

## Examples

| Example | Location | What it demonstrates |
|---------|----------|----------------------|
| `FinallyBlockExample` | `exceptions/` | `finally` always executes, even when `catch` re-throws |
| `CheckedExceptionExample` | `exceptions/` | Checked vs unchecked exceptions, `throws` declaration |

---

## Learning Order

1. `FinallyBlockExample` — understand the execution order of try/catch/finally
2. `CheckedExceptionExample` — understand when the compiler forces you to handle exceptions

---

## Common Pitfalls

- Catching `Exception` (or worse, `Throwable`) hides bugs. Catch the most specific type.
- An empty catch block (`catch (Exception e) {}`) silently swallows errors.
  Always at least log the exception.
- `finally` does NOT run if `System.exit()` is called or the JVM crashes.
- Prefer `try-with-resources` over `finally` for closing `AutoCloseable` resources.
  It is safer and more concise:
  ```java
  try (InputStream is = new FileInputStream("file.txt")) {
      // is is closed automatically
  }
  ```
