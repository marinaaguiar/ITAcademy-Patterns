package org.example.n2exercise1;

public enum Country {
    ES(1, "Spain", "+34", "\\(\\d{2}\\) \\d{3} \\d{2} \\d{2}"),
    BR(2, "Brazil", "+55", "\\(\\d{2}\\) \\d{5}-\\d{4}"),
    US(3, "US", "+1", "\\(\\d{3}\\) \\d{3}-\\d{4}");

    private final int value;
    private final String name;
    private final String areaCode;
    private final String phoneNumberFormat;
    private final String phoneNumber;

    Country(int value, String name, String areaCode, String phoneNumberFormat) {
        this.value = value;
        this.name = name;
        this.areaCode = areaCode;
        this.phoneNumberFormat = phoneNumberFormat;
        this.phoneNumber = phoneNumberFormat;
    }

    public String getName() {
        return name;
    }

    public int getValue() { return value; }

    public String getAreaCode() {
        return areaCode;
    }

    public String getPhoneNumberFormat() {
        return phoneNumberFormat;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isPhoneNumberFormatCorrect(String phoneNumber) {
        return phoneNumber.matches(phoneNumberFormat);
    }

    public static Country findByValue(int value) throws CountryNotFoundException {
        for (Country country : Country.values()) {
            if (country.getValue() == value) {
                return country;
            }
        }
        throw new CountryNotFoundException(value);
    }
}
