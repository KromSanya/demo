package com.example;

import java.util.ArrayList;
import java.util.Random;

public class FifthTask {
    public static void fifth() throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();

        ThreadWorker adder = new ThreadWorker(list, true);
        ThreadWorker remover = new ThreadWorker(list, false);

        adder.start();
        remover.start();

        adder.join();
        remover.join();

        System.out.println("Final list size: " + list.size());
    }
}


class ThreadWorker extends Thread {
    private ArrayList<Integer> list;
    private Random random;
    private boolean isAdder;

    public ThreadWorker(ArrayList<Integer> list, boolean isAdder) {
        this.list = list;
        this.random = new Random();
        this.isAdder = isAdder;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if (isAdder) {
                addElement(random.nextInt(100));
            } else {
                removeElement();
            }
        }
    }

    private synchronized void addElement(int element) {
        list.add(element);
    }

    private synchronized void removeElement() {
        if (!list.isEmpty()) {
            int index = random.nextInt(list.size());
            list.remove(index);
        }
    }
}

