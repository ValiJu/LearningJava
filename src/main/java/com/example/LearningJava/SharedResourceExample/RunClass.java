package com.example.LearningJava.SharedResourceExample;

public class RunClass {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource  = new SharedResource();

        ThreadThreeThread t3 = new ThreadThreeThread(sharedResource);
        //t3.setResource(sharedResource);
        ThreadFourThread t4 = new ThreadFourThread(sharedResource);
       // t4.setResource(sharedResource);
        t3.setName("thread3");
        t4.setName("thread4");
        t3.start();
        t4.start();





    }

}
