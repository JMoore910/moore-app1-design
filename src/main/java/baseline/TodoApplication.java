package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Design
 *  Copyright 2021 Jeanne Moore
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TodoApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {



        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ToDoApp.fxml")));

        Scene scene = new Scene(root);
        stage.setTitle("To Do List");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
