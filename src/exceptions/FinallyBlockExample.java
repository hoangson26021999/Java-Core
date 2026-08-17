package exceptions;

/**
 * Demonstrates the finally block in exception handling.
 *
 * Key concepts:
 *   - The finally block ALWAYS executes, regardless of whether an exception
 *     was thrown or caught.
 *   - It runs even when the catch block re-throws an exception.
 *   - Common use: resource cleanup (closing files, DB connections, etc.).
 *     In modern Java, prefer try-with-resources for AutoCloseable resources.
 *   - The only case finally does NOT run: System.exit() or JVM crash.
 *
 * Expected output:
 *   Trong try
 *   Trong catch: / by zero
 *   Khối finally luôn được thực thi!
 *   Exception in thread "main" java.lang.RuntimeException: Lỗi trong catch
 */
public class FinallyBlockExample {

    public static void main(String[] args) {
        try {
            System.out.println("Trong try");
            int a = 5 / 0; // throws ArithmeticException
        } catch (Exception e) {
            System.out.println("Trong catch: " + e.getMessage());
            // Re-throwing as a different exception type
            throw new RuntimeException("Lỗi trong catch");
        } finally {
            // This block ALWAYS runs — even though catch re-throws
            System.out.println("Khối finally luôn được thực thi!");
        }
    }
}
