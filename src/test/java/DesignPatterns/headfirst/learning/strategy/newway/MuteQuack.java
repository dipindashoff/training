package DesignPatterns.headfirst.learning.strategy.newway;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Mute quack!");
    }
}
