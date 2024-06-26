package org.example.task1.n2exercise1;

public class CountryNotFoundException extends Exception {
    public CountryNotFoundException(int value) {
        super("Country with value " + value + " does not exist.");
    }
}
