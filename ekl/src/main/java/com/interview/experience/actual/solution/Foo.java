package com.interview.experience.actual.solution;

import java.util.concurrent.Semaphore;

/**
 * @author Jiangkui
 * @since 2019/12/20 17:30
 */
public class Foo {

    private Object lock = new Object();
    private volatile boolean firstFinshed = false;
    private volatile boolean secondFinshed = false;

    private Semaphore A = new Semaphore(1);
    private Semaphore B = new Semaphore(0);
    private Semaphore C = new Semaphore(0);

    public static void main(String[] args) {

    }

    public Foo() {


    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinshed = true;
            lock.notifyAll();
        }


    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (lock) {
            while (!firstFinshed) {
                lock.wait();
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                secondFinshed = true;
                lock.notifyAll();
            }


        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        synchronized (lock) {
            while (!secondFinshed) {
                lock.wait();
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();

            }
        }
    }
}