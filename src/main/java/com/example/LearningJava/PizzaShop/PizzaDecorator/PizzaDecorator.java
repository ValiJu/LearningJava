package com.example.LearningJava.PizzaShop.PizzaDecorator;

import com.example.LearningJava.PizzaShop.PizzaTypes.Pizza;

public class PizzaDecorator implements Pizza {
    private Pizza pizza;

    public PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getPizzaType() {
        return pizza.getPizzaType().toString();
    }

    public String getTopping(){
        return pizza.getTopping();
    }
}
