package Abstract;

public abstract class AbsClass {

    int a=1 ;
    int b = 2;
    abstract String a ();

    public void b(){
        System.out.println(a());
    }

    public void c(){
        System.out.println( "a: " +a + "--- b:" + b);
    }

    public static void main (String[] args) {
        Child c = new Child(50,100);
        c.b();
        Child2 d = new Child2();
        d.b();
    }
}

class Child extends AbsClass {

Child(int a , int b){
    this.a = a;
    this.b = b ;
}
    @Override
    String a() {
        return "child1";
    }
}
class Child2 extends AbsClass {

    @Override
    String a() {
        return "child2";
    }
}
