package com.example;

public class PingPong {
    
    static boolean pingTurn = true;

    public static void pingpong() {

        Thread pingThread = new Thread(() -> {
            while (true) {
                synchronized (PingPong.class) {
                    while (!pingTurn) {
                        try {
                            PingPong.class.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("ping");
                    pingTurn = false;
                    PingPong.class.notifyAll();
                }
            }
        });

        Thread pongThread = new Thread(() -> {
            while (true) {
                synchronized (PingPong.class) {
                    while (pingTurn) {
                        try {
                            PingPong.class.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("pong");
                    pingTurn = true;
                    PingPong.class.notifyAll();
                }
            }
        });

        pingThread.start();
        pongThread.start();
    }
}
