package Interface;

public interface DoIt  {
    int abc = 0 ;
    void shout();
    int id () ;

    static int help () {
        return 2 ;
    }
    default void type() {
        System.out.println("something : "+ help());
    }

    void show();
}
