/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Christopher Velez
 */

package ucf.assignments;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;

public class TableOperator {

    private TableView<Item> table;
    private TableView.TableViewSelectionModel<Item> selection;

    public void buildTable() {
        //build column 1
        TableColumn<Item, String> column1 = new TableColumn<>("Description");
        column1.setPrefWidth(225);
        column1.setCellValueFactory(new PropertyValueFactory<>("description"));

        //build column 2
        TableColumn<Item, String> column2 = new TableColumn<>("Due Date");
        column2.setPrefWidth(100);
        column2.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

        //build column 3
        TableColumn<Item, String> column3 = new TableColumn<>("Complete?");
        column3.setCellValueFactory(new PropertyValueFactory<>("status"));

        table.setPlaceholder(new Label("No tasks to display"));

        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.getColumns().add(column3);

        selection = table.getSelectionModel();
    }

    public void setTable(TableView<Item> table) {
        this.table = table;
    }

    public TableView<Item> getTable() {
        return table;
    }

    public TableView.TableViewSelectionModel<Item> getSelection() {
        return selection;
    }

    public void loadTable(ToDoList toDoList) {

        //for each item in the to do list
        for (Item item : toDoList.getItems()) {

            //add it to the table view
            table.getItems().add(item);
        }
    }

    public void loadTable(ArrayList<Item> list) {

        //for each item in the list array
        for (Item item : list) {

            //add it to the table view
            table.getItems().add(item);
        }
    }
}
