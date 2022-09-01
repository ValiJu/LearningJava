package com.example.LearningJava.PizzaShop.PizzaTypes;

public class Capriciosa implements Pizza {
    private final PizzaType pizzaType = PizzaType.CAPRICIOSA;
    public String toppings;

    public Capriciosa() {
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
