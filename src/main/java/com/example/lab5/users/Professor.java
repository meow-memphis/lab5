package com.example.lab5.users;

import java.util.HashSet;

public class Professor extends User {

    final String middlename;

    public Professor(String name, String middlename, String surname) {
        super(name, surname);
        this.middlename = middlename;
    }

    public String getMiddlename() {
        return middlename;
    }
}
