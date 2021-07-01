package DesignPatterns.headfirst.learning.strategy.newway;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck duck1 = new MallardDuck();
        duck1.display();
        duck1.performFly();
        duck1.performQuack();

        // change quack behavior
        duck1.setQuackBehavior(new Squeak());
        duck1.getQuackBehavior();
        duck1.performQuack();
    }
}
