package DesignPatterns.headfirst.learning.strategy.newway;

public class FlyHigh implements FlyableBehavior{
    @Override
    public void fly() {
        System.out.println("I fly high!");
    }
}
