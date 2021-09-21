/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Christopher Velez
 */
package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewItemController {

    @FXML private TextField itemDescriptionTextField;
    @FXML private TextField itemDueDateTextField;
    @FXML private Button addNewItemOkButton;
    @FXML private Button addNewItemCancelButton;
    private Item newItem;

    public void initialize(Item item) {
        this.newItem = item;
    }

    @FXML
    public void addNewItemOkButtonPressed() {
        //get the text written in the text field of the description, set the description of the item
        newItem.setDescription(itemDescriptionTextField.getText());

        //get the text written in the text field of the due date, set the due date of the item
        newItem.setDueDate(itemDueDateTextField.getText());

        //get the current window of the scene
        Stage stage = (Stage) addNewItemOkButton.getScene().getWindow();

        //close the window
        stage.close();
    }

    @FXML
    public void addNewItemCancelButtonPressed() {
        //get the current window of the scene
        Stage stage = (Stage) addNewItemCancelButton.getScene().getWindow();

        //close the window
        stage.close();
    }
}
