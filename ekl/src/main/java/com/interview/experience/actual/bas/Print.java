package com.interview.experience.actual.bas;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);


        integers.forEach(k -> {
                    for (int i = 1; i < 50; i++) {
                        if (i == 13) {
                            continue;
                        }
                        System.out.println("args = " + i);
                    }
                }
        );
    }
}
