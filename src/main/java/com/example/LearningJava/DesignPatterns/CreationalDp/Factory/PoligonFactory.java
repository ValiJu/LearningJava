package com.example.LearningJava.DesignPatterns.CreationalDp.Factory;

public class PoligonFactory {
   public Poligon getPoligon(int numberOfSides){
     if(numberOfSides == 3)
       return new Triangle();
     else if(numberOfSides == 4)
       return new Square();
     else return null;
   }
}
