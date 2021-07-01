package enumerations;

// BIG is 8 ounces, HUGE is 10 ounces, and OVERWHELMING is a whopping 16 ounces
enum CoffeeSizes {
    /*
    enum constructor is invoked automatically, with the arguments you define after the constant value.
    For example,
    BIG(8) invokes the CoffeeSize constructor that takes an int, passing the int literal 8 to the constructor.
    You can NEVER invoke an enum constructor directly.
     */
    BIG(8), HUGE(10), OVERWHELMING(16);

    // instance variable
    private int ounces;

    // Constructor
    CoffeeSizes(int ounces) {
        this.ounces = ounces;
    }

    // Get ounces
    public int getOunces() {
        return ounces;
    }
}

class Coffee1 {
    CoffeeSizes size;
}


public class CoffeeTest2 {

    public static void main(String[] args) {
        Coffee1 coffee1 = new Coffee1();
        coffee1.size = CoffeeSizes.BIG;
        // Calling getOunces()
        System.out.println(coffee1.size.getOunces());

        for (CoffeeSizes size : CoffeeSizes.values())
            System.out.println(size + " " + size.getOunces());
    }

}
