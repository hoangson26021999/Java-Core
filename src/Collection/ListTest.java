package Collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("C++");
        list.add("PHP");
        list.add("Java");
        list.add(1, "Python");
        System.out.println("Phan tu co index = 2 la: " + list.get(2));
        // show list
        for (String s : list) {
            System.out.println(s);
        }
    }
}
