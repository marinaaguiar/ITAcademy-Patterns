package org.example.n2exercise1;

public class ShoeStore {
    private PaymentGateway paymentGateway;

    public ShoeStore() {
        this.paymentGateway = new PaymentGateway();
    }

    public void checkout(double amount, PaymentMethod paymentMethod) {
        paymentGateway.processPayment(paymentMethod, amount);
    }

    public void startMenu() {
        System.out.println("Welcome to the Shoe Store!");
        double amount = Input.readDouble("Enter the amount to be paid: ");

        int paymentOption = Input.readInt("Choose the available payment method (1. Credit Card, 2. Paypal, 3. Back Account Debit): ");
        PaymentMethod paymentMethod = null;

        switch (paymentOption) {
            case 1:
                String cardNumber = Input.readString("Enter card number: ");
                String cardHolder = Input.readString("Enter card holder name: ");
                String expirationDate = Input.readString("Enter expiration date (MM/YY): ");
                String cvv = Input.readString("Enter CVV: ");
                paymentMethod = new CreditCardPayment(cardNumber, cardHolder, expirationDate, cvv);
                break;
            case 2:
                String email = Input.readString("Enter PayPal email: ");
                paymentMethod = new PaypalPayment(email);
                break;
            case 3:
                String accountNumber = Input.readString("Enter bank account number: ");
                String bankName = Input.readString("Enter bank name: ");
                paymentMethod = new BankAccountPayment(accountNumber, bankName);
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                startMenu();
        }
        checkout(amount, paymentMethod);
    }
}
