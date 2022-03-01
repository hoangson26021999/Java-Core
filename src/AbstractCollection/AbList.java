package AbstractCollection;

import java.util.*;

 class Vehical {
    private static int id  ;
}
class Car extends  Vehical {

}
public class AbList {
    public  static  void main (String[] args) {

        AbstractList<Integer> a = new AbstractList<Integer>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public Integer get(int index) {
                return null;
            }
        } ;

        AbstractSet<Integer> b = new AbstractSet<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };

        AbstractMap<Integer,String> c = new AbstractMap<Integer, String>() {
            @Override
            public Set<Entry<Integer, String>> entrySet() {
                return null;
            }
        } ;

    }
}
