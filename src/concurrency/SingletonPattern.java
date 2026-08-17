package concurrency;

/**
 * Demonstrates the thread-safe Singleton pattern using double-checked locking.
 *
 * Key concepts:
 *   - Singleton: ensures only ONE instance of a class is ever created.
 *   - volatile on the instance field prevents instruction reordering by the JVM/CPU.
 *     Without volatile, the JVM might make the reference visible to other threads
 *     before the constructor body has fully executed — causing a partially initialized
 *     object to be used.
 *   - Double-checked locking:
 *       1. First null check (no synchronization) → fast path for already-initialized case.
 *       2. synchronized block → ensures only one thread initializes.
 *       3. Second null check (inside sync) → guards against a race between two threads
 *          that both passed the first null check simultaneously.
 *   - The constructor guard throws an exception if reflection is used to bypass it.
 *
 * Without volatile + double-checked locking, a naive synchronized getInstance() would
 * acquire a lock on EVERY call — unnecessarily slow after initialization.
 */
public class SingletonPattern {

    // volatile ensures the assignment to 'instance' is visible to all threads
    // immediately after it is made, and prevents unsafe publication.
    private static volatile SingletonPattern instance;

    /** Private constructor — prevents direct instantiation from outside this class. */
    private SingletonPattern() {
        // Guard against reflection-based bypass
        if (instance != null) {
            throw new RuntimeException("Use getInstance() — this class is a Singleton.");
        }
    }

    /**
     * Returns the single instance, creating it on the first call (lazy initialization).
     * Thread-safe via double-checked locking + volatile.
     */
    public static SingletonPattern getInstance() {
        // First check — no lock acquired for the fast path
        if (instance == null) {
            synchronized (SingletonPattern.class) {
                // Second check — inside the lock, handles the race condition
                if (instance == null) {
                    instance = new SingletonPattern();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from the single instance: " + this.hashCode());
    }

    public static void main(String[] args) throws InterruptedException {
        // Demonstrate that multiple threads always get the same instance
        Runnable task = () -> {
            SingletonPattern s = SingletonPattern.getInstance();
            s.showMessage();
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start(); t2.start(); t3.start();
        t1.join();  t2.join();  t3.join();
        // All three threads print the same hashCode — same object
    }
}
