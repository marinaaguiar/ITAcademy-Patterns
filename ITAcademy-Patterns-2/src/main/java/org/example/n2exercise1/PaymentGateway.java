package org.example.n2exercise1;

public class PaymentGateway {
    public void processPayment(PaymentMethod paymentMethod, double amount) {
        paymentMethod.pay(amount);
    }
}
