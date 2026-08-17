package experiments.scratch;

import java.util.Arrays;

/**
 * Scratch test — explores Arrays.asList().toArray(existingArray) behavior.
 *
 * Observation:
 *   When toArray(T[] a) is called with a destination array LARGER than the list,
 *   the list elements are placed at the start, position [list.size()] is set to null,
 *   and the rest are left unchanged. The returned array has the SAME LENGTH as the
 *   destination array, not the list size.
 *
 * Expected output: 10  (the length of array 'c', not the list size of 2)
 */
public class ArraysAsListTest {

    public static void main(String[] args) {
        String[] c = new String[10];
        Arrays.asList("aa", "ccc").toArray(c);
        // c = ["aa", "ccc", null, null, null, null, null, null, null, null]
        System.out.println(c.length); // 10 — length of the DESTINATION array
    }
}
