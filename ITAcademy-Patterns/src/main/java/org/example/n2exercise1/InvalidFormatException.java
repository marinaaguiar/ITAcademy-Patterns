package org.example.n2exercise1;

public class InvalidFormatException extends Exception {
    public InvalidFormatException(String phoneNumber, String countryName) {
        super("Invalid phone number format: " + phoneNumber + " for country: " + countryName);
    }
}