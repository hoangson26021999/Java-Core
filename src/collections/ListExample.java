package collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates the List interface and ArrayList implementation.
 *
 * Key concepts:
 *   - List is an ordered collection that ALLOWS DUPLICATES.
 *   - Elements maintain insertion order.
 *   - add(index, element) inserts at a specific position, shifting subsequent elements.
 *   - get(index) retrieves by zero-based index.
 *   - ArrayList is backed by a dynamic array — fast random access, slower insertions.
 *
 * Expected output:
 *   Phan tu co index = 2 la: C++
 *   Java
 *   Python
 *   C++
 *   PHP
 *   Java     ← duplicate allowed
 */
public class ListExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("C++");
        list.add("PHP");
        list.add("Java");            // duplicate — allowed in List
        list.add(1, "Python");       // inserts at index 1, shifts everything right

        // After insertion: [Java, Python, C++, PHP, Java]
        System.out.println("Phan tu co index = 2 la: " + list.get(2)); // C++

        System.out.println("All elements:");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("\nList size: " + list.size()); // 5
        System.out.println("Contains 'PHP': " + list.contains("PHP")); // true
        System.out.println("Index of 'Java': " + list.indexOf("Java")); // 0 (first occurrence)
    }
}
