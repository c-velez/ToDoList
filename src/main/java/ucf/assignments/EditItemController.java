/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Christopher Velez
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class EditItemController {
    @FXML
    private TextField itemDescriptionTextField;
    @FXML
    private TextField itemDueDateTextField;
    @FXML
    private Button editItemOkButton;
    @FXML
    private Button editItemCancelButton;
    private Item item;

    public void initialize(Item item) {
        //assign the passed item to this instance of the item
        this.item = item;

        //set the description text field text to what is already in the item
        itemDescriptionTextField.setText(item.getDescription());

        //set the due date text field text to what is already in the item
        itemDueDateTextField.setText(item.getDueDate());
    }

    @FXML
    public void editItemOkButtonPressed() {
        //set the item description to what is written in the text field
        item.setDescription(itemDescriptionTextField.getText());

        //set the item due date to what is written in the text field
        item.setDueDate(itemDueDateTextField.getText());

        //get the current window
        Stage stage = (Stage) editItemOkButton.getScene().getWindow();

        //close the window
        stage.close();
    }

    @FXML
    public void editItemCancelButtonPressed() {
        //get the current window
        Stage stage = (Stage) editItemCancelButton.getScene().getWindow();

        //close the window
        stage.close();
    }
}
