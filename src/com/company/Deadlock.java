package com.company;

public class Deadlock {


    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println("Th1 lock1");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println("Th1 lock2");
                    }
                }
            }
        };


    Runnable run2 = new Runnable() {
        @Override
        public void run() {
            synchronized (lock2){
                System.out.println("Th2 lock2");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("Th1 lock1");
                }
            }
        }
    };

        new Thread(run1).start();
        new Thread(run2).start();
    }


}
