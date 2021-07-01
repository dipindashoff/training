package abstractClass;

public class Horse extends Animal {

    String color = "White";

    @Override
    public void eat() {
        System.out.println("Horse eating hay, oats, and horse treats");
    }

    public void buck() { }

    public static void staticMethod(){
        System.out.println("Horse static method");
    }
}
