package org.example.task1.n2exercise1.details;

import org.example.task1.n2exercise1.Country;
import org.example.task1.n2exercise1.interfaces.PhoneDetailsInterface;

public class PhoneDetails implements PhoneDetailsInterface {
    private String areaCode;
    private String phoneNumber;
    private Country country;

    @Override
    public void setPhoneNumber(String areaCode, String phoneNumber) {
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPhoneNumber() {
        return country.getCountryCode() + " (" + areaCode + ") " + phoneNumber;
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
        return getPhoneNumber();
    }
}

