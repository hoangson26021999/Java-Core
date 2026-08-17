package oop.nestedclasses;

/**
 * Demonstrates the difference between a non-static inner class and a static nested class.
 *
 * Key concepts:
 *   - Non-static inner class:
 *       * Has an implicit reference to the outer class instance.
 *       * Can access all members (including private) of the outer instance.
 *       * Must be created via an outer instance: outer.new InnerClass()
 *       * Field shadowing: use OuterClass.this.field to access the outer field
 *         when a field with the same name exists in both.
 *   - Static nested class:
 *       * Does NOT hold a reference to the outer instance.
 *       * Can only access static members of the outer class.
 *       * Can be instantiated without an outer instance: new Outer.StaticNested()
 *
 * Expected output:
 *   0          ← inner.inner_id
 *   7          ← this.id (InnerClass's own id)
 *   9          ← OuterClass.this.id (outer's static id)
 *   0          ← StaticInnerClass.id
 */
public class InnerVsStaticNestedExample {

    private String name = "OuterClass";
    private static int id = 9; // static field of the outer class

    /** Non-static inner class — has implicit reference to InnerVsStaticNestedExample */
    class InnerClass {
        int inner_id = 0;
        int id = 7; // shadows the outer class's static id

        void printId() {
            System.out.println(this.id);                         // 7 — inner's own id
            System.out.println(InnerVsStaticNestedExample.this.id); // 9 — outer's static id
        }
    }

    /** Static nested class — no reference to the outer instance */
    static class StaticNestedClass {
        static int id = 0;

        void printId() {
            System.out.println(id); // 0 — static nested class's own id
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Non-static inner class ===");
        InnerVsStaticNestedExample outer = new InnerVsStaticNestedExample();
        // Must use an outer instance to create an InnerClass
        InnerVsStaticNestedExample.InnerClass inner = outer.new InnerClass();

        System.out.println(inner.inner_id); // 0
        inner.printId();                    // 7, then 9

        System.out.println("\n=== Static nested class ===");
        // No outer instance needed
        StaticNestedClass staticNested = new StaticNestedClass();
        staticNested.printId(); // 0
    }
}
