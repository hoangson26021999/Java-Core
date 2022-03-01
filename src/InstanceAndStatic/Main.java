package InstanceAndStatic;

public class Main {
    int b = 1 ;
    static int a = 0 ;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        Main.a = a;
    }
    public void add () {
        b = b+1 ;
    }

    public static void main (String[] args) {
        System.out.println(Main.a);
        Main.a = 2 ;

        Main A = new Main() ;
        A.add();
        System.out.println(A.getA());
    }

}
