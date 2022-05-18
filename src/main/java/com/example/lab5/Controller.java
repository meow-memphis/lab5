package com.example.lab5;

import com.example.lab5.books.bgen.ImpB;
import com.example.lab5.users.classes.Professor;
import com.example.lab5.users.classes.Student;
import com.example.lab5.users.ugen.ImpU;
import com.example.lab5.users.ugen.UserGen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;

public class Controller {

    @FXML
    private TreeView<String> tree;

    public static void error(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }

    @FXML
    void impBook(ActionEvent event) {
        try {
            FileChooser fc = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel", "*.xlsx");
            fc.getExtensionFilters().add(extFilter);
            File file = fc.showOpenDialog(null);
            ImpB impB = new ImpB();
            impB.setAll(file);

        } catch (Exception e) {
            error(e);
        }
    }

    @FXML
    void impUser(ActionEvent event) {
        try {
            FileChooser fc = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel", "*.xlsx");
            fc.getExtensionFilters().add(extFilter);
            File file = fc.showOpenDialog(null);
            ImpU impU = new ImpU();
            impU.setAll(file);

        } catch (Exception e) {
            error(e);
        }
    }

    @FXML
    void start(ActionEvent event) {
        try {
            File fileU = new File((getClass().getResource("names.xlsx").getFile()));
            ImpU impU = new ImpU();
            impU.setAll(fileU);
            File fileB = new File((getClass().getResource("books.xlsx").getFile()));
            ImpB impB = new ImpB();
            impB.setAll(fileB);

            UserGen userGen = new UserGen();
            userGen.genSt(impU);
            userGen.genPr(impU);

            initialize(userGen.getStudents(), userGen.getProfessors());

        } catch (Exception e) {
            error(e);
        }
    }

    public void initialize(ArrayList<Student> students, ArrayList<Professor> professors) {

        TreeItem<String> rootItem = new TreeItem<>("Пользователи");
        rootItem.setExpanded(true);
        TreeItem<String> studentBranchItem = new TreeItem<>("Студенты (" + students.size() + ")");
        rootItem.getChildren().add(studentBranchItem);
        for (Student student : students) {
            TreeItem<String> branchItem = new TreeItem<>(student.getFullName());
//            student.getBooks().forEach((book) -> {
//                Book bk = (Book) book;
//                bk.getName();
            //branchItem.getChildren().add(new TreeItem<>("name : " + reactor.getName()));
//                    });
//            TreeItem<String> leafItem1 = new TreeItem<>("name : " + reactor.getName());
//            TreeItem<String> leafItem2 = new TreeItem<>("burnup : " + reactor.getBurnup());
//            TreeItem<String> leafItem3 = new TreeItem<>("kpd : " + reactor.getKpd());
//            TreeItem<String> leafItem4 = new TreeItem<>("enrichment : " + reactor.getEnrichment());
//            TreeItem<String> leafItem5 = new TreeItem<>("termal_capacity : " + reactor.getTermal_capacity());
//            TreeItem<String> leafItem6 = new TreeItem<>("electrical_capacity : " + reactor.getElectrical_capacity());
//            TreeItem<String> leafItem7 = new TreeItem<>("life_time : " + reactor.getLife_time());
//            TreeItem<String> leafItem8 = new TreeItem<>("first_load : " + reactor.getFirst_load());
//            TreeItem<String> leafItem9 = new TreeItem<>("source : " + reactor.getSource());
//
//            branchItem.getChildren().addAll(leafItem1, leafItem2, leafItem3, leafItem4, leafItem5, leafItem6, leafItem7, leafItem8, leafItem9);

            studentBranchItem.getChildren().add(branchItem);
        }

        TreeItem<String> professorBranchItem = new TreeItem<>("Преподаватели (" + professors.size() + ")");
        rootItem.getChildren().add(professorBranchItem);

        for (Professor professor : professors) {
            TreeItem<String> branchItem = new TreeItem<>(professor.getFullName());
            professorBranchItem.getChildren().add(branchItem);
        }

        tree.setRoot(rootItem);

    }

}
