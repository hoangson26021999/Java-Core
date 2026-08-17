# Generics

## What is this topic?

Generics allow you to write classes, interfaces, and methods that work with any type
while preserving compile-time type safety. Without generics you'd use `Object` everywhere
and need explicit casts — with generics, the compiler catches type mismatches for you.

---

## Concepts

| Concept | Description |
|---------|-------------|
| Type parameter `<T>` | Placeholder for a type supplied by the caller |
| Generic class | `class Box<T>` — works for any type T |
| Generic interface | `interface Writer<T>` — contract parameterized by type |
| Multiple type params | `class Dictionary<K, V>` — two independent type parameters |
| Generic method | Method with its own `<T>` independent of the class |
| Bounded type parameter | `<T extends Comparable<T>>` — restricts T to types with a specific capability |
| Type erasure | At runtime, generics are erased — `Box<String>` becomes `Box`. Compile-time only. |

---

## Examples

| Example | Location | What it demonstrates |
|---------|----------|----------------------|
| `GenericBoxExample` | `generics/` | Basic `Box<T>` — single type parameter |
| `TwoTypeParameterExample` | `generics/` | `Dictionary<K, V>` — two type parameters |
| `BoundedTypeParameterExample` | `generics/` | `<T extends Comparable<T>>` — finds maximum of any comparable type |
| `WriterInterface` | `generics/` | Generic interface definition |
| `GenericInterfaceExample` | `generics/` | Generic class implementing a generic interface |

---

## Learning Order

1. `GenericBoxExample` — understand a simple `<T>` placeholder
2. `TwoTypeParameterExample` — understand multiple type parameters
3. `BoundedTypeParameterExample` — understand type constraints
4. `WriterInterface` + `GenericInterfaceExample` — understand generic interfaces

---

## Common Type Parameter Names (by convention)

| Name | Meaning |
|------|---------|
| `T` | Type (general purpose) |
| `E` | Element (collections) |
| `K` | Key (maps) |
| `V` | Value (maps) |
| `N` | Number |

---

## Common Pitfalls

- `new T()` is not allowed — type erasure means the JVM doesn't know T at runtime.
- `List<Dog>` is NOT a subtype of `List<Animal>` — generics are invariant.
  Use `List<? extends Animal>` (wildcard) for covariance.
- Primitive types cannot be used as type parameters: use `Integer`, not `int`.
