package oop.interfaces;

/**
 * Interface A — used together with InterfaceB to demonstrate multiple interface
 * implementation and the diamond default method conflict.
 *
 * Key concepts:
 *   - Java 8 introduced default methods on interfaces.
 *   - When two interfaces both declare a default method with the SAME signature,
 *     a class implementing both must explicitly override that method.
 *   - See MultipleInterfaceExample for the resolution.
 */
public interface InterfaceA {
    String getName();
    String getAuthor();

    default String getStaticString() {
        return InterfaceA.class.getSimpleName(); // returns "InterfaceA"
    }
}
