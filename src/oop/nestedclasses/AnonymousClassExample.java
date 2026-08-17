package oop.nestedclasses;

/**
 * Demonstrates anonymous classes vs local (named) classes.
 *
 * Key concepts:
 *   - A local class is a named class defined inside a method.
 *     It can be instantiated multiple times within that method.
 *   - An anonymous class is a class defined and instantiated in a single expression.
 *     It is used when you need a one-off implementation and don't need to reuse the type.
 *   - Both can implement interfaces or extend classes.
 *   - Both can capture effectively-final variables from the enclosing scope.
 *   - Lambda expressions (Java 8+) can replace anonymous classes for functional interfaces.
 *
 * Expected output:
 *   Hello world
 *   Salut Fred
 *   Hola, mundo
 */
public class AnonymousClassExample {

    /** Interface to greet someone. */
    interface HelloWorld {
        void greet();
        void greetSomeone(String someone);
    }

    public void sayHello() {

        // --- Local class: named, defined inside this method ---
        class EnglishGreeting implements HelloWorld {
            String name = "world";

            @Override
            public void greet() {
                greetSomeone("world");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();

        // --- Anonymous class: defined and instantiated in one expression ---
        // Use when you need this implementation only once
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";

            @Override
            public void greet() {
                greetSomeone("tout le monde");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";

            @Override
            public void greet() {
                greetSomeone("mundo");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };

        englishGreeting.greet();               // local class
        frenchGreeting.greetSomeone("Fred");   // anonymous class
        spanishGreeting.greet();               // anonymous class
    }

    public static void main(String[] args) {
        new AnonymousClassExample().sayHello();
    }
}
