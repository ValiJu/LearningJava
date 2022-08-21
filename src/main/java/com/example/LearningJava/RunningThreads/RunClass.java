package com.example.LearningJava.RunningThreads;

import com.example.LearningJava.SharedResourceExample.SharedResource;
import com.example.LearningJava.SharedResourceExample.ThreadFourThread;
import com.example.LearningJava.SharedResourceExample.ThreadThreeThread;

public class RunClass {
    public static void main(String[] args) throws InterruptedException {
        RunThreads runThreads = new RunThreads();
        runThreads.start();
    }

}
