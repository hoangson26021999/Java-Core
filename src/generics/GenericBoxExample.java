package generics;

/**
 * Demonstrates a generic class with a single type parameter.
 *
 * Key concepts:
 *   - A generic class uses a type parameter (T) declared after the class name.
 *   - T is a placeholder — the actual type is supplied at the use site: Box<String>.
 *   - Without generics, you'd use Object and need explicit casts everywhere.
 *   - Type safety: Box<String> only accepts Strings; a Box<Integer> only accepts Integers.
 *   - T stands for "Type" by convention. Other common names: E (Element), K (Key), V (Value).
 *
 * Expected output:
 *   aaaaa
 */
public class GenericBoxExample {

    /**
     * A generic container for any type T.
     *
     * @param <T> the type of the value stored in this box
     */
    static class Box<T> {
        // T stands for "Type"
        private T t;

        public Box(T value) {
            this.t = value;
        }

        public void set(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }

    public static void main(String[] args) {
        // Type parameter is String — the compiler enforces type safety
        Box<String> stringBox = new Box<>("aaaaa");
        System.out.println(stringBox.get()); // "aaaaa" — no cast needed

        // Type parameter is Integer
        Box<Integer> intBox = new Box<>(42);
        System.out.println(intBox.get()); // 42

        // Without generics (pre-Java 5 style):
        // Box rawBox = new Box("hello");
        // String s = (String) rawBox.get(); // explicit cast needed — risk of ClassCastException
    }
}
