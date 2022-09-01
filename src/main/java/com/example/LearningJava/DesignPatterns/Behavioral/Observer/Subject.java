package com.example.LearningJava.DesignPatterns.Behavioral.Observer;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    @Getter
    private int state;
    private List<Observer> observes = new ArrayList();
    public Subject(int state){
        this.state = state;
    }

    public void attach(Observer observer){
        if(!observes.contains(observer)){
            observes.add(observer);
        }
    }
    public void changeState(int state){
        this.state = state;
        notifyObservers();
    }

    public void notifyObservers(){
        for (Observer observer : observes) {
            observer.update();
        }
    }

}
