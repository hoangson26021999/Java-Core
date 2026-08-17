package oop.basics;

/**
 * Demonstrates constructors in Java.
 *
 * Key concepts:
 *   - Constructors initialize object state when an instance is created.
 *   - A static initializer block runs ONCE when the class is first loaded,
 *     before any constructor runs.
 *   - Constructor parameters allow passing initial values at creation time.
 *
 * Expected output:
 *   Static block: Vehicle class loaded
 *   Vehicle created: id=1, type=car
 *   id=1 type=car
 */
public class ConstructorExample {

    private int id;
    private String type;

    // Static initializer block — runs once when the class is first loaded
    static {
        System.out.println("Static block: Vehicle class loaded");
    }

    // Constructor with parameters
    public ConstructorExample(int id, String type) {
        this.id = id;
        this.type = type;
        System.out.println("Vehicle created: id=" + id + ", type=" + type);
    }

    public void printInfo() {
        System.out.printf("id=%d type=%s%n", id, type);
    }

    public static void main(String[] args) {
        // Static block fires here (first class load), then constructor
        ConstructorExample vehicle = new ConstructorExample(1, "car");
        vehicle.printInfo();

        // Second instantiation: static block does NOT fire again
        ConstructorExample vehicle2 = new ConstructorExample(2, "truck");
        vehicle2.printInfo();
    }
}
