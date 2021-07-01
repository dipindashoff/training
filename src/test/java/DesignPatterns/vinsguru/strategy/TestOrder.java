package DesignPatterns.vinsguru.strategy;

public class TestOrder {

    public static void main(String[] args) {

        /* Credit Card */
//        // Create Order object
//        Order ccOrder = new Order("Doja", "Cat", "dojacatcandy@gmail.com", new CreditCard());
//        // Enter payment info
//        ccOrder.pay();
//        // Place Order
//        ccOrder.placeOrder();
//        // Get order ID
//        System.out.println(ccOrder.getOrderID());

        String orderID;

        /* Credit card order */
        Order creditCardOrder = new CreditCardOrder("Doja", "Cat", "dojacatcandy@gmail.com");
        creditCardOrder.enterUserDetails();
        creditCardOrder.addToCart();
        creditCardOrder.pay();
        creditCardOrder.placeOrder();
        orderID = creditCardOrder.getOrderID();
        System.out.println("Order#: " + orderID + " for "+ creditCardOrder.userInfo.getFirstName() +"\n");

        /* Change payment from Credit Card to Net Banking */
        creditCardOrder.setPaymentBehavior(new NetBanking());
        creditCardOrder.addToCart();
        creditCardOrder.pay();
        creditCardOrder.placeOrder();
        orderID = creditCardOrder.getOrderID();
        System.out.println("Order#: " + orderID + " for "+ creditCardOrder.userInfo.getFirstName() +"\n");

        /* Google Pay order with default user names */
        Order googlePayOrder = new GooglePayOrder();
        googlePayOrder.enterUserDetails();
        googlePayOrder.addToCart();
        googlePayOrder.pay();
        googlePayOrder.placeOrder();
        orderID = googlePayOrder.getOrderID();
        System.out.println("Order#: " + orderID + " for "+ googlePayOrder.userInfo.getFirstName() +"\n");
    }

}
