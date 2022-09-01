package com.example.LearningJava.PizzaShop.PizzaDecorator;

import com.example.LearningJava.PizzaShop.PizzaTypes.Pizza;

import static com.example.LearningJava.PizzaShop.Util.Constants.MUSHROOM;


public class Mushroom extends PizzaDecorator implements Topping{
    public Mushroom(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getTopping() {
        return super.getTopping()+ MUSHROOM;
    }
}
