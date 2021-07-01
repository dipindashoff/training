package DesignPatterns.headfirst.practise.strategy;

public abstract class Duck {

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    protected abstract void display();

    protected void swim(){
        System.out.println("swimming");
    }

    protected void performFly(){
        flyBehavior.fly();
    }

    protected void performQuack(){
        quackBehavior.quack();
    }

}