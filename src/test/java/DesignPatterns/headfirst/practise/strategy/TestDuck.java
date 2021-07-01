package DesignPatterns.headfirst.practise.strategy;

public class TestDuck {

    public static void main(String[] args) {
        Duck duck1 = new MallardDuck();
        duck1.display();
//        duck1.quack();
//        duck1.fly();
        duck1.performFly();
        duck1.performQuack();

        Duck duck2 = new RubberDuck();
        duck2.display();
//        duck2.quack();
//        duck2.fly();
        duck2.performFly();
        duck2.performQuack();

        Duck duck3 = new DecoyDuck();
        duck3.display();
//        duck3.quack();
//        duck3.fly();
        duck3.performFly();
        duck3.performQuack();
    }
}
