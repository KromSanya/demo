package com.example;

import java.util.ArrayList;
import java.util.Random;

public class FourthTask {

   public static void fourth() throws InterruptedException{
    ArrayList<Integer> list = new ArrayList<>();

    AdderThread adder = new AdderThread(list);
    RemoverThread remover = new RemoverThread(list);

    adder.start(); // start the adder thread
    remover.start(); // start the remover thread

    adder.join();
    remover.join();

    System.out.println("Final list size: " + list.size());
    
   }
}


class AdderThread extends Thread {
    private ArrayList<Integer> list;
    private Random random;

    public AdderThread(ArrayList<Integer> list) {
        this.list = list;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (list) {
                list.add(random.nextInt(100));
            }
        }
    }
}

class RemoverThread extends Thread {
    private ArrayList<Integer> list;
    private Random random;

    public RemoverThread(ArrayList<Integer> list) {
        this.list = list;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (list) {
                if (!list.isEmpty()) {
                    int index = random.nextInt(list.size());
                    list.remove(index);
                }
            }
        }
    }
}