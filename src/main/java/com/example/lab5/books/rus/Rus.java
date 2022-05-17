package com.example.lab5.books.rus;

import com.example.lab5.books.Book;

public abstract class Rus extends Book {

    final String lang = "RU";

    public Rus(String name, String author) {
        super(name, author);
    }

    public String getLang() {
        return lang;
    }
}
