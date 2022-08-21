package com.example.microservice_two;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
@Data
public class ThreadOneRunnable implements Runnable{

    private SharedResource resource;

    @Override
    public void run() {
        System.out.println(resource.hashCode());
        resource.increment();
    }
}
