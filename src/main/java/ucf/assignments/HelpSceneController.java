/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Christopher Velez
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class HelpSceneController {

    @FXML
    private ImageView reyImage;
    @FXML
    private TextArea helpTextArea;

    public void initialize() {
        try {
            InputStream imageStream = new FileInputStream("src/main/resources/ucf/assignments/pictures/ReyFull.jpg");
            Image reyBody = new Image(imageStream);
            reyImage.setImage(reyBody);

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        String helpText = """
                
                ***NOTE: This window can be left open while interacting with the main application***
                                
                To Do List Application How To:

                When first opened, the to do list will present the user with an empty table.

                Add an Item:

                In order to add an item to the table, click the 'Add Item' button.

                - This button will present the user with another window, where the description and the due date of the
                  item can be inputted.
                - Once you have added a description and a due date, click 'OK', and the item will be added to the table.

                Remove an Item:

                In order to remove an item, select the item on the table, and click the 'Remove Item' button.

                Change the Status of an Item

                To change the status of an item, click the 'Change Status' button.
                - This will change the complete status of the item to 'true' or 'false'.
                - 'true' means the item is complete
                - 'false' means the item is yet to be completed.

                Edit an Item:

                To edit an item, select the item on you would like to edit from the table.
                - Click the 'Edit Item' button.
                - You will be presented with a window that has the current description and due date of the item.
                - To change the description or due date, just type in the new description or due date in the\040
                  designated text field.
                - Once you have finished making your edits, click 'OK' and the changes will be reflected on the table.

                Clear the Table:

                If you would like to clear all current items in the list, click the 'Clear List' button.

                Display Options:

                The 'Display Options' menu allows you to view all of the item, view all completed items, and view\040
                all incomplete items.
                - To view all completed items, select the 'Display Options' drop down, and click 'Display Complete'.
                - At this point, all completed items should be displayed in the table.
                - To view all incomplete items, select the 'Display Options' drop down, and click 'Display Incomplete'.
                - At this point, all incomplete items should be displayed in the table.
                - To view all items in the list, select 'Display Options' drop down, and click 'Display All'.
                - At this point, all items on the list should be displayed in the table.

                Save a List:

                To save your current list, select the 'File' drop down menu and click 'Save List'.
                - This will present you with a file chooser window, that will allow you to choose where to save a\040
                  file and what to name it.
                - Select the location where you would like to save the list, name the list, and click 'Save'

                Load a Previously Saved List:

                To load a previously saved list, select 'File' drop down menu and click 'Load List'.
                - This will present you with a file chooser window, where you can navigate to where your previously\040
                  saved list is.
                - Select the list and click 'Open'.
                
                """;

        helpTextArea.setText(helpText);
        helpTextArea.setEditable(false);

    }

}
