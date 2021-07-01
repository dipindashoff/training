package DesignPatterns.headfirst.learning.strategy.oldway;

public class DecoyDuck extends Duck {
    @Override
    public void display() {
        System.out.println("This is a wooden decoy duck");
    }

    /*
    Decoy ducks cannot fly nor quack
     */
}
