package com.example.LearningJava.DesignPatterns.Behavioral.Observer;

public class BinaryObserver implements Observer{
    private Subject subject;
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println(Integer.toBinaryString(subject.getState()));
    }
}
