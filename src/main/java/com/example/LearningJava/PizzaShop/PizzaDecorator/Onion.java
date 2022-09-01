package com.example.LearningJava.PizzaShop.PizzaDecorator;

import com.example.LearningJava.PizzaShop.PizzaTypes.Pizza;

import static com.example.LearningJava.PizzaShop.Util.Constants.ONION;

public class Onion extends PizzaDecorator implements Topping{


    public Onion(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getTopping() {
        return super.getTopping()+ ONION;
    }
}
