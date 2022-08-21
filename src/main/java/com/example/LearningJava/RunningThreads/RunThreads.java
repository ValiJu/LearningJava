package com.example.LearningJava.RunningThreads;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class RunThreads {
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public void start(){
        for(int i=0;i<5;i++){
            Runnable runnable = new MyRunnable("task"+i);
            executorService.execute(runnable);
        }
    }


}
