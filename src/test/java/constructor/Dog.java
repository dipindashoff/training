package constructor;

public class Dog extends Animal {

    String color;

    public Dog(String name) {
        // super() is inserted by compiler
        this.name = name;
        System.out.println(name);
    }

    public Dog() {
        // Every constructor has, as its first statement as either this() or super()
        // So super() is NOT inserted by compiler here
        // You cannot make a call to an instance method or access an instance variable
        // until after the super constructor runs
        // You cannot make a call to an instance method or access an instance variable
        // until after the super constructor runs

//        this(color); //CANNOT reference 'Dog.color' before supertype constructor has been called
//        this(getColor()); //CANNOT reference 'Dog.getColor' before supertype constructor has been called

        // Only static variables and methods can be accessed as part of the call to super() or this()
//        this(Animal.breed); //ALLOWED

//        this("Rocky Bow Wow"); // hardcoded value OR
        this(getNameStatic()); // calling a static method
        System.out.println("Name: " + this.name);
        System.out.println("Inside Dog no-args constructor");
    }

    public static String getNameStatic() {
        return "Rocky";
    }

    public String getColorInstance() {
        return "Rocky";
    }

}
