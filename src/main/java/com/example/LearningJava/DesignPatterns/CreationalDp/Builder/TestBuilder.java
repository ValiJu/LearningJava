package com.example.LearningJava.DesignPatterns.CreationalDp.Builder;

import org.junit.Test;

public class TestBuilder {

    @Test
    public void testBuilder() {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        Pizza pizza = pizzaBuilder.withWeight(200)
                .withCheese()
                .withHam()
                .withSalami()
                .withTomatoes()
                .build();
        System.out.println(pizza);
    }
}
