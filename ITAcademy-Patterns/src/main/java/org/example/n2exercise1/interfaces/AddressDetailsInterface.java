package org.example.n2exercise1.interfaces;

import org.example.n2exercise1.Country;

public interface AddressDetailsInterface {
    void setAddressDetails(String city, String street, int number, int postalCode);
    String getAddressDetails();
    void setCountry(Country country);
    Country getCountry();
}
