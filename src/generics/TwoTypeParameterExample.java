package generics;

/**
 * Demonstrates a generic class with two type parameters (K, V).
 *
 * Key concepts:
 *   - A class can declare multiple type parameters: Dictionary<K, V>.
 *   - By convention, K is used for keys and V for values (like java.util.Map).
 *   - This allows fully type-safe key-value pairs without casts.
 *
 * Expected output:
 *   Study: hoc
 */
public class TwoTypeParameterExample {

    /**
     * A generic key-value container.
     *
     * @param <K> the key type
     * @param <V> the value type
     */
    static class Dictionary<K, V> {
        private K key;
        private V value;

        public Dictionary(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public void setKey(K key) { this.key = key; }

        public V getValue() { return value; }
        public void setValue(V value) { this.value = value; }
    }

    public static void main(String[] args) {
        Dictionary<String, String> dict = new Dictionary<>("Study", "hoc");
        String english = dict.getKey();
        String vietnamese = dict.getValue();
        System.out.println(english + ": " + vietnamese); // Study: hoc

        // Different type parameters — same class, different contract
        Dictionary<Integer, Boolean> flags = new Dictionary<>(404, false);
        System.out.println(flags.getKey() + " found: " + flags.getValue()); // 404 found: false
    }
}
