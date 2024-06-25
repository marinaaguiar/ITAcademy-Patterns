package org.example.n2exercise1;

import org.example.n2exercise1.interfaces.AddressDetails;
import org.example.n2exercise1.interfaces.ContactDetails;
import org.example.n2exercise1.interfaces.PhoneDetails;
import org.example.n2exercise1.interfaces.Phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookManager implements Phonebook {
    private List<AddressDetails> addresses = new ArrayList<>();
    private List<PhoneDetails> phoneNumbers = new ArrayList<>();

    private ContactDetails contactFactory;

    public PhoneBookManager(ContactDetails contactFactory) {
        this.contactFactory = contactFactory;
        startMenu();
    }

    public void startMenu() {
        int option = 0;
        String message = "";
        do {
            message = "";
            option = Input.readInt("Select an option: \n" +
                    "0. Exit \n" +
                    "1. Create new contact \n" +
                    "2. Show contact \n" +
                    "3. List PhoneBook\n");

            switch (option) {
                case 0:
                    message = "Exiting...";
                    break;
                case 1:
                    message = createANewContact();
                    break;
                case 2:
                    message = showContacts();
                    break;
                case 3:
//                    message = addObject();
                    break;
            }
            System.out.println(message);
        } while (option != 0);
    }

    private String createANewContact() {
        String name = Input.readString("Insert a contact name: ");
        contactFactory.setContactName(name);
        Country country = getCountry();
        String city = Input.readString("Insert a name of a city: ");
        String street = Input.readString("Insert a name of a street: ");
        int number = Input.readInt("Insert the number: ");
        int postalCode = Input.readInt("Insert the postal code: ");
        addAddress(country, city, street, number, postalCode);

        String areaCode = Input.readString("Add the area code: ");
        String phoneNumber = askForPhoneNumber();
        addPhone(country, areaCode, phoneNumber);
        return "New contact created: " +
                "\nName: " + name +
                "\nCountry: " + country.getName() +
                "\nStreet: " + street +
                "\nNumber: " + number +
                "\nPostal Code: " + postalCode +
                "\nPhone Number: " + "(" + areaCode + ")" + " " + phoneNumber + "\n";
    }

    private showContacts() {
        
    }

    private Country getCountry() {
        int countryOption = Input.readInt("Choose available country (1. Spain, 2. Brazil, 3. US): ");
        try {
            return Country.findByValue(countryOption);
        } catch (CountryNotFoundException e) {
            System.out.println(e.getMessage());
            return getCountry();
        }
    }

    private String askForPhoneNumber() {
        String phoneNumber = Input.readString("Add the phone number: ");
        return phoneNumber;
    }

    private Country getPhoneNumber() {
        int countryOption = Input.readInt("Choose available country (1. Spain, 2. Brazil, 3. US): ");
        try {
            return Country.findByValue(countryOption);
        } catch (CountryNotFoundException e) {
            System.out.println(e.getMessage());
            return getCountry();
        }

    }

    @Override
    public AddressDetails addAddress(Country country, String city, String street, int number, int postalCode) {
        AddressDetails address = contactFactory.createAddressDetails(country);
        address.setAddressDetails(city, street, number, postalCode);
        addresses.add(address);
        return address;
    }

    @Override
    public PhoneDetails addPhone(Country country, String areaCode, String phoneNumber) {
        PhoneDetails phone = contactFactory.createPhoneDetails(country);
        try {
            phone.setPhoneNumber(areaCode, phoneNumber);
        } catch (InvalidFormatException e) {
            System.out.println(e.getMessage());
            askForPhoneNumber();
        }
        phoneNumbers.add(phone);
        return phone;
    }

    public void displayEntries() {
        for (AddressDetails address : addresses) {
            System.out.println(address.getAddressDetails());
        }
        for (PhoneDetails phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber.getPhoneNumber());
        }
    }
}
