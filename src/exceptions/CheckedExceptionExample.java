package exceptions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 * Demonstrates checked exceptions and introduces Virtual Thread exception handling.
 *
 * Key concepts:
 *   - Checked exceptions (e.g., IOException) MUST be declared with 'throws'
 *     or handled with try-catch. The compiler enforces this.
 *   - Unchecked exceptions (e.g., ArithmeticException, RuntimeException)
 *     do NOT need to be declared — they extend RuntimeException.
 *   - Virtual threads (Java 21+): Executors.newVirtualThreadPerTaskExecutor()
 *     runs each task on a lightweight virtual thread. Exceptions thrown inside
 *     CompletableFuture tasks wrap the original exception in a CompletionException.
 *
 * NOTE: The virtual thread example requires Java 21+.
 *       Uncomment the relevant block to experiment.
 */
public class CheckedExceptionExample {

    /**
     * This method declares 'throws IOException' — a checked exception.
     * Any caller MUST either catch IOException or also declare throws IOException.
     */
    void methodThatThrowsChecked() throws IOException {
        // Simulates a checked exception scenario
        throw new IOException("Simulated IO failure");
    }

    public static void main(String[] args) {
        System.out.println("=== Checked exception — must handle at compile time ===");
        CheckedExceptionExample example = new CheckedExceptionExample();
        try {
            example.methodThatThrowsChecked();
        } catch (IOException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }

        System.out.println("\n=== Unchecked exception — no declaration needed ===");
        int age = 11;
        try {
            if (age < 18) {
                throw new ArithmeticException("Ban chua du tuoi!");
            }
        } catch (ArithmeticException e) {
            System.out.println("Caught unchecked: " + e.getMessage());
        }

        // --- Virtual thread experiment (Java 21+) ---
        // Uncomment the block below to see how exceptions propagate from virtual threads.
        //
        // try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
        //     List<String> items = Arrays.asList("a", "b", "c");
        //     List<CompletableFuture<Void>> futures = items.stream()
        //             .map(item -> CompletableFuture.runAsync(() -> {
        //                 System.out.println("Processing: " + item);
        //                 if (item.equals("b")) throw new RuntimeException("Failed on: " + item);
        //             }, executor))
        //             .toList();
        //     // join() re-throws any exception as CompletionException
        //     CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        // } catch (Exception e) {
        //     System.out.println("Virtual thread exception: " + e.getMessage());
        // }
    }
}
