package com.example.lab5.books;

public abstract class Book {

    final String name;
    final String author;

    protected Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }


}
