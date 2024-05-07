package com.example;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

class AdderThread8 extends Thread {
    private ArrayList<Integer> list;
    private ReentrantLock lock;
    private Random random;

    public AdderThread8(ArrayList<Integer> list, ReentrantLock lock) {
        this.list = list;
        this.lock = lock;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            lock.lock();
            try {
                list.add(random.nextInt(100));
            } finally {
                lock.unlock();
            }
        }
    }
}

class RemoverThread8 extends Thread {
    private ArrayList<Integer> list;
    private ReentrantLock lock;
    private Random random;

    public RemoverThread8(ArrayList<Integer> list, ReentrantLock lock) {
        this.list = list;
        this.lock = lock;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            lock.lock();
            try {
                if (!list.isEmpty()) {
                    int index = random.nextInt(list.size());
                    list.remove(index);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

public class EightTask {
    public static void eight() {
        ArrayList<Integer> list = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();

        AdderThread8 adderThread = new AdderThread8(list, lock);
        RemoverThread8 removerThread = new RemoverThread8(list, lock);

        adderThread.start();
        removerThread.start();

        try {
            adderThread.join();
            removerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final list size: " + list.size());
    }
}