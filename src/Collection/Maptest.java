package Collection;

import java.util.*;

public class Maptest {
    public static void main(String args[]) {
        // init map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(4, "C");
        map.put(5, "C");
        map.put(3, "C");
        map.put(null, "NULL"); // Được push null key

        map.put(10, null); // Được push null value

        // show map
        System.out.println("HashMap");
        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        Map<Integer, String> treeMap = new TreeMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "A");
        linkedHashMap.put(2, "B");
        linkedHashMap.put(4, "C");
        linkedHashMap.put(5, "C");
        linkedHashMap.put(3, "C");

        // show map
        System.out.println("LinkedHashMap");
        for (Integer key : linkedHashMap.keySet()) {
            System.out.println(key + " " + linkedHashMap.get(key));
        }

        linkedHashMap.put(2, "D"); // Cập nhật giá trị cho key 2


//        Map<String , String> strmap = new HashMap<>();
//
//        strmap.put("null", "NULL");
//        System.out.println(strmap.get("null"));

    }
}
