package DesignPatterns.vinsguru.strategy;

public class NetBankingOrder extends Order {

    public NetBankingOrder(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        this.paymentBehavior = new NetBanking();
    }
}
