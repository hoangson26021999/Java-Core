package NestedClass;

public class OuterClass {
    private String name = "OuterClass" ;
    private  static int id = 9 ;

    class InnerClass {
        int inner_id = 0 ;
        int id = 7 ;
        void printid() {
            System.out.println(this.id);
            System.out.println(OuterClass.this.id);
        }
    }
    static class StaticInnerClass {
        static int id = 0 ;
        void printid () {
            System.out.println(id);

        }

    }
    public static void main(String[] args) {

        OuterClass outer = new OuterClass() ;
        OuterClass.InnerClass inner = outer. new InnerClass() ;

        System.out.println(inner.inner_id);
        inner.printid();

        StaticInnerClass staticinnerclass = new StaticInnerClass() ;
        staticinnerclass.printid();
    }
}
