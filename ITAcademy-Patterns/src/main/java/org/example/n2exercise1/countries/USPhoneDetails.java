package org.example.n2exercise1.countries;

import org.example.n2exercise1.Country;
import org.example.n2exercise1.InvalidFormatException;
import org.example.n2exercise1.interfaces.PhoneDetails;

public class USPhoneDetails implements PhoneDetails {
    private String areaCode;
    private String phoneNumber;
    private Country country;

    @Override
    public void setPhoneNumber(String areaCode, String phoneNumber) throws InvalidFormatException {
        if (country != null && !country.isPhoneNumberFormatCorrect("(" + areaCode + ")" + " " + phoneNumber)) {
            throw new InvalidFormatException(phoneNumber, country.getName());
        }
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPhoneNumber() {
        return "(" + areaCode + ") " + phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(4);
    }

    @Override
    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public Country getCountry() {
        return this.country;
    }
}

