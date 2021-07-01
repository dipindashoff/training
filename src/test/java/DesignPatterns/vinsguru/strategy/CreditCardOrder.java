package DesignPatterns.vinsguru.strategy;

public class CreditCardOrder extends Order {

    public CreditCardOrder(){
        super();
    }

    public CreditCardOrder(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        this.paymentBehavior = new CreditCard();
    }
}
