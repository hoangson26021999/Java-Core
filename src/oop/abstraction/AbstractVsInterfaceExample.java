package oop.abstraction;

/**
 * Demonstrates abstract class features in depth and compares with interfaces.
 *
 * Key concepts:
 *   - Abstract classes CAN have instance fields (interfaces cannot have mutable state).
 *   - Subclasses inherit fields from abstract parents, but field access is NOT polymorphic
 *     (a shadowed field in the child hides the parent's, unlike method overriding).
 *   - Upcasting to an abstract type restricts access to only the parent's visible members.
 *   - Downcasting restores access to the child's full interface.
 *   - An anonymous class can instantiate an abstract class on the spot.
 *   - After upcasting and downcasting, the reference points to the same object (==).
 *
 * Comparison — when to use abstract class vs interface:
 *   - Use abstract class when subclasses share STATE (fields) or partial implementation.
 *   - Use interface when you only need to define a CONTRACT (behavior, no state).
 */
public class AbstractVsInterfaceExample {

    public static void main(String[] args) {
        System.out.println("=== Upcast: TestParent reference → ConcreteChild object ===");
        TestParent upcast = new ConcreteChild();
        System.out.println(upcast.a());      // "Helu" — polymorphic, calls ConcreteChild.a()
        upcast.b();                          // "child shout" — overridden
        upcast.c();                          // "parent helo" — not overridden, uses parent
        upcast.d();                          // "child heloooooooooo" + "parent heloooooooooo"
        System.out.println(upcast.u);        // "kakak" — parent's field (no field polymorphism)

        System.out.println("\n=== Downcast: back to ConcreteChild ===");
        ConcreteChild down = (ConcreteChild) upcast;
        down.lolo();    // accesses parent's 'a' field via child
        down.yyyy();    // prints child's shadowed 'u' field

        System.out.println("\n=== Direct child instance ===");
        ConcreteChild direct = new ConcreteChild();
        direct.c();
        direct.b();
        direct.yyyy();
        System.out.println(direct.a);  // "kekeke" — inherited from TestParent
        System.out.println(direct.u);  // "plplp"  — child's own shadowed field

        System.out.println("\n=== Anonymous class instantiation ===");
        // Cannot do: new TestParent() — but can with an anonymous subclass
        TestParent anonymous = new TestParent() {
            @Override
            public String a() {
                return "anonymous implementation";
            }
        };
        System.out.println(anonymous.a()); // "anonymous implementation"

        System.out.println("\n=== Reference identity after upcast/downcast ===");
        ConcreteChild original = new ConcreteChild();
        TestParent w = original;              // upcast
        ConcreteChild restored = (ConcreteChild) w; // downcast
        System.out.println(restored == original); // true — same object in memory
    }
}

/** Abstract parent with fields, abstract method, and concrete methods. */
abstract class TestParent {
    String a = "kekeke";
    String u = "kakak";

    public abstract String a();

    public void b() {
        System.out.println("parent shout");
    }

    public void c() {
        System.out.println("parent helo");
    }

    public void d() {
        System.out.println("parent heloooooooooo");
    }
}

/** Concrete child — implements abstract method, overrides some concrete methods. */
class ConcreteChild extends TestParent {
    // Shadows TestParent.u — this is a NEW field, not the same variable
    String u = "plplp";
    int k = 1;

    public void lolo() {
        // 'a' here refers to the inherited field from TestParent ("kekeke")
        System.out.println(a);
    }

    public void yyyy() {
        // 'u' here refers to this child's own shadowed field ("plplp")
        System.out.println(u);
    }

    @Override
    public void b() {
        System.out.println("child shout ");
    }

    @Override
    public String a() {
        return "Helu";
    }

    @Override
    public void d() {
        System.out.println("child heloooooooooo");
        super.d(); // explicitly calls parent's d() as well
    }
}

/** Abstract intermediate — does not implement a(), so it remains abstract. */
abstract class AbstractIntermediate extends TestParent {
    // Demonstrates that an abstract class can extend another without
    // implementing the parent's abstract methods.
}

/** Concrete class at the end of a 3-level abstract chain. */
class ThirdLevel extends AbstractIntermediate {
    @Override
    public String a() {
        return "ThirdLevel implementation";
    }
}
