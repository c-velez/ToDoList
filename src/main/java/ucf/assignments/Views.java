/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Christopher Velez
 */

package ucf.assignments;

public enum Views {
    MAIN("ToDoListApplication.fxml"),
    ADD("AddNewItemScene.fxml"),
    EDIT("EditItemScene.fxml"),
    HELP("HelpScene.fxml");

    private final String fileName;

    Views(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

}
