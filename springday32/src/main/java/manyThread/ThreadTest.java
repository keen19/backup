package manyThread;

import java.util.Scanner;

public class ThreadTest {
    // 线程死循环演示
    public static void createBusyThread() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while(true) {
                    ;
                }
            }
        },"while_true").start();
    }

    // 线程锁等待演示
    public static void createLockThread(final Object lock) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        },"wait").start();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.next();

        createBusyThread();
        sc.next();

        Object obj = new Object();
        createLockThread(obj);
    }
}


