# Annotations & Reflection

## What is this topic?

Annotations are metadata attached to Java code elements (classes, fields, methods).
Reflection is the mechanism that reads this metadata at runtime and acts on it.

Together, they power frameworks like Jackson (JSON), Spring (DI), JPA (ORM), and JUnit (testing).

---

## Concepts

### Annotations

| Concept | Description |
|---------|-------------|
| `@interface` | Declares a custom annotation type |
| `@Retention(RUNTIME)` | Annotation survives compilation and is readable via reflection at runtime |
| `@Retention(CLASS)` | Default — annotation in bytecode but not available at runtime |
| `@Retention(SOURCE)` | Annotation discarded after compilation (e.g., `@Override`) |
| `@Target` | Restricts where the annotation can be placed (TYPE, FIELD, METHOD, etc.) |
| Annotation element | Declared like a method: `String value()`. Can have a `default`. |

### Reflection

| Concept | Description |
|---------|-------------|
| `Class<?>` | Runtime representation of a class |
| `getDeclaredAnnotation()` | Retrieve a specific annotation from a class or field |
| `getDeclaredFields()` | Get all fields (including private) |
| `field.setAccessible(true)` | Bypass access control to read/write private fields |
| `field.get(object)` | Read a field value at runtime |

---

## Examples

| Example | Location | What it demonstrates |
|---------|----------|----------------------|
| `JsonNameAnnotation` | `annotations/` | Custom annotation definition with `@Retention` and `@Target` |
| `JsonNameProcessor` | `annotations/` | Runtime annotation reading via reflection to build JSON |
| `AnnotationUsageExample` | `annotations/` | Using `@JsonNameAnnotation` on class and field; running the processor |

---

## Learning Order

1. `JsonNameAnnotation` — understand how to define an annotation
2. `JsonNameProcessor` — understand how reflection reads annotations
3. `AnnotationUsageExample` — see the complete picture end-to-end

---

## Common Pitfalls

- Using `@Retention(CLASS)` or `@Retention(SOURCE)` means your annotation is NOT
  available via reflection at runtime. For runtime processing, always use `@Retention(RUNTIME)`.
- `field.setAccessible(true)` bypasses encapsulation — use only in tools, frameworks,
  or learning examples, never in normal application code.
- Reflection is significantly slower than direct field access. It is a tool for
  frameworks, not regular business logic.
