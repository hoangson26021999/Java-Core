package oop.interfaces;

/**
 * Demonstrates multiple interface implementation and the diamond default method conflict.
 *
 * Key concepts:
 *   - A class can implement multiple interfaces.
 *   - If two interfaces declare a default method with the SAME name and signature,
 *     the implementing class MUST override that method — the compiler forces this.
 *   - Without the override, the compiler reports an error:
 *     "class inherits unrelated defaults for getStaticString() from InterfaceA and InterfaceB"
 *
 * Expected output:
 *   Name
 *   Hihi
 *   B
 */
public class MultipleInterfaceExample implements InterfaceA, InterfaceB {

    @Override
    public String getName() {
        return "Name";
    }

    @Override
    public String getAuthor() {
        return "Son";
    }

    /**
     * Mandatory override — both InterfaceA and InterfaceB define getStaticString()
     * as a default method with the same signature. The class must resolve the ambiguity
     * by providing its own implementation.
     */
    @Override
    public String getStaticString() {
        // Could also delegate: return InterfaceA.super.getStaticString();
        return "Hihi";
    }

    @Override
    public int getAge() {
        return 0;
    }

    public static void main(String[] args) {
        MultipleInterfaceExample imp = new MultipleInterfaceExample();
        System.out.println(imp.getName());         // "Name"
        System.out.println(imp.getStaticString()); // "Hihi" — our explicit override
        System.out.println(imp.getB());            // "B" — from InterfaceB default, no conflict
    }
}
