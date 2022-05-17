package com.example.lab5.books.eng;

import com.example.lab5.books.Book;

public abstract class Eng extends Book {

    final String lang = "ENG";

    public Eng(String name, String author) {
        super(name, author);
    }

    public String getLang() {
        return lang;
    }

}
