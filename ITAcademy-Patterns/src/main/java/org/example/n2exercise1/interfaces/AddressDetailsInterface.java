package org.example.n2exercise1.interfaces;

import org.example.n2exercise1.Country;
import org.example.n2exercise1.InvalidFormatException;

public interface AddressDetailsInterface {
    void setAddressDetails(String city, String street, int number, String postalCode);
    String getAddressDetails();
    void setCountry(Country country);
    Country getCountry();
}
