package oop.abstraction;

/**
 * Demonstrates a multi-level abstract class inheritance chain.
 *
 * Key concepts:
 *   - An abstract class can extend another abstract class WITHOUT implementing
 *     the parent's abstract methods — it simply defers the requirement further.
 *   - Only the first CONCRETE (non-abstract) class in the chain must implement
 *     all accumulated abstract methods.
 *
 * Chain:
 *   AbstractBase  (abstract)
 *       └── AbstractMiddle  (abstract — does NOT implement doSomething)
 *               └── ConcreteLeaf  (concrete — MUST implement doSomething)
 *
 * This pattern is common in frameworks where a base layer defines contracts
 * and intermediate layers add partial behavior, leaving the leaf class to
 * provide the final implementation.
 */
public class AbstractClassChain {

    public static void main(String[] args) {
        // Cannot instantiate AbstractBase or AbstractMiddle
        ConcreteLeaf leaf = new ConcreteLeaf();
        leaf.doSomething();
        System.out.println("ConcreteLeaf created successfully.");
        System.out.println("Class hierarchy: " + leaf.getClass().getSuperclass().getSuperclass().getSimpleName()
                + " → " + leaf.getClass().getSuperclass().getSimpleName()
                + " → " + leaf.getClass().getSimpleName());
    }
}

/** Level 1: defines the abstract contract. */
abstract class AbstractBase {
    public abstract void doSomething();
}

/**
 * Level 2: abstract subclass that does NOT implement doSomething().
 * This is valid — the obligation is passed down to the first concrete class.
 */
abstract class AbstractMiddle extends AbstractBase {
    // doSomething() is still abstract here — no override required
}

/**
 * Level 3: the first concrete class — MUST implement doSomething()
 * because it inherits the abstract contract from AbstractBase via AbstractMiddle.
 */
class ConcreteLeaf extends AbstractMiddle {

    @Override
    public void doSomething() {
        System.out.println("ConcreteLeaf.doSomething() — finally implemented!");
    }
}
