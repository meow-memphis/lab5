package com.example.lab5.users.ugen;

import com.example.lab5.books.bgen.BookFactory;
import com.example.lab5.books.bgen.ImpB;
import com.example.lab5.books.classes.Book;
import com.example.lab5.users.classes.Professor;
import com.example.lab5.users.classes.Student;
import com.example.lab5.users.classes.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class UserFactory {

    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void createUsers(ImpU imp, int num, BookFactory bookFactory) {
        for (int i = 0; i < num; i++) {
            users.add(createUser(imp, bookFactory));
        }
    }

    public User createUser(ImpU imp, BookFactory bookFactory) {
        User user;
        if (ThreadLocalRandom.current().nextInt(0, 100) > 80) {
            if (ThreadLocalRandom.current().nextInt(0, 100) > 70) {
                user = createWProfessor(imp);
            } else {
                user = createProfessor(imp);
            }
        } else {
            if (ThreadLocalRandom.current().nextInt(0, 100) > 70) {
                user = createWStudent(imp);
            } else {
                user = createStudent(imp);
            }
        }
        user.setBooks(genBooks(bookFactory));
        return user;
    }

    public Student createStudent(ImpU imp) {
        return new Student(genS(imp.getArrNames()), genS(imp.getArrSurnames()));
    }

    public Student createWStudent(ImpU imp) {
        return new Student(genS(imp.getArrWNames()), genWSurname(genS(imp.getArrSurnames())));
    }

    public Professor createProfessor(ImpU imp) {
        return new Professor(genS(imp.getArrNames()), genS(imp.getArrMiddlenames()), genS(imp.getArrProfSurnames()));
    }

    public Professor createWProfessor(ImpU imp) {
        return new Professor(genS(imp.getArrWNames()), genWMiddlename(genS(imp.getArrMiddlenames())), genWSurname(genS(imp.getArrProfSurnames())));
    }


    public String genS(String[] arr) {
        String s = arr[ThreadLocalRandom.current().nextInt(0, arr.length)];
        return s;
    }

    public String genWMiddlename(String middlename) {
        String wMiddlename = middlename.substring(0, middlename.length() - 3) + "вна";
        return wMiddlename;
    }

    public String genWSurname(String surname) {
        String wSurname = "";
        if (surname.endsWith("в") || surname.endsWith("н")) {
            wSurname = surname + "а";
        } else if (surname.endsWith("ий")) {
            wSurname = surname.substring(0, surname.length() - 2) + "ая";
        } else {
            wSurname = surname;
        }
        return wSurname;
    }

    public HashSet genBooks(BookFactory bookFactory) {
        int num = ThreadLocalRandom.current().nextInt(3, 11);
        HashSet<Book> books = new HashSet<>();
        for (int i = 0; i < num; i++) {
            books.add(bookFactory.getBooks().get(ThreadLocalRandom.current().nextInt(0, bookFactory.getBooks().size())));
        }
        return books;
    }
}
