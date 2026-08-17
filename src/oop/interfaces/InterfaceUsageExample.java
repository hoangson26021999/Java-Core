package oop.interfaces;

/**
 * Demonstrates how a class implements an interface hierarchy.
 *
 * Key concepts:
 *   - CatImpl implements ValidInterface, which extends DoItInterface.
 *     So CatImpl must implement ALL abstract methods from DoItInterface.
 *   - The interface constant (ABC = 0) is accessed through the interface type,
 *     NOT through the instance's own 'abc' field.
 *   - Upcasting to the interface type (DoItInterface a = new CatImpl()) restricts
 *     access to the interface's declared members only.
 *   - The default method type() is inherited and usable without override.
 *
 * Expected output:
 *   11       ← show() prints CatImpl's own abc field (11)
 *   something: 2  ← default method type() from DoItInterface
 *   0        ← a.ABC accesses the interface constant (always 0, not the instance field)
 */
public class InterfaceUsageExample {

    public static void main(String[] args) {
        // Upcast: reference type is DoItInterface, runtime type is CatImpl
        DoItInterface a = new CatImpl();

        a.show();    // prints 11 — CatImpl's own field (called via overridden method)
        a.type();    // default method from DoItInterface — prints "something: 2"

        // ABC is the interface constant (public static final int ABC = 0)
        // Even though CatImpl declares its own 'abc = 11',
        // accessing it through the interface reference gives the constant 0
        System.out.println(a.ABC); // 0 — interface constant
    }
}

/** Implements ValidInterface (which extends DoItInterface). */
class CatImpl implements ValidInterface {

    // Instance field — NOT the same as the interface constant ABC
    int abc = 11;

    @Override
    public void shout() {
        System.out.println("aaaa");
    }

    @Override
    public void show() {
        // Prints the instance field, not the interface constant
        System.out.println(abc); // 11
    }

    @Override
    public int id() {
        System.out.println("id");
        return 0;
    }
}
