package DesignPatterns.headfirst.learning.strategy.newway;

public class RubberDuck extends Duck {

    public RubberDuck(){
        flyableBehavior = new FlyHigh();
        quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("I'm a Rubber Duck");
    }

     /*
    Rubber ducks don't fly
     */
//    @Override
//    public void fly(){
//
//    }
}
