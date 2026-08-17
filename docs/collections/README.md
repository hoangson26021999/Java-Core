# Collections

## What is this topic?

The Java Collections Framework provides ready-made data structures for storing,
organizing, and accessing groups of objects. The three main interfaces are:
`List`, `Set`, and `Map`.

---

## Concepts

### List — ordered, allows duplicates

| Concept | Description |
|---------|-------------|
| `ArrayList` | Dynamic array; fast random access O(1), slow middle-insert O(n) |
| Insertion order | Elements keep the order they were added |
| Duplicates | Allowed — `["Java", "Java"]` is a valid List |
| Index-based access | `get(0)`, `add(1, "Python")` |

### Set — no duplicates

| Concept | Description |
|---------|-------------|
| `HashSet` | Backed by HashMap; O(1) average for add/contains/remove; unordered |
| No duplicates | Adding the same element twice is silently ignored |
| One null allowed | `HashSet` accepts a single `null` element |

### Map — key-value pairs

| Implementation | Ordering | Null keys | Null values | Performance |
|----------------|----------|-----------|-------------|-------------|
| `HashMap` | None | 1 allowed | Allowed | O(1) average |
| `LinkedHashMap` | Insertion order | 1 allowed | Allowed | O(1) + list overhead |
| `TreeMap` | Sorted (natural/Comparator) | Not allowed | Allowed | O(log n) |

### HashMap Internals

| Concept | Description |
|---------|-------------|
| `hashCode()` | Determines which bucket a key goes into |
| `equals()` | Distinguishes keys within the same bucket |
| Hash collision | Two keys with the same `hashCode()` land in the same bucket |
| Contract | If `a.equals(b)` then `a.hashCode() == b.hashCode()` — MUST hold |

---

## Examples

| Example | Location | What it demonstrates |
|---------|----------|----------------------|
| `ListExample` | `collections/` | ArrayList basics — add, insert at index, get, iterate |
| `SetExample` | `collections/` | HashSet — no duplicates, null, contains |
| `MapExample` | `collections/` | HashMap vs LinkedHashMap vs TreeMap comparison |
| `HashMapCollisionDemo` | `collections/` | Intentionally broken hashCode/equals to show collision behavior |

---

## Learning Order

1. `ListExample` — simplest collection
2. `SetExample` — uniqueness constraint
3. `MapExample` — key-value pairs and ordering variants
4. `HashMapCollisionDemo` — understand the hashCode/equals contract

---

## Common Pitfalls

- Forgetting to override both `hashCode()` AND `equals()` when using custom objects as Map keys.
  Override one without the other and Map lookups will silently fail.
- `Arrays.asList()` returns a fixed-size list — calling `add()` or `remove()` throws `UnsupportedOperationException`.
- `TreeMap` throws `NullPointerException` if you try to use a null key.
- `HashSet`/`HashMap` iteration order is unpredictable — do not rely on it.
