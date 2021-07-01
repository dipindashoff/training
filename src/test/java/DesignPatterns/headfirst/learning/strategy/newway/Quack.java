package DesignPatterns.headfirst.learning.strategy.newway;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("I qauck!");
    }
}
