package org.example.n2exercise1.interfaces;

import org.example.n2exercise1.Country;

public interface Phonebook {
    AddressDetails addAddress(Country country, String city, String street, int number, int postalCode);
    PhoneDetails addPhone(Country country, String areaCode, String phoneNumber);
}
