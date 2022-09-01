package com.example.LearningJava.DesignPatterns.CreationalDp.Builder;

public class PizzaBuilder {
    private Pizza pizza;

    public PizzaBuilder(){
        this.pizza  = new Pizza();
    }
    public PizzaBuilder withWeight(int weight){
        this.pizza.setWeight(weight);
        return this;
    }
    public PizzaBuilder withMushrooms(){
        this.pizza.setMushrooms(true);
        return this;
    }
    public PizzaBuilder withTomatoes(){
        this.pizza.setTomatoes(true);
        return this;
    }
    public PizzaBuilder withCheese(){
        this.pizza.setCheese(true);
        return this;
    }public PizzaBuilder withMozzarella(){
        this.pizza.setMozzarella(true);
        return this;
    }
    public PizzaBuilder withOlives(){
        this.pizza.setOlives(true);
        return this;
    }
    public PizzaBuilder withSalami(){
        this.pizza.setSalami(true);
        return this;
    }
    public PizzaBuilder withHam(){
        this.pizza.setHam(true);
        return this;
    }
    public Pizza build(){
        return this.pizza;
    }




}
