package experiments.scratch;

/**
 * Scratch test — explores pre-increment (++i) vs post-increment (i++) in a loop.
 *
 * Observation:
 *   When the increment expression is used as a STANDALONE STATEMENT (not as part
 *   of a larger expression), ++i and i++ produce identical results.
 *   The return value of the expression is discarded, so the distinction is irrelevant.
 *
 * Both loops below print 1 through 5 — identical output.
 *
 * The difference MATTERS when the value is used inline:
 *   int a = i++;  // a gets the OLD value of i, then i is incremented
 *   int b = ++i;  // i is incremented first, then b gets the NEW value
 */
public class IncrementOperatorTest {

    public static void main(String[] args) {
        System.out.println("=== i++ (post-increment as standalone statement) ===");
        for (int i = 0; i < 5; ) {
            i++;
            System.out.println(i); // 1, 2, 3, 4, 5
        }

        System.out.println("=== ++i (pre-increment as standalone statement) ===");
        for (int i = 0; i < 5; ) {
            ++i;
            System.out.println(i); // 1, 2, 3, 4, 5 — same output
        }

        System.out.println("=== Difference when used inline ===");
        int x = 0;
        int a = x++; // a = 0, x becomes 1
        System.out.println("x++ inline: a=" + a + ", x=" + x);

        int y = 0;
        int b = ++y; // y becomes 1, b = 1
        System.out.println("++y inline: b=" + b + ", y=" + y);
    }
}
