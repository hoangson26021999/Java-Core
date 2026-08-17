package concurrency;

/**
 * Demonstrates synchronized blocks and the effect of locking on DIFFERENT objects.
 *
 * Key concepts:
 *   - A synchronized block allows finer-grained locking than a synchronized method.
 *     You can synchronize only the critical section instead of the whole method.
 *   - When two threads synchronize on DIFFERENT object instances, they acquire
 *     different locks and run CONCURRENTLY (no mutual exclusion).
 *   - When threads synchronize on the SAME object (or on the Class object for static),
 *     they are SERIALIZED — one must wait for the other to release the lock.
 *
 * Experiment:
 *   - Both threads below call Table.printTable() which is static synchronized.
 *   - Even though obj and obj2 are different Table instances, static synchronized
 *     methods lock on Table.class — so the two threads ARE serialized.
 *   - Try changing to printTableInstance() (instance synchronized) on two different
 *     objects: they would run concurrently because they use different object locks.
 *
 * Output order is nondeterministic — thread scheduling is OS-dependent.
 */
public class SynchronizedBlockExample {

    public static void main(String[] args) {
        Table obj  = new Table(); // first instance
        Table obj2 = new Table(); // second instance

        // Both call a STATIC synchronized method → locked on Table.class → serialized
        Thread t1 = new Thread(() -> Table.printTable(5), "Thread-1");
        Thread t2 = new Thread(() -> Table.printTable(100), "Thread-2");
        t1.start();
        t2.start();

        // Experiment: replace with instance method to see concurrent execution:
        // Thread t3 = new Thread(() -> obj.printTableInstance(5), "Thread-3");
        // Thread t4 = new Thread(() -> obj2.printTableInstance(100), "Thread-4");
        // t3.start();
        // t4.start();
    }
}
