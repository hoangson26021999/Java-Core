package oop.interfaces;

/**
 * Defines the DoIt interface, demonstrating all four kinds of interface members
 * introduced across Java versions.
 *
 * Interface member types:
 *   - Constants (implicitly public static final)
 *   - Abstract methods (implicitly public abstract) — implementors MUST provide
 *   - Static methods (Java 8+) — called on the interface, not on instances
 *   - Default methods (Java 8+) — concrete methods with a default implementation
 *     that implementors may optionally override
 */
public interface DoItInterface {

    // Constant — implicitly public static final
    int ABC = 0;

    // Abstract methods — any implementing class must provide these
    void shout();
    int id();
    void show();

    // Static method — called as DoItInterface.help(), not on an instance
    static int help() {
        return 2;
    }

    // Default method — provides a default implementation;
    // implementing classes can override it if needed
    default void type() {
        System.out.println("something: " + help());
    }
}
