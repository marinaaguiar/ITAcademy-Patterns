package org.example.n2exercise1;

public class PaypalPayment implements PaymentMethod {
    private String email;

    public PaypalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing Paypal payment of $" + amount);
    }
}
