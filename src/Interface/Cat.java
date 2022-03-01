package Interface;

public class Cat  implements Valid {

    int abc =11 ;

    public void shout() {
        System.out.println("aaaa");
    }

    public void show() {
        System.out.println(abc);
    }

    public int id() {
        System.out.println("id");
        return 0 ;
    }

    public static void main(String[] args) {
        DoIt a = new Cat() ;
        a.show();

        a.type() ;
        System.out.println(a.abc);
    }
}
