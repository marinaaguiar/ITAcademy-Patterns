package org.example.n2exercise1;

public class ShoeStore {
    private PaymentGateway paymentGateway;
    PaymentMethod paymentMethod = null;

    public ShoeStore() {
        this.paymentGateway = new PaymentGateway();
    }

    public void checkout(double amount, PaymentMethod paymentMethod) {
        paymentGateway.processPayment(paymentMethod, amount);
    }

    public void startMenu() {
        System.out.println("Welcome to the Shoe Store!");
        double amount = Input.readDouble("Enter the amount to be paid: ");

        int paymentOption = Input.readInt("Choose the available payment method (1. Credit Card, 2. Paypal, 3. Bank Account Debit): ");

        switch (paymentOption) {
            case 1:
                payWithCreditCard();
                break;
            case 2:
                payWithPayPal();
                break;
            case 3:
                payWithDebit();
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                startMenu();
        }
        checkout(amount, paymentMethod);
    }

    private void payWithCreditCard() {
        String cardNumber = Input.readString("Enter card number: ");
        String cardHolder = Input.readString("Enter card holder name: ");
        String expirationDate = Input.readString("Enter expiration date (MM/YY): ");
        String cvv = Input.readString("Enter CVV: ");
        paymentMethod = new CreditCardPayment(cardNumber, cardHolder, expirationDate, cvv);
    }

    private void payWithPayPal() {
        String email = Input.readEmailString("Enter PayPal email: ");
        paymentMethod = new PaypalPayment(email);
    }

    private void payWithDebit() {
        String accountNumber = Input.readString("Enter bank account number: ");
        String bankName = Input.readString("Enter bank name: ");
        paymentMethod = new BankAccountPayment(accountNumber, bankName);
    }
}
