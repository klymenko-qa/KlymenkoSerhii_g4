package model;

public class Account {

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

    public Account(String gender, String firstCustomerName,
                   String lastCustomerName, String password,
                   String email, String day, String month,
                   String year, String fistName, String lastName,
                   String company, String address1, String address2,
                   String city, String state, String postCode,
                   String country, String phoneNumber, String alias) {
        this.gender = gender;
        this.firstCustomerName = firstCustomerName;
        this.lastCustomerName = lastCustomerName;
        this.password = password;
        this.email = email;
        this.day = day;
        this.month = month;
        this.year = year;
        this.fistName = fistName;
        this.lastName = lastName;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.alias = alias;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstCustomerName() {
        return firstCustomerName;
    }

    public void setFirstCustomerName(String firstCustomerName) {
        this.firstCustomerName = firstCustomerName;
    }

    public String getLastCustomerName() {
        return lastCustomerName;
    }

    public void setLastCustomerName(String lastCustomerName) {
        this.lastCustomerName = lastCustomerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}