package com.example.lab5;

import com.example.lab5.users.ugen.ImpU;
import com.example.lab5.users.ugen.UserGen;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InvalidFormatException {

        // App.main(args);

        ImpU imp = new ImpU();

        File file = new File("C:\\Users\\user\\IdeaProjects\\lab5\\src\\main\\resources\\com\\example\\lab5\\names.xlsx");
        imp.setAll(file);

        UserGen ugen = new UserGen();
//        for (String s : imp.getArrNames()) {
//            System.out.println(s);
//        }
//        for (String s : imp.getArrMiddlenames()) {
//            System.out.println(ugen.genWMiddlename(s));
//        }
//        for (String s : imp.getArrWMiddlenames()) {
//            System.out.println(s);
//        }
//        for (String s : imp.getArrWNames()) {
//            System.out.println(s);
//        }
//        for (String s : imp.getArrProfSurnames()) {
//            System.out.println(s);
//        }



        ugen.genSt(imp);

//        for (Student st: ugen.getStudents()
//             ) {
//            System.out.println(st.getName()+" "+st.getSurname());
//        }

//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();

        ugen.genPr(imp);

//        for (Professor st: ugen.getProfessors()
//             ) {
//            System.out.println(st.getName()+" "+st.getMiddlename() + " "+st.getSurname());
//        }

        System.out.println();




    }
}
