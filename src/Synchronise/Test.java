package Synchronise;

import CompareAbsAndInterface.B;

class ObjSync {
    synchronized void sync(String threadName) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " : " + i);
            Thread.sleep(500);
        }
    }

    synchronized void sync2(String threadName) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " : " + i);
            Thread.sleep(500);
        }
    }

    synchronized static void syncStatic(String threadName) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " : " + i);
            Thread.sleep(500);
        }
    }

    synchronized static void sync2Static(String threadName) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " : " + i);
            Thread.sleep(500);
        }
    }

     void sync2SyncBLock(String threadName) throws InterruptedException {
         //Thread.sleep(500);
         synchronized(ObjSync.class) {
             for (int i = 1; i <= 5; i++) {
                 System.out.println(threadName + " : " + i);
                 Thread.sleep(500);
             }
         }

    }
}



public class Test {
    public static void main(String[] args) {
        ObjSync obj = new ObjSync();
        Thread t1 = new Thread(() -> {
            try {
                obj.sync("Thread 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //t1.start();

        Thread t2 = new Thread(() -> {
            try {
                obj.sync2("Thread 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //t2.start();
        Thread t3 = new Thread(() -> {
            try {
                ObjSync.syncStatic("Thread 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //t3.start();
        Thread t4 = new Thread(() -> {
            try {
                ObjSync.sync2Static("Thread 4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //t4.start();
        Thread t5 = new Thread(() -> {
            try {
                obj.sync2SyncBLock("Thread 5");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //t5.start();


        ObjSync obj2 = new ObjSync();
        ObjSync obj3 = new ObjSync();

        Thread t6 = new Thread(() -> {
            try {
                obj2.sync2SyncBLock("Thread 6");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t7 = new Thread(() -> {
            try {
                obj3.sync2SyncBLock("Thread 7");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t6.start();
        t7.start();
    }
}
