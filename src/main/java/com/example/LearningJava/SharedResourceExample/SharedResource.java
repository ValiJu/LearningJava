package com.example.microservice_two;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class SharedResource {
    Lock lock = new ReentrantLock();
    Lock lock1 = new ReentrantLock();
   private int resource =0;

    public void increment() {
        System.out.println(Thread.currentThread().getName());
        lock.lock();
        try {
            Thread.sleep(50);
        }catch (Exception e){
            System.out.println(e);
        }
        lock1.lock();
        resource++;
        lock1.unlock();
        lock.unlock();
    }

    public void decrement() {
        System.out.println(Thread.currentThread().getName());
        lock.lock();
        try {
            Thread.sleep(50);
        }catch (Exception e){
            System.out.println(e);
        }
        lock1.lock();
        resource--;
        lock.unlock();
        lock1.unlock();
    }
}
