package enumerations;

// Create an enum fr each coffee size
enum CoffeeSize {
    BIG, HUGE, OVERWHELMING
}

// Enum declared outside CoffeeTest1 class
class Coffee {
    CoffeeSize size;
}

// Enum declared inside CoffeeTest1 class
class Coffee2 {
    enum CoffeeSize {
        SMALL, BIG, EXTRA_LARGE
    }
    CoffeeSize size;
}

public class CoffeeTest1 {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.size = CoffeeSize.BIG;

        Coffee2 coffee2 = new Coffee2();
        coffee2.size = Coffee2.CoffeeSize.SMALL;
    }
}
