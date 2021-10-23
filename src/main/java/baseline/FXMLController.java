package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Design
 *  Copyright 2021 Jeanne Moore
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import javax.swing.*;

public class FXMLController {
    //  Functionality to add:
    //  -   User ability to input a new item to the list via a

    private final ObservableList<String> todos = FXCollections.observableArrayList();
    private final ObservableList<String> completed = FXCollections.observableArrayList();
    private final ObservableList<String> tempCompleted = FXCollections.observableArrayList();

    public void initLists() {
        for (int i = 1; i <= 256; i++) {
            //  Proper formatting will be required when implementing ToDoList objects
            //  For now, List is of type String and each element is as follows for
            //  presentation purposes:
            todos.add(String.format("%s%200s", "todo " + i, "todo date " + i));
            completed.add(String.format("%s%200s","completed todo" + i,"completed date "+i));
        }
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ItemDescField;

    @FXML
    private Button addItemButton;

    @FXML
    private Button applyChangesButton;

    @FXML
    private Button changeViewAllButton;

    @FXML
    private Button changeViewCompletedButton;

    @FXML
    private Button changeViewCurrentButton;

    @FXML
    private CheckBox completedCheckBox;

    @FXML
    private Text currentDate;

    @FXML
    private DialogPane descriptionPane;

    @FXML
    private Button editItemButton;

    @FXML
    private TextField fileNameField;

    @FXML
    private TextField itemDateField;

    @FXML
    private TextField itemNameField;

    @FXML
    private Button loadButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button saveButton;

    @FXML
    private CheckBox saveCompletedCheckBox;

    @FXML
    private CheckBox saveToDoCheckBox;

    @FXML
    private ListView<String> toDoList;

    //  TIL: ToDo highlights comments green


    //  ToDo - Create a method: void removeItem(ObservableList<String> list, ToDoClass item)
    //      remove button function feeds selected list and item to method
    //      method searches the list for the item then removes it


    //  ToDo - Create a method: void addItem(ToDoClass item)
    //      if there is user input entered into the fields and the add button is clicked,
    //          program verifies that all fields are filled in a validation loop.
    //      If user does not give valid input for an item to add to the list,
    //          tell user to enter a valid date and fill all fields
    //      If all verification passes,
    //          the text inside of the fields is added to a new ToDoList object
    //          the text inside of the fields is cleared
    //          the current list is updated, then sorted by item date
    //          clear toDoList and set its items to be the current todos list


    //  ToDo - Create a method: boolean checkItemIsCompleted(ToDo item)
    //      this method has been called if the user selects an item in the list
    //      The method checks if the item is already in the temp completed list
    //      Method loops through every element and compares it to item
    //      if item is found, return true


    //  ToDo - Create a method: void itemCompleted(event)
    //      User is not allowed to check an item a second time, if an item has already been checked,
    //      the checkbox will be checked already
    //      when the checkbox is filled, first check to see if an item has been selected by user
    //          if so, add the item to the temp completed list


    //  ToDo - Create a method: void RemoveFromCompleted(ToDo item)
    //      function is called if the user unchecks a box that has been checked
    //      item is used to search temp complete list with a for loop
    //          remove that item from the list at that index


    //  ToDo - Create a method: void ApplyChanges()
    //      method effectively removes each item in the temp completed list from the current todos,
    //      then it adds each of those items to the completed list
    //      and clears the temp completed list
    //      once an item has been marked and applied as finished, there is no way to remove it from
    //      the completed list other than by clearing the list entirely.


    //  @FXML - Create a method: void remove(ActionEvent event)
    //      method gets selected item and list, then feeds it into removeItem method
    //      removeItem(selectedItem, selectedList)


    //  @FXML - Create a method: void edit(ActionEvent event)
    //      get description and date edit fields
    //      if either is blank, do not change that one
    //      search both lists for the selected item,
    //      when found,
    //      if (!editDescription.equals(""))
    //          item description = editDescription
    //      if (!editDate.equals(""))
    //          item date = editDate
    //      Clear both edit fields
    //      Call to the list it was found in by date


    //  @FXML - Create a method: void saveList(ActionEvent event)
    //      get fileName from filename text field
    //      if fileName is blank, do nothing
    //      else if fileName does not end with .txt, do nothing
    //      else
    //          make a new WriteToDoList object
    //          if todos checkbox was clicked
    //              if completed checkbox was clicked
    //                  writeToDoList(fileName,todos,completed)
    //              else
    //                  writeToDoList(fileName,todos, blank list)
    //          else if completed checkbox was clicked
    //              writeToDoList(fileName, blank list, todos)


    //  @FXML - Create a method: void loadList(ActionEvent event)
    //      get fileName from filename text field
    //      if fileName is blank, do nothing
    //      else if fileName does not end with .txt, do nothing
    //      else
    //              make new ReadToDoList object
    //              readToDoList(fileName, todos, completed)


    @FXML
    void current(ActionEvent event) {
        //Changes view so that user is looking at completed list
        System.out.println("Changed to current todos");
        // clear toDoList and set its items to be the todos list
    }

    @FXML
    void completed(ActionEvent event) {
        //Changes view so the viewer is looking at completed list
        System.out.println("Changed to completed todos");
        //  clear toDoList and set its items to be the completed list
    }


    //  Initialization of application
    public void initialize() {
        //  This logic is vital to express the fact that a list is being presented
        //  i is used to represent the list's capacity to reach at least 256 items
        initLists();
        toDoList.setItems(todos);
        toDoList.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        //  In the future, each object of list will have its own description as a String variable.
                        //  For now, description is just the first part
                        descriptionPane.setContentText(toDoList.getSelectionModel().getSelectedItem().substring(0,20));
                    }
                }
        );
    }


}