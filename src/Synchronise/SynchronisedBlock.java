package Synchronise;

class MyThreadA extends Thread {
    Table t;

    MyThreadA(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(5);
    }

}

class MyThreadB extends Thread {
    Table t;

    MyThreadB(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(100);
    }
}


public class SynchronisedBlock {

    public static void main(String args[]) {
        Table obj = new Table();// tao object duy nhat
        Table obj2 = new Table();// tao object duy nhat
        MyThreadA t1 = new MyThreadA(obj);
        MyThreadB t2 = new MyThreadB(obj2);
        t1.start();
        t2.start();
    }
}
