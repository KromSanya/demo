package com.example;

import java.util.Arrays;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
  Thread currentThread = Thread.currentThread();
        System.out.println("Current thread properties:");
        System.out.println("Id: " + currentThread.getId());
        System.out.println("Name: " + currentThread.getName());
        System.out.println("Priority: " + currentThread.getPriority());
        System.out.println("State: " + currentThread.getState());
        System.out.println("IsAlive: " + currentThread.isAlive());
        System.out.println("IsDaemon: " + currentThread.isDaemon());
        System.out.println("ThreadGroup: " + currentThread.getThreadGroup());
        System.out.println("ContextClassLoader: " + currentThread.getContextClassLoader());
        System.out.println("StackTrace: " + Arrays.toString(currentThread.getStackTrace()));
        System.out.println("UncaughtExceptionHandler: " + currentThread.getUncaughtExceptionHandler());
        
      //  SecondTask.second();
      //  ThirdTask.third();
      //  FourthTask.fourth();
      //  FifthTask.fifth();
      //  SixthTask.sixth();
      //  PingPong.pingpong();
        EightTask.eight();
    }
        
}
