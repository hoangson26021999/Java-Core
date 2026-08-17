package enums;

/**
 * Demonstrates an enum with a constructor and a field.
 *
 * Key concepts:
 *   - Enum constants can carry associated data by defining fields and a constructor.
 *   - The constructor is ALWAYS private (or package-private) — you cannot call it
 *     from outside. The JVM calls it once per constant at class-load time.
 *   - Use a getter to retrieve the associated value.
 *   - This pattern is useful for mapping enum constants to codes, labels, or
 *     other metadata without needing an external lookup table.
 *
 * Expected output:
 *   SUCCESS code: 0
 *   FAIL code: -1
 *   UNKNOWN code: -99
 */
public class EnumWithFieldExample {

    public enum Status {
        SUCCESS(0),
        FAIL(-1),
        UNKNOWN(-99);

        // Field attached to each constant
        private final int code;

        // Constructor — called once per constant at class load time
        Status(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    public static void main(String[] args) {
        for (Status s : Status.values()) {
            System.out.println(s.name() + " code: " + s.getCode());
        }

        // Direct access by constant
        System.out.println("\nLooking up FAIL: " + Status.FAIL.getCode()); // -1

        // Parsing from String
        Status parsed = Status.valueOf("SUCCESS");
        System.out.println("Parsed SUCCESS code: " + parsed.getCode()); // 0
    }
}
