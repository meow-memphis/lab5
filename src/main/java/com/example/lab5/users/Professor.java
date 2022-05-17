package com.example.lab5.users;

import java.util.HashSet;

public class Professor extends User {

    final String middlename;

    public Professor(HashSet books, String name, String surname, String middlename) {
        super(name, surname);
        this.middlename = middlename;
    }
}
