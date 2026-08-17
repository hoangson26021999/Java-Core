package oop.nestedclasses;

/**
 * Demonstrates local classes — classes defined inside a method body.
 *
 * Key concepts:
 *   - A local class is scoped to the method where it is defined.
 *   - It can access static fields from the enclosing class.
 *   - It can access local variables from the method, but ONLY if those
 *     variables are effectively final (not reassigned after first assignment).
 *   - This rule is enforced by the compiler since Java 8.
 *
 * Expected output:
 *   First number is 1234567890
 *   Second number is invalid
 */
public class LocalClassExample {

    static String regularExpression = "[^0-9]"; // matches any non-digit character

    public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {
        final int numberLength = 10;
        // numberLength is effectively final — local class can capture it

        // Local class — only visible within this method
        class PhoneNumber {
            String formattedPhoneNumber = null;

            PhoneNumber(String phoneNumber) {
                // Strip all non-digit characters using the outer class's static field
                String currentNumber = phoneNumber.replaceAll(regularExpression, "");
                if (currentNumber.length() == numberLength) {
                    formattedPhoneNumber = currentNumber;
                }
                // else formattedPhoneNumber stays null → invalid
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        if (myNumber1.getNumber() == null) {
            System.out.println("First number is invalid");
        } else {
            System.out.println("First number is " + myNumber1.getNumber());
        }

        if (myNumber2.getNumber() == null) {
            System.out.println("Second number is invalid");
        } else {
            System.out.println("Second number is " + myNumber2.getNumber());
        }
    }

    public static void main(String[] args) {
        validatePhoneNumber("123-456-7890", "456-7890");
    }
}
