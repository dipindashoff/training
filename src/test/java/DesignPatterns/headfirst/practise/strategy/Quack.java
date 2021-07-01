package DesignPatterns.headfirst.practise.strategy;

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("QUACK! QUACK!");
    }
}
