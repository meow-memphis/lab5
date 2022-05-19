package com.example.lab5;

import com.example.lab5.books.bgen.BookFactory;
import com.example.lab5.books.bgen.ImpB;
import com.example.lab5.books.classes.Book;
import com.example.lab5.books.classes.eng.EngEd;
import com.example.lab5.books.classes.eng.EngFic;
import com.example.lab5.books.classes.rus.RusFic;
import com.example.lab5.users.classes.User;
import com.example.lab5.users.ugen.ImpU;
import com.example.lab5.users.ugen.UserFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;

public class Controller {

    int numBooks = 500;
    int numUsers = 200;

    UserFactory userFactory = new UserFactory();
    BookFactory bookFactory = new BookFactory();

    @FXML
    private TreeView<String> tree;

    @FXML
    private Button buttonUser;

    public void initialize(){
        buttonUser.setDisable(true);
    }

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

            bookFactory.createBooks(impB, numBooks);

            buttonUser.setDisable(false);
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

            userFactory.createUsers(impU, numUsers, bookFactory);

            initializeTree(userFactory.getUsers());

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

            bookFactory.createBooks(impB, numBooks);

            userFactory.createUsers(impU, numUsers, bookFactory);

            initializeTree(userFactory.getUsers());

        } catch (Exception e) {
            error(e);
        }
    }

    public void initializeTree(ArrayList<User> users) {

        int stNum = 0;
        int prNum = 0;

        TreeItem<String> rootItem = new TreeItem<>("Пользователи");
        rootItem.setExpanded(true);
        TreeItem<String> studentBranchItem = new TreeItem<>();
        rootItem.getChildren().add(studentBranchItem);
        TreeItem<String> professorBranchItem = new TreeItem<>();
        rootItem.getChildren().add(professorBranchItem);


        for (User user : users) {

            TreeItem<String> branchItem = new TreeItem<>(user.getFullName() + " (" + user.getBooks().size() + ")");
            if (user.getClass().getName().equals("com.example.lab5.users.classes.Student")) {
                studentBranchItem.getChildren().add(branchItem);
                stNum++;
            } else {
                professorBranchItem.getChildren().add(branchItem);
                prNum++;
            }

            user.getBooks().forEach((obj) -> {
                Book book = (Book) obj;

                TreeItem<String> bookItem = new TreeItem<>(book.getName());
                branchItem.getChildren().add(bookItem);
                TreeItem<String> leafItemType = new TreeItem<>("type : " + book.getClass().getName().substring(book.getClass().getName().length() - 6).replace(".",""));
                bookItem.getChildren().add(leafItemType);
                TreeItem<String> leafItemLang = new TreeItem<>("lang : " + book.getLang());
                bookItem.getChildren().add(leafItemLang);

                if (book.getClass().getName().equals("com.example.lab5.books.classes.eng.EngEd")) {
                    EngEd b = (EngEd) book;
                    TreeItem<String> leafItemAuthor = new TreeItem<>("author : " + b.getAuthor());
                    bookItem.getChildren().add(leafItemAuthor);
                    TreeItem<String> leafItemUniversity = new TreeItem<>("university : " + b.getUniversity());
                    bookItem.getChildren().add(leafItemUniversity);
                } else if (book.getClass().getName().equals("com.example.lab5.books.classes.eng.EngFic")) {
                    EngFic b = (EngFic) book;
                    TreeItem<String> leafItemAuthor = new TreeItem<>("author : " + b.getAuthor());
                    bookItem.getChildren().add(leafItemAuthor);
                }else if (book.getClass().getName().equals("com.example.lab5.books.classes.rus.RusFic")) {
                    RusFic b = (RusFic) book;
                    TreeItem<String> leafItemAuthor = new TreeItem<>("author : " + b.getAuthor());
                    bookItem.getChildren().add(leafItemAuthor);
                }

            });

        }

        studentBranchItem.setValue("Студенты (" + stNum + ")");
        professorBranchItem.setValue("Преподаватели (" + prNum + ")");

        tree.setRoot(rootItem);

    }

}
