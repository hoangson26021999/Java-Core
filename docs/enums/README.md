# Enums

## What is this topic?

An `enum` is a special class in Java whose instances are a fixed set of named constants.
Enums are type-safe, can carry data, and can have methods.

---

## Concepts

| Concept | Description |
|---------|-------------|
| Enum constant | A named singleton instance declared inside the enum |
| Enum with field | Each constant carries associated data via a constructor |
| `values()` | Returns all constants in declaration order |
| `valueOf(String)` | Returns the constant by name (throws if not found) |
| `name()` | Returns the constant's declared name as a String |
| `ordinal()` | Returns the zero-based position in the declaration order |
| `==` comparison | Preferred for enums — type-safe, fast, compile-time checked |
| `.equals()` comparison | Works but NOT type-safe across different enum types |

---

## Examples

| Example | Location | What it demonstrates |
|---------|----------|----------------------|
| `EnumWithFieldExample` | `enums/` | Enum with constructor, field, and getter — attaching data to constants |
| `EnumComparisonExample` | `enums/` | `==` vs `.equals()` type safety; inner enums; deliverability check |

---

## Learning Order

1. `EnumWithFieldExample` — understand that enums are full classes with state
2. `EnumComparisonExample` — understand the comparison rules

---

## Common Pitfalls

- Using `.equals()` to compare enums from different types compiles fine
  but always returns `false` — a silent bug. Use `==` instead.
- Trying to create an enum instance with `new` is a compile error.
  Enum constructors are always private.
- `ordinal()` is fragile — it changes if constants are reordered.
  Prefer using a field (like `code`) for stable numeric values.
