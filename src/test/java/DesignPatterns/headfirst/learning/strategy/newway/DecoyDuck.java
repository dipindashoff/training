package DesignPatterns.headfirst.learning.strategy.newway;

public class DecoyDuck extends Duck {

    public DecoyDuck() {
        flyableBehavior = new NoFly();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("This is a wooden decoy duck");
    }

    /*
    Decoy ducks cannot fly nor quack
     */
}
