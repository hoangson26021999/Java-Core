package experiments.collections;

import java.util.*;

/**
 * Demonstrates instantiating AbstractList, AbstractSet, and AbstractMap
 * via anonymous subclasses with minimal method implementations.
 *
 * This file is in experiments/ because it explores the internal JDK abstract
 * collection classes directly — a topic most learners don't need in everyday code.
 * The practical takeaway is understanding what minimum contract each class requires.
 *
 * AbstractList  — requires: size(), get(int)
 * AbstractSet   — requires: iterator(), size()
 * AbstractMap   — requires: entrySet()
 */
public class AbstractCollectionDemo {

    public static void main(String[] args) {
        // AbstractList — minimum implementation: size() and get(int index)
        AbstractList<Integer> list = new AbstractList<Integer>() {
            @Override public int size() { return 0; }
            @Override public Integer get(int index) { return null; }
        };
        System.out.println("AbstractList size: " + list.size());

        // AbstractSet — minimum implementation: iterator() and size()
        AbstractSet<Integer> set = new AbstractSet<Integer>() {
            @Override public Iterator<Integer> iterator() { return null; }
            @Override public int size() { return 0; }
        };
        System.out.println("AbstractSet size: " + set.size());

        // AbstractMap — minimum implementation: entrySet()
        AbstractMap<Integer, String> map = new AbstractMap<Integer, String>() {
            @Override public Set<Entry<Integer, String>> entrySet() { return null; }
        };
        System.out.println("AbstractMap entrySet: " + map.entrySet());
    }
}
