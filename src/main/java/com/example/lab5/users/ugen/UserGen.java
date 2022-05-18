package com.example.lab5.users.ugen;

import com.example.lab5.users.classes.Professor;
import com.example.lab5.users.classes.Student;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class UserGen {

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Professor> professors = new ArrayList<>();

    int numStudents = 200;
    int numProfessors = 40;


    public void genSt(ImpU imp) {
        for (int i = 0; i < numStudents; i++) {
            if (ThreadLocalRandom.current().nextInt(0, 100) > 70) {
                students.add(new Student(genS(imp.getArrWNames()), genWSurname(genS(imp.getArrSurnames()))));
            }else {
                students.add(new Student(genS(imp.getArrNames()), genS(imp.getArrSurnames())));
            }
        }
    }

     public void genPr(ImpU imp) {
        for (int i = 0; i < numProfessors; i++) {
            if (ThreadLocalRandom.current().nextInt(0, 100) > 70) {
                professors.add(new Professor(genS(imp.getArrWNames()), genWMiddlename(genS(imp.getArrMiddlenames())), genWSurname(genS(imp.getArrProfSurnames()))));
            }else {
                professors.add(new Professor(genS(imp.getArrNames()), genS(imp.getArrMiddlenames()), genS(imp.getArrProfSurnames())));
            }
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
