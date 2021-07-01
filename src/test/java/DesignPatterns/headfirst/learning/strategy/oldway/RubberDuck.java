package DesignPatterns.headfirst.learning.strategy.oldway;

public class RubberDuck extends Duck implements Quackable {

    @Override
    public void quack(){
        System.out.println("RubberDuck squeaks");
    }

    @Override
    public void display() {
        System.out.println("This is a Rubber Duck");
    }

     /*
    Rubber ducks don't fly
     */
//    @Override
//    public void fly(){
//
//    }
}
