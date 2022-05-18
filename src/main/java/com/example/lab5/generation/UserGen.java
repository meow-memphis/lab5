package com.example.lab5.generation;

import com.example.lab5.users.Professor;
import com.example.lab5.users.Student;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class UserGen {


    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Professor> professors = new ArrayList<>();

    public void genSt(Import imp) {
        for (int i = 0; i < 200; i++) {
            if (ThreadLocalRandom.current().nextInt(0, 100) > 70) {
                students.add(new Student(genS(imp.getArrWNames()), genWSurname(genS(imp.getArrSurnames()))));
            }
            students.add(new Student(genS(imp.getArrNames()), genS(imp.getArrSurnames())));
        }
    }

     public void genPr(Import imp) {
        for (int i = 0; i < 40; i++) {
            if (ThreadLocalRandom.current().nextInt(0, 100) > 70) {
                professors.add(new Professor(genS(imp.getArrWNames()), genWMiddlename(genS(imp.getArrMiddlenames())), genWSurname(genS(imp.getArrProfSurnames()))));
            }
            professors.add(new Professor(genS(imp.getArrNames()), genS(imp.getArrMiddlenames()), genS(imp.getArrProfSurnames())));
        }
    }

    public String genS(String arr[]) {
        String s = arr[ThreadLocalRandom.current().nextInt(0, arr.length)];
        return s;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
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
}
