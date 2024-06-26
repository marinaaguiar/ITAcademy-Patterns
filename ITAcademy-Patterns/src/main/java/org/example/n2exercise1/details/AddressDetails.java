package org.example.n2exercise1.details;

import org.example.n2exercise1.Country;
import org.example.n2exercise1.interfaces.AddressDetailsInterface;

public class AddressDetails implements AddressDetailsInterface {
    private String city;
    private String street;
    private int number;
    private String postalCode;
    private Country country;

    @Override
    public void setAddressDetails(String city, String street, int number, String postalCode) {
        this.city = city;
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
    }

    @Override
    public String getAddressDetails() {
        return number + " " + street + ", " + city + ", " + postalCode + ", " + country.getName();
    }

    @Override
    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public Country getCountry() {
        return this.country;
    }

    @Override
    public String toString() {
        return getAddressDetails();
    }
}

