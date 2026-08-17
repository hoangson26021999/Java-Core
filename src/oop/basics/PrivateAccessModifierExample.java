package oop.basics;

/**
 * Demonstrates the private access modifier.
 *
 * Key concepts:
 *   - private members (fields, constructors, methods) are accessible only
 *     within the same class.
 *   - A class CAN access its own private constructor from inside a static
 *     main() method — because main() is part of the same class.
 *   - This pattern is the basis for the Singleton design pattern.
 *
 * Expected output:
 *   1
 *   bum bum
 */
public class PrivateAccessModifierExample {

    private int id = 1;

    // Private constructor — cannot be called from outside this class
    private PrivateAccessModifierExample() {
    }

    private void shoot() {
        System.out.println("bum bum");
    }

    public static void main(String[] args) {
        // Allowed: main() is inside the same class, so private is accessible
        PrivateAccessModifierExample obj = new PrivateAccessModifierExample();
        System.out.println(obj.id);   // accesses private field
        obj.shoot();                  // calls private method
    }
}
