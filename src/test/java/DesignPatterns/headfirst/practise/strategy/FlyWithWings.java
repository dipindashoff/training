package DesignPatterns.headfirst.practise.strategy;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Fly high");
    }
}
