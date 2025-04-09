package CompareAbsAndInterface;

public abstract class TestAbs {
    String a = "kekeke" ;
    String u = "kakak" ;
    public abstract String a ();
    public void b (){
        System.out.println("parent shout");
    }

    public void c (){
        System.out.println("parent helo");
    }
    public static void main(String[] args) {
        //TestAbs test1Abs = new TestAbs() {}; Không thể trức tiếp tạo đối tượng abstract
        TestAbs test2Abs = new Child();
        System.out.println(test2Abs.a());
        test2Abs.b();
        test2Abs.c();
        //System.out.println(test2Abs.lolo()); Upcasting thì chỉ truy cập được các phương thức , thuộc tính của lớp cha. Nếu như có phương thức trùng tên ở lớp con thì gọi lớp con

        Child aaa = (Child) test2Abs;
        aaa.lolo();
        aaa.yyyy();
        // down casting thì chỉ truy cập được phương thức, thuộc tính của  lớp con ( tất nhiên là do có kế thừa nên vẫn truy cập được các thuộc tính đc kế thừa)
        Child ccc = new Child();
        ccc.c();
        ccc.b();
        ccc.yyyy();
        System.out.println(ccc.a);
        System.out.println(ccc.u);
    }
}

class Child extends TestAbs{
    String u = "plplp";
    int k = 1;
    public void lolo() {
        System.out.println(a);
    }
    public void yyyy() {
        System.out.println(u);
    }
    public void b (){
        System.out.println("child shout ");
    }
    @Override
    public String a() {
        return "Helu";
    }
}
