package abstractClass;

public class TestAnimals {

    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Horse(); // Animal ref, but a Horse object
        a.eat(); // Runs the Animal version of eat()
        b.eat(); // Runs the Horse version of eat()

        Animal c = new Horse();
//        c.buck(); // Can't invoke buck(); Animal class doesn't have that method

        // The ONLY things that are dynamically selected based on the actual object
        // (rather than the reference type) are instance methods NOT static methods or  variables
        System.out.println(a.color); // Brown
        System.out.println(b.color); // Brown

        Horse d = new Horse();
        a.staticMethod(); //Animal static method
        b.staticMethod(); //Animal static method
        d.staticMethod(); //Horse static method
    }
}
