package com.example.microservice_two;

import lombok.Data;
@Data
public class ThreadTwoRunnable implements Runnable{

    private SharedResource resource;
    @Override
    public void run() {

        System.out.println(resource.hashCode());
        resource.decrement();
    }
}
