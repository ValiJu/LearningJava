package com.example.LearningJava.PizzaShop.PizzaTypes;

public class Marguerita implements Pizza {
    public final PizzaType pizzaType = PizzaType.MARGUERITA;
    public String toppings;

    public Marguerita() {
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
