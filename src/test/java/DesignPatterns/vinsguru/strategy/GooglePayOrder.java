package DesignPatterns.vinsguru.strategy;

public class GooglePayOrder extends Order {

    public GooglePayOrder() {
        super();
        this.paymentBehavior = new GooglePay();
    }

    public GooglePayOrder(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        this.paymentBehavior = new GooglePay();
    }
}
