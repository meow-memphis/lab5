package com.example.lab5;

import com.example.lab5.generation.Import;
import com.example.lab5.generation.UserGen;
import com.example.lab5.users.Student;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InvalidFormatException {

        // App.main(args);

        Import imp = new Import();

        File file = new File("C:\\Users\\user\\IdeaProjects\\lab5\\src\\main\\resources\\com\\example\\lab5\\names.xlsx");
        imp.setAll(file);

        for (String s : imp.getArrNames()) {
            System.out.println(s);
        }
        for (String s : imp.getArrMiddlenames()) {
            System.out.println(s);
        }        for (String s : imp.getArrWMiddlenames()) {
            System.out.println(s);
        }
//        for (String s : imp.getArrWNames()) {
//            System.out.println(s);
//        }
//        for (String s : imp.getArrProfSurnames()) {
//            System.out.println(s);
//        }


        UserGen ugen = new UserGen();

        ugen.genSt(imp);

//        for (Student st: ugen.getStudents()
//             ) {
//            System.out.println(st.getName()+" "+st.getSurname());
//
//        }




    }
}
