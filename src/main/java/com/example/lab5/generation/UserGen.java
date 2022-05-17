package com.example.lab5.generation;

import com.example.lab5.users.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class UserGen {


    ArrayList<Student> students = new ArrayList<>();

    public void genSt(Import imp) {
        for (int i = 0; i < 30; i++) {
            if (ThreadLocalRandom.current().nextInt(0, 100) > 70) {
                students.add(new Student(imp.getArrWNames()[ThreadLocalRandom.current().nextInt(0, imp.getArrWNames().length)],imp.getArrWSurnames()[ThreadLocalRandom.current().nextInt(0, imp.getArrWSurnames().length)]));
            }
            students.add(new Student(imp.getArrNames()[ThreadLocalRandom.current().nextInt(0, imp.getArrNames().length)],imp.getArrSurnames()[ThreadLocalRandom.current().nextInt(0, imp.getArrSurnames().length)]));
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
