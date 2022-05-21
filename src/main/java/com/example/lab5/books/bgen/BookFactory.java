package com.example.lab5.books.bgen;

import com.example.lab5.books.classes.Book;
import com.example.lab5.books.classes.eng.EngEd;
import com.example.lab5.books.classes.eng.EngFic;
import com.example.lab5.books.classes.rus.RusEd;
import com.example.lab5.books.classes.rus.RusFic;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BookFactory {


    public ArrayList<Book> createBooks(ImpB imp, int num) {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            books.add(createBook(imp));
        }
        return books;
    }

    public String genS(String[] arr) {
        String s = arr[ThreadLocalRandom.current().nextInt(0, arr.length)];
        return s;
    }

    public Book createBook(ImpB imp) {
        Book book;
        int rand = ThreadLocalRandom.current().nextInt(0, 100);
        if (rand < 25) {
            book = createEngEd(imp);
        } else if (rand < 50) {
            book = createEngFic(imp);
        } else if (rand < 75) {
            book = createRusEd(imp);
        } else {
            book = createRusFic(imp);
        }
        return book;
    }

    public EngEd createEngEd(ImpB imp) {
        return new EngEd(genS(imp.getArrEnEdNames()), genS(imp.getArrEnEdAuthors()), genS(imp.getArrEnEdUniversities()));
    }

    public EngFic createEngFic(ImpB imp) {
        return new EngFic(genS(imp.getArrEnFicNames()), genS(imp.getArrEnFicAuthors()));
    }

    public RusEd createRusEd(ImpB imp) {
        int rand_ru = ThreadLocalRandom.current().nextInt(0, 100);
        String add = "";
        if (rand_ru < 34) {
            add = "Учебник ";
        } else if (rand_ru < 67) {
            add = "Задачник ";
        } else {
            add = "Пособие ";
        }
        return new RusEd(add + genS(imp.getArrRuEdNames()));
    }

    public RusFic createRusFic(ImpB imp) {
        return new RusFic(genS(imp.getArrRuFicNames()),genS(imp.getArrRuFicAuthors()));
    }

}
