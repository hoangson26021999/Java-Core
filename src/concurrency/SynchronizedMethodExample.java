package concurrency;

/**
 * Demonstrates synchronized methods and the difference between
 * static-level (class) locks and instance-level (object) locks.
 *
 * Key concepts:
 *   - synchronized on a STATIC method acquires the lock on the CLASS (Table.class).
 *     All instances share this lock — any thread calling any static synchronized
 *     method on Table must wait.
 *   - synchronized on an INSTANCE method acquires the lock on the specific OBJECT.
 *     Different instances have different locks — threads on different objects do NOT block.
 *   - A static synchronized method and an instance synchronized method use DIFFERENT
 *     locks — they do NOT block each other (see case 3 below).
 *
 * Test cases (controlled by the testCase variable):
 *   Case 1: Two static synchronized methods → share class lock → sequential execution
 *   Case 2: Two instance synchronized methods on same object → share object lock → sequential
 *   Case 3: One static + one instance method → different locks → concurrent execution
 *
 * Output order is nondeterministic in case 3 — threads may interleave freely.
 */
public class SynchronizedMethodExample {

    public static void main(String[] args) {
        int testCase = 1; // Change to 2 or 3 to test other cases

        switch (testCase) {
            case 1 -> {
                // Two static synchronized methods → class-level lock → sequential
                System.out.println("Case 1: static synchronized — class lock");
                Table obj = new Table();
                Thread t1 = new Thread(() -> Table.printTable(5), "Thread-1");
                Thread t2 = new Thread(() -> Table.printTable2(100), "Thread-2");
                t1.start();
                t2.start();
            }
            case 2 -> {
                // Two instance synchronized methods on the SAME object → object lock → sequential
                System.out.println("Case 2: instance synchronized — object lock (same instance)");
                Table obj2 = new Table();
                Thread t3 = new Thread(() -> obj2.printTableInstance(5), "Thread-3");
                Thread t4 = new Thread(() -> obj2.printTable2Instance(100), "Thread-4");
                t3.start();
                t4.start();
            }
            case 3 -> {
                // One static + one instance method → DIFFERENT locks → concurrent (interleaved output)
                System.out.println("Case 3: static + instance — different locks → concurrent!");
                Table obj3 = new Table();
                Thread t5 = new Thread(() -> Table.printTable(5), "Thread-5");
                Thread t6 = new Thread(() -> obj3.printTable2Instance(100), "Thread-6");
                t5.start();
                t6.start();
            }
        }
    }
}

/**
 * Shared resource class with both static and instance synchronized methods.
 * Also used by SynchronizedBlockExample — both files are in the concurrency package.
 */
class Table {

    // --- Static synchronized methods — lock on Table.class ---

    static synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + n * i);
            sleep();
        }
    }

    static synchronized void printTable2(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + n * i);
            sleep();
        }
    }

    // --- Instance synchronized methods — lock on 'this' object ---

    synchronized void printTableInstance(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + n * i);
            sleep();
        }
    }

    synchronized void printTable2Instance(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + n * i);
            sleep();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
