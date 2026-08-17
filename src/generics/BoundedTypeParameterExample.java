package generics;

/**
 * Demonstrates bounded type parameters in generic methods.
 *
 * Key concepts:
 *   - <T extends Comparable<T>> is an upper bounded type parameter.
 *     It restricts T to types that implement Comparable — meaning they can
 *     be compared to each other using compareTo().
 *   - Without the bound, you could not call compareTo() inside the method
 *     (the compiler would not know T has that method).
 *   - Works with any Comparable type: Integer, Double, String, and custom types.
 *
 * Expected output:
 *   Max of 3, 4, 5 is: 5
 *   Max of 6.6, 8.8, 7.7 is: 8.8
 *   Max of "pear", "apple", "orange" is: pear
 */
public class BoundedTypeParameterExample {

    /**
     * Returns the maximum of three values.
     * T must implement Comparable so we can use compareTo().
     *
     * @param <T> any type that is Comparable to itself
     */
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) max = y;
        if (z.compareTo(max) > 0) max = z;
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Max of 3, 4, 5 is: " + maximum(3, 4, 5));
        System.out.println("Max of 6.6, 8.8, 7.7 is: " + maximum(6.6, 8.8, 7.7));
        System.out.println("Max of \"pear\", \"apple\", \"orange\" is: "
                + maximum("pear", "apple", "orange")); // lexicographic comparison
    }
}
