package DesignPatterns.vinsguru.strategy;

public class CreditCard implements PaymentBehavior{
    @Override
    public void enterPaymentDetails() {
        System.out.println("Credit Card information supplied");
    }
}
