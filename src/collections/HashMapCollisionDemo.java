package collections;

import java.util.HashMap;

/**
 * Demonstrates what happens when HashMap keys have intentionally colliding hash codes.
 *
 * Key concepts:
 *   - HashMap uses hashCode() to determine which bucket to store an entry in.
 *   - When two keys have the SAME hashCode, they land in the same bucket (collision).
 *   - Within a bucket, HashMap uses equals() to distinguish between entries.
 *   - If equals() always returns false (as in BadKey below), all colliding keys
 *     are kept as separate entries in the same bucket (a linked list or red-black tree).
 *   - This is why BOTH hashCode() AND equals() must be implemented correctly for
 *     objects used as Map keys.
 *
 * Common mistake:
 *   - Implementing hashCode() correctly but not equals() → duplicates survive.
 *   - Implementing equals() correctly but not hashCode() → equal objects hash
 *     to different buckets, get() never finds them.
 *
 * Expected output (3 entries, all with hashCode=42, all survive because equals=false):
 *   BadKey{A} -> Value A
 *   BadKey{B} -> Value B
 *   BadKey{C} -> Value C
 */
public class HashMapCollisionDemo {

    public static void main(String[] args) {
        HashMap<BadKey, String> map = new HashMap<>();

        // Three distinct keys — all return hashCode 42 → same bucket
        map.put(new BadKey("A"), "Value A");
        map.put(new BadKey("B"), "Value B");
        map.put(new BadKey("C"), "Value C");

        System.out.println("Entries in map: " + map.size()); // 3 — all survive
        map.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("\nAttempting get() with a new BadKey(\"A\"): "
                + map.get(new BadKey("A"))); // null! — equals() returns false, so no match found
    }
}

/**
 * A deliberately broken key class — intentional misuse to illustrate HashMap internals.
 *
 * hashCode() always returns 42 → forces all instances into the same bucket.
 * equals() always returns false → no two BadKey instances are ever considered equal.
 *
 * Result: HashMap can never find an existing entry by key — get() always returns null.
 */
class BadKey {
    private String value;

    public BadKey(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return 42; // fixed hash → collision guaranteed
    }

    @Override
    public boolean equals(Object o) {
        // Always false — even the same object won't match itself via get()
        return false;

        // Correct implementation would be:
        // if (this == o) return true;
        // if (!(o instanceof BadKey)) return false;
        // return Objects.equals(value, ((BadKey) o).value);
    }

    @Override
    public String toString() {
        return "BadKey{" + value + "}";
    }
}
