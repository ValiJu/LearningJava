package com.example.LearningJava.DesignPatterns.StructuralDp.Adapter;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class AdapterTest {

  @Test
  public void adapterTest() {

    RoundHole gloryHole = new RoundHole(10);

    RoundPeg littleDick = new RoundPeg(9);

    if (gloryHole.fits(littleDick)) {
      log.info("It's little, of course it fits");
    }

    SquarePeg brokenDick = new SquarePeg(5);

    SquarePegAdapter adaptedBrokenDick = new SquarePegAdapter(brokenDick);

    if (gloryHole.fits(adaptedBrokenDick)) {
      log.info("It's little and broken, of course it fits");
    }


  }

}
