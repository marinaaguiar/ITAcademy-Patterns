package org.example.task1.n2exercise1.interfaces;

import org.example.task1.n2exercise1.Country;

public interface ContactDetailsInterface {
    void setContactName(String name);
    AddressDetailsInterface createAddressDetails(Country country);
    PhoneDetailsInterface createPhoneDetails(Country country);
}
