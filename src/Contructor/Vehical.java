package Contructor;

public class Vehical {
    int id ;
    String name ;

    static {
        System.out.printf("Khoi Static ");
    }

    Vehical(int id , String name) {
        this.id = id ;
        this.name = name;
    }

    void prinfInfor() {
        System.out.printf(id + " " + name);
    }

    public static  void  main(String[] args) {

        Vehical a = new Vehical(3,"car");
        a.prinfInfor();
    }

}

