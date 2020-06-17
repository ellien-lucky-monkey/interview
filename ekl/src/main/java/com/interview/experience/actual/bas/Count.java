package com.interview.experience.actual.bas;

import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class Count {

//    private static final int MAXIMUM_CAPACITY = 1 << 30;
//
//    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
//
//    static final int tableSizeFor(int cap) {
//        int n = cap - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
//    }
//
//    public static void main(String[] args) {
//        tableSizeFor(10);
//        tableSizeFor(16);
//
//        HashMap map = new HashMap();
//        map.put("1","1");
//        System.out.println("haha");
//    }


//    public static void main(String[] args) {
//        System.out.println(test());
//    }
//
//    private static int test() {
//        int temp = 1;
//        try {
//            System.out.println(temp);
//            return ++temp;
//        } catch (Exception e) {
//            System.out.println(temp);
//            return ++temp;
//        } finally {
//            ++temp;
//            System.out.println(temp);
//            return temp;
//        }
//    }


    private Object lock = new Object();
    private volatile boolean firstFinshed = false;
    private volatile boolean secondFinshed = false;


    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        new Thread(() -> {
            try {
                count.first(new ThreadA());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                count.second(new ThreadB());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    public void first(ThreadA threadA) throws InterruptedException {

        synchronized (lock) {
            threadA.run();
            firstFinshed = true;
            lock.notifyAll();
        }


    }

    public void second(ThreadB threadB) throws InterruptedException {

        synchronized (lock) {
            while (!firstFinshed) {
                lock.wait();
                for (int i = 0; i < 4; i++) {
                    threadB.run();
                }
                secondFinshed = true;
                lock.notifyAll();
            }


        }
    }
}


class ThreadA implements Runnable {

    @Override
    public void run() {
        System.out.println("A");
    }
}


class ThreadB implements Runnable {

    @Override
    public void run() {
        System.out.println("B");
    }
}
