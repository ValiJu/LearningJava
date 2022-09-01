package com.example.LearningJava.PizzaShop.PizzaTypes;

public class Diavola implements Pizza {
    private final PizzaType pizzaType = PizzaType.DIAVOLA;
    public String toppings;

    public Diavola() {
        this.toppings = "";
    }

    @Override
    public String getPizzaType() {
        return pizzaType.toString();
    }

    @Override
    public String getTopping() {
        return toppings;
    }
}
