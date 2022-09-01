package com.example.LearningJava.PizzaShop.PizzaDecorator;

import com.example.LearningJava.PizzaShop.PizzaTypes.Pizza;

import java.util.Objects;

public class ToppingFactory {
    private ToppingFactory toppingFactory;

    public ToppingFactory(){

    }
    public ToppingFactory getInstance(){
        return Objects.requireNonNullElseGet(toppingFactory,ToppingFactory::new);
    }

    public Topping getTopping(String topping, Pizza pizza){
        if(ToppingType.MUSHROOM.toString().equals(topping)){
            return new Mushroom(pizza);
        }else if(ToppingType.ONION.toString().equals(topping)){
            return new Onion(pizza);
        }
        return null;
    }
}
