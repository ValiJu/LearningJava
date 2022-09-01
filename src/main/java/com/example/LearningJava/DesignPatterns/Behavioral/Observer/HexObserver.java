package com.example.LearningJava.DesignPatterns.Behavioral.Observer;

public class HexObserver implements Observer{
    private Subject subject;

    public HexObserver(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println(Integer.toHexString(subject.getState()));
    }
}
