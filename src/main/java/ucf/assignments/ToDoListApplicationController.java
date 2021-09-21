/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Christopher Velez
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class ToDoListApplicationController {

    @FXML
    private TableView<Item> toDoListItemsView;
    @FXML
    private ImageView helpButton;
    private TableView.TableViewSelectionModel<Item> selection;
    private ToDoList toDoList = new ToDoList();

    private final TableOperator tableOperator = new TableOperator();
    private final SceneOperator sceneOperator = new SceneOperator();
    private final FileChooser fileChooser = new FileChooser();
    private final FileOperator fileOperator = new FileOperator();

    public void initialize() {

        //tell the table operator which table to operate on
        tableOperator.setTable(toDoListItemsView);

        //build the table
        tableOperator.buildTable();

        //get the built table
        toDoListItemsView = tableOperator.getTable();

        //get the selection model for that table
        selection = tableOperator.getSelection();

        try {
            //get the image for help button
            InputStream imageStream = new FileInputStream("src/main/resources/ucf/assignments/pictures/ReyHead.jpg");

            //set the help image
            Image rey = new Image(imageStream);
            helpButton.setImage(rey);

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    }

    //Application Operations
    @FXML
    public void saveListButtonPressed() {
        //when saveCurrentListButtonPressed
        Window window = readyFileChooser("Save List");

        //create a file object to hold file choice
        File file = fileChooser.showSaveDialog(window);

        //save the to do list
        fileOperator.saveToDoList(toDoList, file);
    }

    @FXML
    public void loadListButtonPressed() {
        //clear all the items from the current table
        toDoListItemsView.getItems().clear();

        //ready the dialog box
        Window window = readyFileChooser("Load List");

        //create a file object to hold file choice
        File file = fileChooser.showOpenDialog(window);

        //load the to do list
        toDoList = fileOperator.loadToDoList(file);

        //set the table that the table operator will operate on
        tableOperator.setTable(toDoListItemsView);

        //add list items to the table view
        tableOperator.loadTable(toDoList);
    }

    @FXML
    public void helpImagePressed() {
        //ready the help page
        Parent page = sceneOperator.readyScene(Views.HELP);

        //popUp the help page
        sceneOperator.popUpScene("Help!", page);
    }

    //list operations
    @FXML
    public void addItemButtonPressed() {
        //instantiate a new item
        Item newItem = new Item();

        //ready the add item scene
        Parent page = sceneOperator.readyScene(Views.ADD);

        //get the controller for the AddNewItemScene
        AddNewItemController addNewItemController = sceneOperator.getLoader().getController();

        //initialize the controller
        addNewItemController.initialize(newItem);

        //pop up window
        sceneOperator.popUpScene("Add Item", page);

        //add the newly created item to the
        toDoList.addItem(newItem);

        //refresh tableView
        toDoListItemsView.getItems().add(newItem);

    }

    @FXML
    public void removeItemButtonPressed() {
        //get selected item from table
        Item selectedItem = selection.getSelectedItem();

        //remove it from toDoList
        toDoList.deleteItem(selectedItem.getDescription());

        //remove it from the table
        toDoListItemsView.getItems().removeAll(selectedItem);
    }

    @FXML
    public void clearListButtonPressed() {
        //clear out the table view
        toDoListItemsView.getItems().clear();

        //clear out all items from the to do list
        toDoList.deleteAllItems();
    }

    //Item Operations
    @FXML
    public void changeStatusButtonPressed() {
        //get the selected item
        Item selectedItem = selection.getSelectedItem();

        //remove the previous item from the to do list
        toDoList.deleteItem(selectedItem.getDescription());

        //remove selected item from the view
        toDoListItemsView.getItems().clear();

        //update the status
        selectedItem.setStatus(!selectedItem.isStatus());

        //add item to the to do list
        toDoList.addItem(selectedItem);

        //set the table that the table operator will operate on
        tableOperator.setTable(toDoListItemsView);

        //add the updated item to the table view
        tableOperator.loadTable(toDoList);
    }

    @FXML
    public void editItemButtonPressed() {
        //get selected item
        Item selectedItem = selection.getSelectedItem();

        //remove it from the to do list
        toDoList.deleteItem(selectedItem.getDescription());

        //remove it from the table view
        toDoListItemsView.getItems().removeAll(selectedItem);

        //ready the edit item scene
        Parent page = sceneOperator.readyScene(Views.EDIT);

        //get the controller for the EditItemScene
        EditItemController editItemController = sceneOperator.getLoader().getController();

        //initialize the controller
        editItemController.initialize(selectedItem);

        //pop up window
        sceneOperator.popUpScene("Edit Item", page);

        //add the updated item to the to do list
        toDoList.addItem(selectedItem);

        //place the updated item back on the table view
        toDoListItemsView.getItems().add(selectedItem);
    }

    //Display Operations
    @FXML
    public void displayAllButtonPressed() {
        //remove all current items from the table
        toDoListItemsView.getItems().clear();

        //set the table for the table operator to operate on
        tableOperator.setTable(toDoListItemsView);

        //add all items in the to do list to the table
        tableOperator.loadTable(toDoList);
    }

    @FXML
    public void displayCompleteButtonPressed() {
        //call getCompletedItems method for the to do list
        ArrayList<Item> completedList = toDoList.getCompleteItems();

        //remove full list from the table
        toDoListItemsView.getItems().clear();

        //set the table for the table operator to operate on
        tableOperator.setTable(toDoListItemsView);

        //add the items to the table view
        tableOperator.loadTable(completedList);
    }

    @FXML
    public void displayIncompleteButtonPressed() {
        //call getIncompleteItems method
        ArrayList<Item> incompleteList = toDoList.getIncompleteItems();

        //remove full list from the table
        toDoListItemsView.getItems().clear();

        //set the table for the table operator to operate on
        tableOperator.setTable(toDoListItemsView);

        //add the items to the table view
        tableOperator.loadTable(incompleteList);
    }

    private Window readyFileChooser(String title) {
        //ready the stage for the dialog box
        Window window = toDoListItemsView.getScene().getWindow();

        //set the title for the box
        fileChooser.setTitle(title);

        //set initial file to open
        fileChooser.setInitialFileName("changeMe");

        //add appropriate extensions to be displayed
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("*.txt", "*.txt"),
                new FileChooser.ExtensionFilter("*.json", "*.json"),
                new FileChooser.ExtensionFilter("All", "*.*")
        );

        //return the readied FileChooser pop up stage
        return window;
    }
}