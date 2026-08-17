package oop.basics;

/**
 * Demonstrates the difference between static and instance variables.
 *
 * Key concept:
 *   - static variables belong to the CLASS — shared across ALL instances.
 *   - instance variables belong to each OBJECT — each instance has its own copy.
 *
 * Expected output:
 *   0
 *   2
 */
public class StaticVsInstanceExample {

    // Instance variable — each object has its own copy
    int b = 1;

    // Static variable — shared by all instances of this class
    static int a = 0;

    public int getA() {
        return a; // returns the shared static value
    }

    public void setA(int a) {
        // Use class name to make it clear this is a static field
        StaticVsInstanceExample.a = a;
    }

    public void addToInstanceVar() {
        b = b + 1;
    }

    public static void main(String[] args) {
        // Access static variable through class name (preferred)
        System.out.println(StaticVsInstanceExample.a); // 0

        // Modifying the static variable affects ALL future instances
        StaticVsInstanceExample.a = 2;

        StaticVsInstanceExample obj = new StaticVsInstanceExample();
        obj.addToInstanceVar();

        // getA() returns the class-level static value, not per-instance
        System.out.println(obj.getA()); // 2

        // Common pitfall: creating a second instance still sees a = 2
        StaticVsInstanceExample obj2 = new StaticVsInstanceExample();
        System.out.println(obj2.getA()); // still 2 — shared!
        System.out.println(obj2.b);      // 1 — own copy, unaffected by obj
    }
}
