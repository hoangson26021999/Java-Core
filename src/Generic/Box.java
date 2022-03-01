package Generic;

/**
 * Generic version of the Box class.
 * @param <T> the type of the value being boxed
 */
public class Box<T> {
    // T stands for "Type"
    private T t;

    public Box(T a) {
        this.t = a ;
    }
    public void set(T t) { this.t = t; }
    public T get() { return t; }

    public static void main (String[] args) {

        Box<String> a = new Box<>("aaaaa");

        System.out.println(a.get());

    }
}
