package com.interview.experience.actual.bas;

public class Print {
    private boolean printA = true;

    private synchronized void printA() throws InterruptedException {
        while (!printA) wait();
        System.out.println("A");
        printA = false;
        notifyAll();
    }

    private synchronized void printB() throws InterruptedException {
        while (printA) wait();
        for (int i = 0; i < 4; i++) {
            System.out.println("B");
        }
        printA = true;
        notifyAll();
    }

    private Thread a = new Thread(() -> {
        while (!Thread.interrupted()) {
            try {
                printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    private Thread b = new Thread(() -> {
        while (!Thread.interrupted()) {
            try {
                printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    public Print() throws InterruptedException {
        new Thread(() -> a.run()).start();
        new Thread(() -> b.run()).start();
        Thread.sleep(10000);
        System.exit(0);
    }


    public static void main(String[] args) throws InterruptedException {
        new Print();
    }
}
