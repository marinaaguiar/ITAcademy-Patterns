package org.example.task1.n2exercise1.interfaces;

import org.example.task1.n2exercise1.Country;
//import org.example.n2exercise1.InvalidFormatException;

public interface PhoneDetailsInterface {
    void setPhoneNumber(String areaCode, String phoneNumber);
    String getPhoneNumber();
    void setCountry(Country country);
    Country getCountry();
}
