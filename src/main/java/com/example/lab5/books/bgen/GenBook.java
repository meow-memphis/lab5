package com.example.lab5.books.bgen;

import com.example.lab5.books.classes.Book;
import com.example.lab5.books.classes.rus.RusEd;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GenBook {

    public String genS(String[] arr) {
        String s = arr[ThreadLocalRandom.current().nextInt(0, arr.length)];
        return s;
    }

    public String genNameRusEd(String[] arr) {
        int rand_ru = ThreadLocalRandom.current().nextInt(0, 100);
        String add = "";
        if (rand_ru < 34) {
            add = "Учебник ";
        } else if (rand_ru < 67) {
            add = "Задачник ";
        } else {
            add = "Пособие ";
        }
        return (add + genS(arr));
    }



}
