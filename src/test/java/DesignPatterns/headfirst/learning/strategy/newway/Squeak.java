package DesignPatterns.headfirst.learning.strategy.newway;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("I squeak!");
    }
}
