/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Christopher Velez
 */

package ucf.assignments;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperator {

    private String filePath;
    private String fileName;

    private void createFile(File file) {
        //make file object
        try {
            //if file is created successfully
            if (file.createNewFile()) {
                //Update filePath
                this.filePath = file.getPath();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void writeToFile(String data) {
        try {
            //create file writer
            FileWriter writeToFile = new FileWriter(getFilePath());

            //write data to file in filePath
            writeToFile.write(data);

            //close the file after data is written to is
            writeToFile.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private ToDoList jsonToJava() {
        //Instantiate new ToDoList
        ToDoList savedList = new ToDoList();
        Gson gson = new Gson();

        try {
            //create file reader
            Reader reader = Files.newBufferedReader(Paths.get(getFilePath()));
            //read file to data structure
            savedList = gson.fromJson(reader, ToDoList.class);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        //return json object
        return savedList;
    }

    private String javaToJson(ToDoList list) {
        //create gson builder
        GsonBuilder builder = new GsonBuilder();

        //create gson object to builder the syntax
        Gson gson = builder.create();

        //return the formatted syntax
        return gson.toJson(list);
    }

    private boolean isFile(File file) {

        //return whether or not the file exists
        return file.exists();
    }

    public void setFilePath(String filePath) {
        //set instance variable to the filePath of the fileName
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFileName(String title) {
        //set instance variable to the fileName
        this.fileName = title;
    }

    public void saveToDoList(ToDoList list, File file) {

        //convert list to it to JSON
        String jsonList = javaToJson(list);

        //if the file does not exist
        setFileName(file.getName());

        if (isFile(file)) {
            //file exists, set the path
            setFilePath(file.getPath());
        } else {
            //file does not exist, create the file with the title of the list as the file name
            createFile(file);
        }

        //write json object to file object
        writeToFile(jsonList);
    }

    public ToDoList loadToDoList(File file) {

        //set the file name
        setFileName(file.getName());

        //set the file path for the list
        setFilePath(file.getPath());

        //return ToDoList
        return jsonToJava();
    }

}
