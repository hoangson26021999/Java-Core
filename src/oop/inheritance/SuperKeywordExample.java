package oop.inheritance;

/**
 * Demonstrates the super keyword in Java.
 *
 * Key concepts:
 *   - super.field accesses the parent class field (bypasses child's shadowed field).
 *   - super.method() explicitly calls the parent's version of an overridden method.
 *   - super() in a constructor calls the parent constructor.
 *   - Field access through an upcast reference uses the REFERENCE type (no polymorphism).
 *   - Method calls through an upcast reference use the RUNTIME type (polymorphism).
 *
 * Expected output:
 *   Using super to access parent field: Biến lớp cha
 *   Without super (child's field): Biến lớp con
 *   ---
 *   Polymorphic method call (Parent ref → Child object):
 *   Using super to access parent field: Biến lớp cha
 *   Without super (child's field): Biến lớp con
 *   Field via parent reference (no polymorphism): Biến lớp cha
 *   getName() via parent reference (polymorphic): Biến lớp con
 */
public class SuperKeywordExample {

    public static void main(String[] args) {
        System.out.println("=== Direct child instance ===");
        SuperChild child = new SuperChild("Tp.HCM");
        child.display1();

        System.out.println("\n=== Upcasting: Parent reference → Child object ===");
        SuperParent parent = new SuperChild("Hihi");
        // display1() is overridden → runtime dispatch calls Child.display1()
        parent.display1();
        parent.display3();

        System.out.println("\n=== Field vs method polymorphism ===");
        SuperParent p = new SuperChild();
        // Field access: uses the reference type (SuperParent) → parent's field
        System.out.println("p.name (field, no polymorphism): " + p.name);
        // Method call: uses the runtime type (SuperChild) → child's getName()
        System.out.println("p.getName() (method, polymorphic): " + p.getName());

        System.out.println("\n=== Downcasting back to SuperChild ===");
        SuperChild downcast = (SuperChild) p;
        downcast.display1();
        downcast.display2();
    }
}

/** Parent class — defines the base fields and methods. */
class SuperParent {
    public String name = "Biến lớp cha";
    public String address = "Hà Nội";

    public SuperParent() {}

    public void display1() {
        System.out.println("Name: " + name);
    }

    public void display3() {
        System.out.println("Quê quán: " + address);
    }

    String getName() {
        return name;
    }
}

/** Child class — shadows parent's name field and overrides methods. */
class SuperChild extends SuperParent {
    // Shadows SuperParent.name — a new field, not the same variable
    public String name = "Biến lớp con";

    public SuperChild() {}

    public SuperChild(String address) {
        // super() is implicit; we just override address via the inherited field
        this.address = address;
    }

    @Override
    String getName() {
        return name; // returns the child's shadowed field
    }

    @Override
    public void display1() {
        // super.name explicitly reaches the parent's field
        System.out.println("Using super to access parent field: " + super.name);
        // Without super, 'name' refers to this child's own field
        System.out.println("Without super (child's field): " + name);
    }

    public void display2() {
        System.out.println("Nơi ở: " + address);
    }
}
