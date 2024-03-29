package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Jeanne Moore
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class FXMLController {
    //  four lists declared, one to hold current todos, one to hold completed todos, one to hold queued completed todos
    private final ObservableList<ObservableList<String>> todos = FXCollections.observableArrayList();
    //  ObservableList tempCompleted
    //  Use the fourth list to track which list to look at. By default set to todos at start
    //  ObservableList view = todos.get(0);
    //  Use another variable to represent selectedItem
    //  ToDoClass selected = new ToDoClass();

    public void initLists() {
        ObservableList<String> current = FXCollections.observableArrayList();
        ObservableList<String> complete = FXCollections.observableArrayList();
        for (int i = 1; i <= 256; i++) {
            //  Proper formatting will be required when implementing ToDoList objects
            //  For now, List is of type String and each element is as follows for
            //  presentation purposes:


            current.add(String.format("%s%200s", "todo " + i, "todo date " + i));
            complete.add(String.format("%s%200s","completed todo" + i,"completed date "+i));
        }
        todos.add(current);
        todos.add(complete);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private Button loadButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button saveButton;

    @FXML
    private CheckBox completedCheckBox;

    @FXML
    private CheckBox saveCompletedCheckBox;

    @FXML
    private CheckBox saveToDoCheckBox;

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
    private TextField itemDescField;

    @FXML
    private TextField itemNameField;

    @FXML
    private ListView<String> toDoList;
        // Will be of type ToDoClass after implementation


    //  ToDo - Create a method: public void removeItem(ToDoClass item, ObservableList<ToDoClass> list)
    //      remove button function feeds selected list and item to method
    //      method searches the list for the item then removes it


    //  ToDo - Create a method: public void addItem(ToDoClass item, ObservableList<ToDoClass> list)
    //      the text inside of the fields is added to a new ToDoList object
    //      the text inside of the fields is cleared
    //      the list is updated, then sorted by item date
    //      clear the toDoList and set its items to be the list


    //  ToDo - Create a method: public boolean checkItemIsCompleted(ToDoClass item, ObservableList<ToDoClass> list)
    //      this method has been called if the user selects an item in the list
    //      The method checks if the item is already in the temp completed list
    //      Method loops through every element and compares it to item
    //      if item is found, return true


    //  @FXML - Create a method: void applyChanges(ActionEvent event)
    //      method effectively removes each item in the temp completed list from the current todos,
    //      then it adds each of those items to the completed list
    //      and clears the temp completed list
    //      once an item has been marked and applied as finished, there is no way to remove it from
    //      the completed list other than by clearing the list entirely.


    //  @FXML - Create a method: void itemCompleted(ActionEvent event)
    //      User is not allowed to check an item a second time, if an item has already been checked,
    //      the checkbox will be checked already
    //      when the checkbox is filled, first check to see if an item has been selected by user
    //          if so, add the item to the temp completed list


    //  @FXML - Create a method: void remove(ActionEvent event)
    //      get viewed list inside list of lists
    //      get selected item
    //      if an item was selected
    //          removeItem(selectedItem, list)


    //  @FXML - Create a method: void add(ActionEvent event)
    //      if any fields (name,date,desc) are blank,
    //          return
    //      else
    //          addItem(Item)


    //  @FXML - Create a method: void remove(ActionEvent event)
    //      method gets selected item and list, then feeds it into removeItem method
    //      removeItem(selectedItem, view)


    //  @FXML - Create a method: void uncheckComplete(ActionEvent event)
    //      remove selected item from temp completed list


    //  @FXML - Create a method: void edit(ActionEvent event)
    //      get name, description and date fields
    //      if something is blank, do not change that one
    //      if name field is empty, return
    //      search both lists for the selected item,
    //      when found,
    //      check if the description is blank
    //          if so, set it to the edit field
    //      check if the date is blank
    //          if so, set it to the edit field
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


    //  @FXML - Create a method: void setCurrentDate()
    //      get current date
    //      currentDate.setText(formatted today's date)


    @FXML
    void ViewCurrent(ActionEvent event) {
        //Changes view so that user is looking at todos list
        System.out.println("Changed to current todos");
        // clear toDoList and set its items to be the todos list
        // set view to be todos(0)
    }

    @FXML
    void viewCompleted(ActionEvent event) {
        //Changes view so the viewer is looking at completed list
        System.out.println("Changed to completed todos");
        //  clear toDoList and set its items to be the completed list within list of lists
        //  set view to be todos(1)
    }

    @FXML
    void viewAll(ActionEvent event) {
        //Changes view so the viewer is looking at completed list
        System.out.println("Changed to completed todos");
        //  clear toDoList and set its items to be the completed list within list of lists
        //  set view to be todos.get(0) + todos.get(1)  (current and completed todos)
    }


    //  Initialization of application
    public void initialize() {
        //  This logic is vital to express the fact that a list is being presented
        //  i is used to represent the list's capacity to reach at least 256 items
        initLists();
        toDoList.setItems(todos.get(0));
        //  get selection of an item in a list
        toDoList.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    //  In the future, each object of list will have its own description as a String variable.
                    //  For now, description is just the first 20 characters of the selected item

                    descriptionPane.setContentText(toDoList.getSelectionModel().getSelectedItem().substring(0,20));
                    //  set getSelectedItem to be selectedItem
                    //  setCurrentDate(); to change text at top to say current date
                    //  check if the item is in the temp completed list. If so, autofill the checkbox
                }
        );
    }


}