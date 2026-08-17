package collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Demonstrates the Set interface and HashSet implementation.
 *
 * Key concepts:
 *   - Set does NOT allow duplicate elements.
 *   - Adding the same element twice is silently ignored (add() returns false).
 *   - HashSet allows ONE null element.
 *   - HashSet does NOT guarantee any ordering.
 *   - Backed by a HashMap internally — O(1) average for add, contains, remove.
 *
 * Expected output (order is not guaranteed):
 *   Số phần tử của setA: 4   ← "Java" added twice → counted once; null counts as 1
 *   Các phần tử của setA: [Java, Python, PHP, null]   (order varies)
 *   setA có chứa Java không? true
 *   setA có chứa C++ không? false
 */
public class SetExample {

    public static void main(String[] args) {
        Set<String> setA = new HashSet<>();
        setA.add("Java");
        setA.add("Python");
        setA.add("Java");   // duplicate — ignored, returns false
        setA.add("PHP");
        setA.add(null);     // HashSet allows a single null element

        System.out.println("Số phần tử của setA: " + setA.size()); // 4
        System.out.println("Các phần tử của setA: " + setA);

        System.out.println("setA có chứa Java không? " + setA.contains("Java")); // true
        System.out.println("setA có chứa C++ không? " + setA.contains("C++"));   // false

        // add() returns false when duplicate is rejected
        boolean added = setA.add("Java");
        System.out.println("\nAdding 'Java' again: " + added); // false

        System.out.println("Size after duplicate add attempt: " + setA.size()); // still 4
    }
}
