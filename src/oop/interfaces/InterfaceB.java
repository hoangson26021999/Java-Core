package oop.interfaces;

/**
 * Interface B — has the same default method signature as InterfaceA.
 *
 * This creates a "diamond problem" for any class implementing both InterfaceA
 * and InterfaceB: the compiler cannot choose between InterfaceA.getStaticString()
 * and InterfaceB.getStaticString(), so the class MUST override it.
 */
public interface InterfaceB {
    String getName();
    String getAuthor();
    int getAge();

    default String getStaticString() {
        return InterfaceB.class.getSimpleName(); // returns "InterfaceB"
    }

    default String getB() {
        return "B";
    }
}
