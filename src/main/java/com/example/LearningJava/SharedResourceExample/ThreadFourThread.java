package com.example.microservice_two;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ThreadFourThread extends Thread{
    private final SharedResource resource;

    public void run() {
            for (int i = 0; i < 100; i++) {
                resource.decrement();
                System.out.println(Thread.currentThread().getName());
            }
    }
}
