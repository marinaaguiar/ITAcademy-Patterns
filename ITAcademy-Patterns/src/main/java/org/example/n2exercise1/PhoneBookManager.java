package org.example.n2exercise1;

import org.example.n2exercise1.details.AddressDetails;
import org.example.n2exercise1.details.ContactDetails;
import org.example.n2exercise1.details.PhoneDetails;
import org.example.n2exercise1.interfaces.PhonebookInterface;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookManager implements PhonebookInterface {
    private List<CompleteContact> contacts = new ArrayList<>();

    private ContactDetails contactFactory;
    String areaCode;
    String phoneNumber;

    public PhoneBookManager(ContactDetails contactFactory) {
        this.contactFactory = contactFactory;
        startMenu();
    }

    public void startMenu() {
        int option = 0;
        String message = "";
        do {
            message = "";
            option = Input.readInt("Phone Book Manager \n" +
                    "0. Exit \n" +
                    "1. Create new contact \n" +
                    "2. List PhoneBook\n" +
                    "3. Search contact by name \n" +
                    "Select an option: "
            );

            switch (option) {
                case 0:
                    message = "Exiting...";
                    break;
                case 1:
                    message = createANewContact();
                    break;
                case 2:
                    message = listPhoneBook();
                    break;
                case 3:
                    message = searchContactByName();
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
        AddressDetails address = addAddress(country, city, street, number, postalCode);
        askForPhoneContact();
        PhoneDetails phone = addPhone(country, areaCode, phoneNumber);

        List<AddressDetails> addresses = new ArrayList<>();
        addresses.add(address);
        List<PhoneDetails> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(phone);

        CompleteContact newContact = new CompleteContact(name, addresses, phoneNumbers);
        contacts.add(newContact);

        return "New contact created: " +
                "\nName: " + name +
                "\nCountry: " + country.getName() +
                "\nStreet: " + street +
                "\nNumber: " + number +
                "\nPostal Code: " + postalCode +
                "\nPhone Number: " + "(" + areaCode + ")" + " " + phoneNumber + "\n";
    }

    private String listPhoneBook() {
        if (contacts.isEmpty()) {
            return "The contact list is empty.";
        }
        for (CompleteContact contact : contacts) {
            System.out.println("Name: " + contact.getName() +
                    "\nAddress: " + contact.getAddresses() +
                    "\nPhone Numbers: " + contact.getPhoneNumbers());
        }
        return "Phone Book Contacts listed.";
    }

    private String searchContactByName() {
        String name = Input.readString("Enter the name of the contact to search: ");
        CompleteContact contact = contacts.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if (contact != null) {
            return "Contact found: " +
                    "\nName: " + contact.getName() +
                    "\nAddresses: " + contact.getAddresses() +
                    "\nPhone Numbers: " + contact.getPhoneNumbers();
        } else {
            return "Contact not found.";
        }
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

    private void askForPhoneContact() {
        String areaCode = Input.readString("Add the area code: ");
        String phoneNumber = Input.readString("Add the phone number: ");
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public AddressDetails addAddress(Country country, String city, String street, int number, int postalCode) {
        AddressDetails address = contactFactory.createAddressDetails(country);
        address.setAddressDetails(city, street, number, postalCode);
        return address;
    }

    @Override
    public PhoneDetails addPhone(Country country, String areaCode, String phoneNumber) {
        PhoneDetails phone = contactFactory.createPhoneDetails(country);
        try {
            phone.setPhoneNumber(areaCode, phoneNumber);
        } catch (InvalidFormatException e) {
            System.out.println(e.getMessage());
            askForPhoneContact();
        }
        return phone;
    }
}
