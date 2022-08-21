package com.example.LearningJava.DesignPatterns.CreationalDp.Singleton;

public class Singularity {
    private static Singularity singularity = new Singularity();

    private Singularity(){

    }

    public static Singularity getSingularity(){
      return singularity;
    }

}
