package org.example.n2exercise1;

public enum Country {
    ES(
            1,
            "Spain",
            "+34",
            "\\d{2}",
            "\\d{3} \\d{2} \\d{2} \\d{2}",
            "\\d{5}"),

    BR(
            2,
            "Brazil",
            "+55",
            "\\d{2}",
            "\\d{5}-\\d{4}",
            "\\d{5}-\\d{3}"),

    US(
            3,
            "US",
            "+1",
            "\\d{3}",
            "\\d{3}-\\d{4}",
            "\\d{5}-\\d{4}"
    );

    private final int value;
    private final String name;
    private final String countryCode;
    private final String areaCodeFormat;
    private final String phoneNumberFormat;
    private final String postalCodeFormat;

    Country(int value, String name, String countryCode, String areaCodeFormat, String phoneNumberFormat, String postalCodeFormat) {
        this.value = value;
        this.name = name;
        this.countryCode = countryCode;
        this.areaCodeFormat = areaCodeFormat;
        this.phoneNumberFormat = phoneNumberFormat;
        this.postalCodeFormat = postalCodeFormat;
    }

    public String getName() {
        return name;
    }

    public int getValue() { return value; }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPhoneNumberFormat() {
        switch (this) {
            case ES:
                return "123 45 67 89";
            case BR:
                return "12345-6789";
            case US:
                return "123-4567";
            default:
                return "No example available";
        }
    }

    public String getAreaCodeFormat() {
        switch (this) {
            case ES:
                return "93";
            case BR:
                return "92";
            case US:
                return "212";
            default:
                return "No example available";
        }
    }

    public String getPostalCodeFormat() {
        switch (this) {
            case ES:
                return "08023";
            case BR:
                return "06812-839";
            case US:
                return "04982-6789";
            default:
                return "No example available";
        }
    }

    public boolean isAreaCodeFormatCorrect(String areaCode) {
        return areaCode.matches(areaCodeFormat);
    }

    public boolean isPhoneNumberFormatCorrect(String phoneNumber) {
        return phoneNumber.matches(phoneNumberFormat);
    }

    public boolean isPostalCodeFormatCorrect(String postalCode) {
        return postalCode.matches(postalCodeFormat);
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
