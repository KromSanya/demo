package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class ThreadWorker extends Thread {
    private List<Integer> list;
    private Random random;
    private boolean isAdder;

    public ThreadWorker(List<Integer> list, boolean isAdder) {
        this.list = list;
        this.random = new Random();
        this.isAdder = isAdder;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if (isAdder) {
                list.add(random.nextInt(100));
            } else {
                if (!list.isEmpty()) {
                    int index = random.nextInt(list.size());
                    list.remove(index);
                }
            }
        }
    }
}

public class SixthTask {
    public static void sixth() throws InterruptedException {
        List<Integer> list = (List<Integer>) Collections.synchronizedList(new ArrayList<Integer>());

        ThreadWorker adder = new ThreadWorker(list, true);
        ThreadWorker remover = new ThreadWorker(list, false);

        adder.start();
        remover.start();

        adder.join();
        remover.join();

        System.out.println("Final list size: " + list.size());
    }
}