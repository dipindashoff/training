package DesignPatterns.headfirst.practise.strategy;

public class RubberDuck extends Duck {
    public RubberDuck(){
        this.flyBehavior = new FlyNoWings();
        this.quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("This is a rubber duck");
    }

}
