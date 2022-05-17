package com.example.lab5.users;

import java.util.HashSet;

public abstract class User {

    HashSet books = new HashSet<>();
    final String name;
    final String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public HashSet getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
