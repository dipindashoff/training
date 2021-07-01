package DesignPatterns.vinsguru.strategy;

import org.apache.commons.lang3.RandomStringUtils;

public class Order {

    protected UserInfo userInfo;
    protected PaymentBehavior paymentBehavior;
    private String orderID;

    public Order(){
        this.userInfo = new UserInfo();
    }

    public Order(String firstName, String lastName, String email) {
        this.userInfo = new UserInfo(firstName, lastName, email);
    }

    public void enterUserDetails() {
        this.userInfo.enterUserInfo();
    }

    public void addToCart(){
        System.out.println("Shopping item(s) added to cart");
    }

    public void pay() {
        paymentBehavior.enterPaymentDetails();
    }

    public void placeOrder() {
        System.out.println("Order is placed");
    }

    public String getOrderID() {
        orderID = RandomStringUtils.random(10, false, true);
        return orderID;
    }

    public PaymentBehavior getPaymentBehavior() {
        return paymentBehavior;
    }

    public void setPaymentBehavior(PaymentBehavior paymentBehavior) {
        this.paymentBehavior = paymentBehavior;
    }


}
