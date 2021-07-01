package DesignPatterns.headfirst.learning.strategy.newway;

public class NoFly implements FlyableBehavior{
    @Override
    public void fly() {
        System.out.println("I do not fly!");
    }
}
