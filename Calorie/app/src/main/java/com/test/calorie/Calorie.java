package com.test.calorie;

public class Calorie {
    private String firstname;
    private String lastname;
    private String phone;
    private String description;

    public Calorie() {
    }

    public Calorie(String firstname, String lastname, String phone, String description) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.description = description;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
