package org.example.n2exercise1.countries;

import org.example.n2exercise1.Country;
import org.example.n2exercise1.interfaces.AddressDetails;
import org.example.n2exercise1.interfaces.ContactDetails;
import org.example.n2exercise1.interfaces.PhoneDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class USContactDetails implements ContactDetails {
    private List<AddressDetails> addresses = new ArrayList<>();
    private List<PhoneDetails> phoneNumbers = new ArrayList<>();
    private String contactID;
    private String name;

    public USContactDetails() {
        contactID = UUID.randomUUID().toString();
    }

    @Override
    public void setContactName(String name) {
        this.name = name;
    }

    @Override
    public AddressDetails createAddressDetails(Country country) {
        AddressDetails address = new USAddressDetails();
        address.setCountry(country);
        return address;
    }

    @Override
    public PhoneDetails createPhoneDetails(Country country) {
        PhoneDetails phoneNumber = new USPhoneDetails();
        phoneNumber.setCountry(country);
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getContactID() {
        return contactID;
    }
}
