package org.example.task1.n2exercise1.interfaces;

import org.example.task1.n2exercise1.Country;

public interface PhonebookInterface {
    AddressDetailsInterface addAddress(Country country, String city, String street, int number, String postalCode);
    PhoneDetailsInterface addPhone(Country country, String areaCode, String phoneNumber);
}
