package org.example.n2exercise1.interfaces;

import org.example.n2exercise1.Country;
import org.example.n2exercise1.InvalidFormatException;

public interface PhoneDetails {
    void setPhoneNumber(String areaCode, String phoneNumber) throws InvalidFormatException;
    String getPhoneNumber();
    void setCountry(Country country);
    Country getCountry();
}
