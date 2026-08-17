# Concurrency & Synchronization

## What is this topic?

When multiple threads access shared state simultaneously, race conditions can corrupt data.
Java provides synchronization mechanisms to coordinate thread access and ensure correctness.

---

## Concepts

### Locks and Monitors

| Concept | Description |
|---------|-------------|
| Monitor | Every Java object has a built-in lock (monitor) |
| `synchronized` method | Acquires the lock before executing; releases it on return/exception |
| Instance synchronized | Locks on `this` — threads on the same object are serialized |
| Static synchronized | Locks on `ClassName.class` — ALL instances share this lock |
| `synchronized` block | `synchronized(obj) { ... }` — finer control; locks only the critical section |
| Class lock | `synchronized(SomeClass.class)` — same as static synchronized |

### Key Rules

| Rule | Implication |
|------|-------------|
| Instance lock ≠ Class lock | A `static synchronized` method and an `instance synchronized` method on the same class do NOT block each other |
| Same lock → serialized | Two threads competing for the same lock execute one at a time |
| Different locks → concurrent | Two threads on different locks run freely in parallel |

### volatile

| Concept | Description |
|---------|-------------|
| `volatile` field | Writes are immediately visible to all threads; prevents CPU/JVM instruction reordering |
| Without `volatile` | A thread may read a stale cached value; `null` checks on partially-initialized objects are possible |

---

## Examples

| Example | Location | What it demonstrates |
|---------|----------|----------------------|
| `SynchronizedMethodExample` | `concurrency/` | Static vs instance synchronized methods; class lock vs object lock |
| `SynchronizedBlockExample` | `concurrency/` | Synchronized blocks; two instances using a static synchronized method |
| `SynchronizationExperiment` | `concurrency/` | All three strategies compared: instance sync, static sync, class-level block |
| `SingletonPattern` | `concurrency/` | Thread-safe Singleton — double-checked locking + `volatile` |

---

## Learning Order

1. `SynchronizedMethodExample` — understand instance vs class lock, cases 1 and 2
2. `SynchronizedMethodExample` case 3 — understand that instance and class locks do NOT interact
3. `SynchronizedBlockExample` — understand synchronized blocks on different objects
4. `SynchronizationExperiment` — run t6/t7 to confirm class-level block serialization
5. `SingletonPattern` — see volatile + double-checked locking in a real pattern

---

## Expected Output Notes

All concurrency examples produce **nondeterministic output** — thread scheduling is
decided by the OS and varies between runs. The ordering of output lines may differ
each time you run the program. This is intentional and demonstrates the point.

---

## Common Pitfalls

- Synchronizing on different objects (or a new object each time) provides no protection.
- `synchronized` prevents concurrent access but does NOT guarantee ordering between threads.
- Using `volatile` alone is NOT enough for compound operations like `count++`
  (which is read-modify-write, not atomic). Use `AtomicInteger` or `synchronized` for that.
- Deadlock occurs when Thread A holds lock 1 and waits for lock 2, while Thread B
  holds lock 2 and waits for lock 1. Always acquire locks in a consistent order.
- `double-checked locking` without `volatile` is broken on some JVMs due to
  instruction reordering — the `volatile` keyword is mandatory for correctness.
