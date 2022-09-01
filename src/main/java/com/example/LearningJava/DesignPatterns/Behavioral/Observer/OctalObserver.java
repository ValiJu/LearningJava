package com.example.LearningJava.DesignPatterns.Behavioral.Observer;

public class OctalObserver implements Observer{
    private Subject subject;

    public OctalObserver(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println(Integer.toOctalString(subject.getState()));
    }
}
