package com.example.microservice_two;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ThreadThreeThread extends Thread {

    private final SharedResource resource;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            resource.increment();
            System.out.println(Thread.currentThread().getName());
        }

    }
}
