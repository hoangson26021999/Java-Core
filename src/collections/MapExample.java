package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Demonstrates HashMap, LinkedHashMap, and TreeMap.
 *
 * Comparison:
 *   HashMap        — no guaranteed ordering; allows one null key and multiple null values.
 *                    Fastest for put/get (O(1) average).
 *   LinkedHashMap  — preserves INSERTION ORDER; allows null key/values.
 *                    Slightly slower than HashMap due to doubly-linked list overhead.
 *   TreeMap        — keys are SORTED in natural order (or by Comparator).
 *                    Does NOT allow null keys. O(log n) for put/get.
 *
 * Expected output (HashMap order is not guaranteed):
 *   HashMap — null key and null value are allowed; order is unpredictable
 *   LinkedHashMap — insertion order is preserved: 1, 2, 4, 5, 3
 *   TreeMap — keys sorted: 1, 2, 3, 4, 5
 */
public class MapExample {

    public static void main(String[] args) {
        System.out.println("=== HashMap ===");
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "A");
        hashMap.put(2, "B");
        hashMap.put(4, "C");
        hashMap.put(5, "C");
        hashMap.put(3, "C");
        hashMap.put(null, "NULL");  // null key allowed in HashMap
        hashMap.put(10, null);      // null value allowed
        hashMap.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("\n=== LinkedHashMap (insertion order preserved) ===");
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "A");
        linkedHashMap.put(2, "B");
        linkedHashMap.put(4, "C");
        linkedHashMap.put(5, "C");
        linkedHashMap.put(3, "C");
        linkedHashMap.forEach((k, v) -> System.out.println(k + " -> " + v));

        // Updating an existing key does not change its position
        linkedHashMap.put(2, "D");
        System.out.println("After update key=2: " + linkedHashMap.get(2)); // D — still at original position

        System.out.println("\n=== TreeMap (keys sorted ascending) ===");
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(5, "E");
        treeMap.put(1, "A");
        treeMap.put(3, "C");
        treeMap.put(2, "B");
        treeMap.put(4, "D");
        treeMap.forEach((k, v) -> System.out.println(k + " -> " + v));
        // TreeMap does NOT allow null keys — would throw NullPointerException
    }
}
