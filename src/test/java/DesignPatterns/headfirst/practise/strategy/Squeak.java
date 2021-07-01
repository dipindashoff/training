package DesignPatterns.headfirst.practise.strategy;

public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("SQUEAK! SQUEAK!");
    }
}
