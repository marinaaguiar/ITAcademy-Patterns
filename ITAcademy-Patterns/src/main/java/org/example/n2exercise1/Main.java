package org.example.n2exercise1;

import org.example.n2exercise1.countries.USContactDetails;

public class Main {
    public static void main(String[] args) {
        PhoneBookManager usAddressBook = new PhoneBookManager(new USContactDetails());
        usAddressBook.displayEntries();
    }
}
