package oop.inheritance;

/**
 * Demonstrates inheritance and runtime polymorphism in Java.
 *
 * Key concepts:
 *   - A subclass inherits fields and methods from its superclass.
 *   - Method overriding: the subclass provides its own implementation.
 *   - Runtime polymorphism: which method runs is decided at runtime
 *     based on the actual object type, not the reference type.
 *   - Field access is NOT polymorphic — it uses the reference type.
 *   - Upcasting: assigning a subclass object to a superclass reference.
 *   - Downcasting: casting a superclass reference back to the subclass type.
 *
 * Expected output (upcasting block):
 *   1000          ← Animal.id (field access is NOT polymorphic)
 *   eating fish   ← Cat.eat() (method call IS polymorphic)
 *   cat shout     ← Cat.shout() (overridden method)
 */
public class InheritancePolymorphismExample {

    public static void main(String[] args) {
        System.out.println("=== Basic inheritance ===");
        Dog dog = new Dog(3);
        System.out.println("dog.a = " + dog.getA()); // inherited from Animal

        System.out.println("\n=== Upcasting (Animal reference → Cat object) ===");
        // The reference type is Animal, but the actual object is Cat.
        // Field access resolves to Animal.id (compile-time binding).
        // Method calls resolve to Cat's overridden versions (runtime binding).
        Animal c = new Cat();
        System.out.println("c.id = " + c.id);   // 1000 — Animal's field
        c.eat();                                  // "eating fish" — Cat.eat()
        c.shout();                                // "cat shout" — Cat.shout()

        System.out.println("\n=== Downcasting (back to Cat) ===");
        // Safe: we know the actual object is Cat
        Cat cat = (Cat) c;
        System.out.println("cat.id = " + cat.id); // 123456 — Cat's own field
        cat.meow();

        System.out.println("\n=== Invalid downcast (would throw ClassCastException) ===");
        // This compiles but fails at runtime — you cannot cast a real Animal to Cat
        try {
            Animal realAnimal = new Animal();
            Cat badCast = (Cat) realAnimal; // ClassCastException!
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: " + e.getMessage());
        }
    }
}

class Animal {
    int a;
    int id = 1000;

    Animal() {
        System.out.println("Constructor: Animal");
    }

    void shout() {
        System.out.println("shout");
    }

    void shout(int a) {
        System.out.println(a); // method overloading
    }

    void eat() {
        System.out.println("eating...");
    }

    public int getA() { return a; }
    public void setA(int a) { this.a = a; }

    public static void getSomething() {
        System.out.println("getSomething (static — not overridden)");
    }
}

class Dog extends Animal {
    int b;
    int id = 5000;

    Dog(int c) {
        // super() is implicitly called first → prints "Constructor: Animal"
        this.a = c;
        System.out.println("Constructor: Dog");
    }

    void bark() {
        System.out.println("barking...");
    }
}

class Cat extends Animal {
    int id = 123456;

    void meow() {
        System.out.println("meowing...");
    }

    @Override
    void eat() {
        System.out.println("eating fish"); // overrides Animal.eat()
    }

    @Override
    void shout() {
        System.out.println("cat shout"); // overrides Animal.shout()
    }
}
