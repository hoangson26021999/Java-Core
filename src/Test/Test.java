package Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Test {
    public Day day ;
    public static void main(String[] args) {
        String a =  ( 1 > 0) ? "a" : "b" ;
        ArrayList<Integer> array = new ArrayList<>() ;

        Test c = new Test() ;
        c.day = Day.Monday ;
        Test b = new Test() ;
        b.day = Day.Tuesday ;
        Test d = new Test() ;
        d.day = Day.Wednesday ;

    }

}
enum Day {
    Monday ,Tuesday, Wednesday;
}

