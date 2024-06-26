package org.example.task1.n2exercise1;

import org.example.task1.n2exercise1.details.AddressDetails;
import org.example.task1.n2exercise1.details.PhoneDetails;

import java.util.List;

public class CompleteContact {
    private String name;
    private List<AddressDetails> addresses;
    private List<PhoneDetails> phoneNumbers;

    public CompleteContact(String name, List<AddressDetails> addresses, List<PhoneDetails> phoneNumbers) {
        this.name = name;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
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
