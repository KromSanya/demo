package com.example;

public class SecondTask {

    public static void second()
    {
        Thread myThread = new Thread(new MyRunnable());
        myThread.start();
        try {
            myThread.join();
            System.out.println("Поток завершил выполнение.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Поместите здесь код, который вы хотите выполнить в новом потоке
        System.out.println("Новый поток начал выполнение.");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Новый поток завершил выполнение.");
    }
}
