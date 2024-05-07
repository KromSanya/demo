package com.example;

public class ThirdTask {
    
    public static void third() {
        MyThread1 thread1 = new MyThread1();
        MyThread2 thread2 = new MyThread2();
        MyThread3 thread3 = new MyThread3();

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Waiting for all threads to finish...");
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

        System.out.println("All threads finished. Main thread continues.");
    }
}



class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from MyThread1!");
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread1 finished.");
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from MyThread2!");
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread2 finished.");
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from MyThread3!");
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread3 finished.");
    }
}