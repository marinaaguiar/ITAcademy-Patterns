package org.example.task1.n2exercise1.details;

import org.example.task1.n2exercise1.Country;
import org.example.task1.n2exercise1.interfaces.ContactDetailsInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactDetails implements ContactDetailsInterface {
    private List<AddressDetails> addresses = new ArrayList<>();
    private List<PhoneDetails> phoneNumbers = new ArrayList<>();
    private String contactID;
    private String name;

    public ContactDetails() {
        contactID = UUID.randomUUID().toString();
    }

    @Override
    public void setContactName(String name) {
        this.name = name;
    }

    @Override
    public AddressDetails createAddressDetails(Country country) {
        AddressDetails address = new AddressDetails();
        address.setCountry(country);
        return address;
    }

    @Override
    public PhoneDetails createPhoneDetails(Country country) {
        PhoneDetails phoneNumber = new PhoneDetails();
        phoneNumber.setCountry(country);
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public List<AddressDetails> getAddresses() {
        return addresses;
    }

    public List<PhoneDetails> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contact:" +
                "\nName: ").append(name);
        sb.append("\nAddresses: \n");
        for (AddressDetails address : addresses) {
            sb.append(address.getAddressDetails()).append(", ");
        }
        if (!addresses.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(", ");
        sb.append("\nPhone Numbers: ");
        for (PhoneDetails phone : phoneNumbers) {
            sb.append(phone.getPhoneNumber()).append(", ");
        }
        if (!phoneNumbers.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
