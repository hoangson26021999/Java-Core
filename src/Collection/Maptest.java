package Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Maptest {
    public static void main(String args[]) {
        // init map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        // show map
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
