package com.example.LearningJava.DesignPatterns.CreationalDp.Singleton;

import org.junit.Test;

public class TestSingleton {

  @Test
  public void testSingleton() {
    Singularity s1 = Singularity.getSingularity();
    Singularity s2 = Singularity.getSingularity();
    System.out.println(s1);
    System.out.println(s2);

    Singletonus s = Singletonus.getInstance();
    Singletonus ss = Singletonus.getInstance();
    System.out.println(s);
    System.out.println(ss);
  }
}
