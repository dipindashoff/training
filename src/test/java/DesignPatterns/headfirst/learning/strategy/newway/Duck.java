package DesignPatterns.headfirst.learning.strategy.newway;

public abstract class Duck {

    FlyableBehavior flyableBehavior;
    QuackBehavior quackBehavior;

    public void swim() {
        System.out.println("Swims");
    }

    public abstract void display();

    public void performFly(){
        this.flyableBehavior.fly();
    }

    public void performQuack(){
        this.quackBehavior.quack();
    }

    public FlyableBehavior getFlyableBehavior() {
        return flyableBehavior;
    }

    public void setFlyableBehavior(FlyableBehavior flyableBehavior) {
        this.flyableBehavior = flyableBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

}
