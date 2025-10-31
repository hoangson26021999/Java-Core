package PV;

import java.util.HashMap;
import java.util.Objects;

class BadKey {
    private String value;

    public BadKey(String value) {
        this.value = value;
    }

    // Cố tình trả về cùng hashCode cho tất cả object
    @Override
    public int hashCode() {
        return 42; // hash cố định → collision
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BadKey)) return false;
        BadKey badKey = (BadKey) o;
        return Objects.equals(value, badKey.value);
    }

    @Override
    public String toString() {
        return "BadKey{" + value + '}';
    }
}

public class HashMapCollisionDemo {
    public static void main(String[] args) {
        HashMap<BadKey, String> map = new HashMap<>();

        // Thêm 3 key khác nhau nhưng có cùng hashCode
        map.put(new BadKey("A"), "Value A");
        map.put(new BadKey("B"), "Value B");
        map.put(new BadKey("C"), "Value C");

        // In ra map
        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
