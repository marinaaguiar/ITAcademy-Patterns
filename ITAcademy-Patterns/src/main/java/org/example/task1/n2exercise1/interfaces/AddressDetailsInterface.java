package org.example.task1.n2exercise1.interfaces;

import org.example.task1.n2exercise1.Country;

public interface AddressDetailsInterface {
    void setAddressDetails(String city, String street, int number, String postalCode);
    String getAddressDetails();
    void setCountry(Country country);
    Country getCountry();
}
