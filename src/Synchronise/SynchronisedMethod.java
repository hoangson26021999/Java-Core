package Synchronise;


class Table {

    synchronized static void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    synchronized static void printTable2(int n) {

        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    synchronized void printTableNoStatic(int n) {

        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    synchronized void printTable2NoStatic(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    synchronized void printTable3NoStatic(int n) {
        synchronized(Table.class){
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }


    }

    synchronized void printTable4NoStatic(int n) {
        synchronized(Table.class){
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

    }
}

class MyThread1 extends Thread {
    Table t;

    MyThread1(Table t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(5);
    }

}

class MyThread2 extends Thread {
    Table t;

    MyThread2(Table t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable2(100);
    }
}

class MyThread3 extends Thread {
    Table t;

    MyThread3(Table t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTableNoStatic(5);
    }

}

class MyThread4 extends Thread {
    Table t;

    MyThread4(Table t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable2NoStatic(100);
    }
}

public class SynchronisedMethod {

    public static void main(String args[]) {
        int testCase = 3;
        switch (testCase) {
            case 1:
                // Trường hợp khi 2 hàm là synchronized static
                Table obj = new Table(); // tao object duy nhat
                MyThread1 t1 = new MyThread1(obj);
                MyThread2 t2 = new MyThread2(obj);
                t1.start();
                t2.start();
                // => Khóa trên class Table nên 2 thằng bị blocking => code xảy ra tuần tự với nhau
                break;
            case 2:
                // Trường hợp khi 2 hàm là synchronized
                Table obj2 = new Table(); // tao object duy nhat
                MyThread3 t3 = new MyThread3(obj2);
                MyThread4 t4 = new MyThread4(obj2);
                t3.start();
                t4.start();
                // => Khóa trên obj2 nên 2 thằng bị blocking => code xảy ra tuần tự với nhau
                break;
            case 3:
                // Trường hợp khi 1 hàm là synchronized static và 1 hàm là synchronized
                Table obj3 = new Table(); // tao object duy nhat
                MyThread1 t11 = new MyThread1(obj3);
                MyThread4 t41 = new MyThread4(obj3);
                t11.start();
                t41.start();
                break;
            default:
                break;
        }

        /**
         * Note lại các biểu hiện
         */
    }
}
