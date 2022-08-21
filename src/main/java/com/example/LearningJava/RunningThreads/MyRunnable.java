package com.example.LearningJava.RunningThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyRunnable implements Runnable{
    private String taskName;
    private static final Lock lock = new ReentrantLock();
    public MyRunnable(String taskName){
        this.taskName = taskName;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("Starting "+taskName+" by thread "+Thread.currentThread().getName());
        try {
            Thread.sleep(50);
            System.out.println("Ending "+taskName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
