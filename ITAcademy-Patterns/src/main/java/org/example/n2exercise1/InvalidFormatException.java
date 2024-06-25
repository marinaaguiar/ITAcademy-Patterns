package org.example.n2exercise1;

public class InvalidFormatException extends Exception {
    public InvalidFormatException(String areaCode, String phoneNumber, Country country) {
        super("Invalid phone number format: " + " (" +  areaCode + ") " + phoneNumber + " for country: " + country.getName() +
                "\nConsider using this area code format: " + country.getAreaCodeFormat() +
                "\nConsider using this number format: " + country.getPhoneNumberFormat());
    }
}