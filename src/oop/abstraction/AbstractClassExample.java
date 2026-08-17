package oop.abstraction;

/**
 * Demonstrates abstract classes and the Template Method pattern.
 *
 * Key concepts:
 *   - An abstract class cannot be instantiated directly.
 *   - It can have abstract methods (no body) that subclasses MUST implement.
 *   - It can also have concrete methods that subclasses inherit as-is.
 *   - A concrete method in the abstract class can call abstract methods —
 *     this is the Template Method pattern: the skeleton is defined in the
 *     parent, the details are filled in by the child.
 *
 * Expected output:
 *   child1          ← ConcreteChildA.a() called via template method b()
 *   a: 50--- b:100
 *   child2          ← ConcreteChildB.a()
 *   a: 1--- b:2
 */
public class AbstractClassExample {

    public static void main(String[] args) {
        // Cannot do: new AbstractTemplate() — compile error
        AbstractTemplate child1 = new ConcreteChildA(50, 100);
        child1.b(); // calls a() internally — template method pattern
        child1.c();

        AbstractTemplate child2 = new ConcreteChildB();
        child2.b();
        child2.c();
    }
}

/**
 * Abstract class acting as a template.
 * Method b() is a template method — it calls the abstract a().
 */
abstract class AbstractTemplate {
    int a = 1;
    int b = 2;

    // Abstract method — subclasses define what this returns
    abstract String a();

    // Template method — uses the abstract method internally
    public void b() {
        System.out.println(a()); // calls whichever subclass's a() is active
    }

    public void c() {
        System.out.println("a: " + a + "--- b:" + b);
    }
}

/** Concrete subclass A — provides its own implementation of a(). */
class ConcreteChildA extends AbstractTemplate {

    ConcreteChildA(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    String a() {
        return "child1";
    }
}

/** Concrete subclass B — uses default field values from the abstract parent. */
class ConcreteChildB extends AbstractTemplate {

    @Override
    String a() {
        return "child2";
    }
}
