package org.example.n2exercise1.interfaces;

import org.example.n2exercise1.Country;

public interface ContactDetails {
    void setContactName(String name);
    AddressDetails createAddressDetails(Country country);
    PhoneDetails createPhoneDetails(Country country);
}
