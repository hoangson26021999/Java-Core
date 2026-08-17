package enums;

/**
 * Demonstrates enum comparison and type safety.
 *
 * Key concepts:
 *   - Enum constants are singletons — use == for comparison (preferred, type-safe).
 *   - .equals() also works but is NOT type-safe: comparing enums of different types
 *     compiles fine but always returns false, hiding bugs.
 *   - Comparing with == across different enum types is a COMPILE ERROR — the compiler
 *     catches the mistake for you immediately.
 *   - Enums can be nested inside classes.
 *   - A method returning a boolean based on enum state is a clean pattern.
 *
 * Expected output:
 *   chua duoc giao
 *   hop ly
 *   (nothing for the .equals(TestColor.GREEN) block — always false, silent bug)
 */
public class EnumComparisonExample {

    private PizzaStatus status;

    public enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED
    }

    public enum TestColor {
        GREEN
    }

    /**
     * Returns true only if the pizza status is READY.
     * Note: if status is null (never set), this will throw NullPointerException.
     */
    public boolean isDeliverable() {
        return this.status == PizzaStatus.READY;
    }

    public PizzaStatus getStatus() { return status; }
    public void setStatus(PizzaStatus status) { this.status = status; }

    public static void main(String[] args) {
        EnumComparisonExample pizza1 = new EnumComparisonExample();
        // status is null — isDeliverable() would NPE; skip calling it here
        // pizza1.setStatus(PizzaStatus.ORDERED); // uncomment to test

        System.out.println("=== == comparison (type-safe, preferred) ===");
        EnumComparisonExample pizza2 = new EnumComparisonExample();
        pizza2.setStatus(PizzaStatus.DELIVERED);

        if (pizza2.getStatus() == PizzaStatus.DELIVERED) {
            System.out.println("hop ly"); // correct match
        }

        // Compile error — == across different enum types is caught at compile time:
        // if (pizza2.getStatus() == TestColor.GREEN) { } // DOES NOT COMPILE

        System.out.println("\n=== .equals() comparison (not type-safe) ===");
        // This compiles, but always returns false — a silent bug
        if (pizza2.getStatus().equals(TestColor.GREEN)) {
            System.out.println("vo ly — this never prints");
        } else {
            System.out.println("equals() across different enum types is always false (silent bug)");
        }

        System.out.println("\n=== Deliverability check ===");
        EnumComparisonExample pizza3 = new EnumComparisonExample();
        pizza3.setStatus(PizzaStatus.READY);
        System.out.println("Is deliverable: " + pizza3.isDeliverable()); // true

        pizza3.setStatus(PizzaStatus.ORDERED);
        System.out.println("Is deliverable: " + pizza3.isDeliverable()); // false
    }
}
