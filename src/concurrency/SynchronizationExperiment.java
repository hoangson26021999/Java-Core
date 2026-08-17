package concurrency;

/**
 * Comprehensive synchronization experiment comparing three locking strategies.
 *
 * This file explores the subtle differences between:
 *   1. Instance synchronized method  (lock on 'this')
 *   2. Static synchronized method    (lock on Class object)
 *   3. Synchronized block on class   (synchronized(ObjSync.class) inside instance method)
 *
 * The key insight demonstrated by the active threads (t6, t7):
 *   - obj2 and obj3 are DIFFERENT instances of ObjSync.
 *   - sync2SyncBlock() is NOT marked synchronized at the method level.
 *   - BUT inside it, the block uses synchronized(ObjSync.class) — the CLASS lock.
 *   - Therefore, even though obj2 ≠ obj3, both threads compete for ObjSync.class
 *     and are SERIALIZED.
 *
 * Uncomment other thread pairs to experiment with remaining cases.
 *
 * Output order is nondeterministic — thread scheduling is OS-dependent.
 */
public class SynchronizationExperiment {

    public static void main(String[] args) {
        ObjSync obj  = new ObjSync();
        ObjSync obj2 = new ObjSync();
        ObjSync obj3 = new ObjSync();

        // --- t1/t2: instance synchronized on the SAME object → serialized ---
        Thread t1 = new Thread(() -> {
            try { obj.sync("Thread-1"); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread t2 = new Thread(() -> {
            try { obj.sync2("Thread-2"); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        // t1.start(); t2.start(); // uncomment to test

        // --- t3/t4: static synchronized → class lock → serialized even on different instances ---
        Thread t3 = new Thread(() -> {
            try { ObjSync.syncStatic("Thread-3"); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread t4 = new Thread(() -> {
            try { ObjSync.sync2Static("Thread-4"); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        // t3.start(); t4.start(); // uncomment to test

        // --- t5: single thread using class-level synchronized block ---
        Thread t5 = new Thread(() -> {
            try { obj.sync2SyncBlock("Thread-5"); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        // t5.start(); // uncomment to test

        // --- ACTIVE: t6/t7 on DIFFERENT instances, but both lock on ObjSync.class ---
        // Despite obj2 ≠ obj3, they compete for the same class-level lock → serialized
        Thread t6 = new Thread(() -> {
            try { obj2.sync2SyncBlock("Thread-6"); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread t7 = new Thread(() -> {
            try { obj3.sync2SyncBlock("Thread-7"); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        t6.start();
        t7.start();
    }
}

/**
 * Target class with multiple synchronization strategies for comparison.
 */
class ObjSync {

    /** Instance synchronized — lock on 'this'. Only one thread per instance at a time. */
    synchronized void sync(String threadName) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " : " + i);
            Thread.sleep(300);
        }
    }

    /** Second instance synchronized method on same object — shares the same 'this' lock as sync(). */
    synchronized void sync2(String threadName) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " : " + i);
            Thread.sleep(300);
        }
    }

    /** Static synchronized — lock on ObjSync.class. Shared across ALL instances. */
    static synchronized void syncStatic(String threadName) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " : " + i);
            Thread.sleep(300);
        }
    }

    /** Second static synchronized method — same class lock as syncStatic(). */
    static synchronized void sync2Static(String threadName) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " : " + i);
            Thread.sleep(300);
        }
    }

    /**
     * Non-synchronized method that contains a synchronized BLOCK on the class object.
     * Threads from different instances STILL compete for ObjSync.class — same as static sync.
     */
    void sync2SyncBlock(String threadName) throws InterruptedException {
        synchronized (ObjSync.class) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " : " + i);
                Thread.sleep(300);
            }
        }
    }
}
