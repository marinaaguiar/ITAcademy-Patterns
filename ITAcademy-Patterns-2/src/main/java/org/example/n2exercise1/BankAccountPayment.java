package org.example.n2exercise1;

public class BankAccountPayment implements PaymentMethod {
    private String accountNumber;
    private String bankName;

    public BankAccountPayment(String accountNumber, String bankName) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing bank account debit payment of $" + amount);
    }
}
