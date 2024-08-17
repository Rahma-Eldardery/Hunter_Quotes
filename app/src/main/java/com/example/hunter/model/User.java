package com.example.hunter.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName , lastName ;
    private String email , phone , password, country;
    public static List<User> membersList = new ArrayList<>();

    public User(String firstName, String lastName, String email, String phone, String password, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.country = country;
        membersList.add(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }
}
