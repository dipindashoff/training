package DesignPatterns.headfirst.learning.strategy.oldway;

public class RedHeadDuck extends Duck implements Flyable, Quackable {

    @Override
    public void display() {
        System.out.println("This is a Redhead Duck");
    }

    @Override
    public void fly() {
        System.out.println("Redhead Flies");
    }

    @Override
    public void quack() {
        System.out.println("Redhead Quacks");
    }
}
