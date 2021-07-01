package DesignPatterns.vinsguru.strategy;

public class NetBanking implements PaymentBehavior{

    @Override
    public void enterPaymentDetails() {
        System.out.println("Net banking information supplied");
    }
}
