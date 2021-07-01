package DesignPatterns.vinsguru.strategy;

public class GooglePay implements PaymentBehavior{
    @Override
    public void enterPaymentDetails() {
        System.out.println("Google Pay information supplied");
    }
}
