package com.example.LearningJava.DesignPatterns.CreationalDp.Prototype;

import org.junit.Test;

public class TestPrototype {
  @Test
  public void testPrototype(){
    Embrion theOne = new Embrion();
    theOne.setDays(10);
    theOne.setName("theOne");

    Embrion copy = theOne.clone();
    System.out.println(theOne.equals(copy)); //true
    System.out.println(theOne == copy); //false
  }

}
