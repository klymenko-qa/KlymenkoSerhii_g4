package model;

public class AccountBuilder {

    private String gender;
    private String firstCustomerName;
    private String lastCustomerName;
    private String password;
    private String email;
    private String day;
    private String month;
    private String year;
    private String fistName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postCode;
    private String country;
    private String phoneNumber;
    private String alias;

    public AccountBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public AccountBuilder withFirstCustomerName(String firstCustomerName) {
        this.firstCustomerName = firstCustomerName;
        return this;
    }

    public AccountBuilder withLastCustomerName(String lastCustomerName) {
        this.lastCustomerName = lastCustomerName;
        return this;
    }

    public AccountBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public AccountBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public AccountBuilder withBirthday(String day) {
        this.day = day;
        return this;
    }

    public AccountBuilder withMonth(String month) {
        this.month = month;
        return this;
    }

    public AccountBuilder withYear(String year) {
        this.year = year;
        return this;
    }

    public AccountBuilder withFirstName(String firstName) {
        this.fistName = firstName;
        return this;
    }

    public AccountBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AccountBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    public AccountBuilder withAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public AccountBuilder withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public AccountBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AccountBuilder withState(String state) {
        this.state = state;
        return this;
    }

    public AccountBuilder withPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public AccountBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public AccountBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public AccountBuilder withAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public Account build() {
        return new Account(gender,
                firstCustomerName,
                lastCustomerName,
                password,
                email,
                day,
                month,
                year,
                fistName,
                lastName,
                company,
                address1,
                address2,
                city,
                state,
                postCode,
                country,
                phoneNumber,
                alias);
    }
}