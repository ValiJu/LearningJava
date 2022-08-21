package com.example.LearningJava.DesignPatterns.CreationalDp.Singleton;

public class Singletonus {

  private static Singletonus instance;

  private Singletonus() {

  }

  public static Singletonus getInstance() {
    if (instance == null) {
      instance = new Singletonus();
    }
    return instance;
  }

}
