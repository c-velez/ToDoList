/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Christopher Velez
 */

package ucf.assignments.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ucf.assignments.FileOperator;
import ucf.assignments.Item;
import ucf.assignments.ToDoList;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileOperatorTest {

    FileOperator testMe = new FileOperator();

    @Test
    @DisplayName("Rqmt 13 - saveToDoList: saves a file with a to do list in it")
    void test_that_saveToDoList_saves_a_file_with_a_to_do_list_to_disk() {
        ToDoList testList = new ToDoList();

        //add test items to list
        for(int i = 0; i < 6; i++) {
            Item item = new Item();
            item.setDescription("Item "+ i);
            item.setDueDate("2021-07-07");
            item.setStatus(i % 2 == 0);
            testList.addItem(item);
        }

        //instantiate file to save to
        File test1 = new File("test1.json");

        //pass the list to the saveToDoList method
        testMe.saveToDoList(testList, test1);

        //get the file path of the saved file
        String actual = testMe.getFilePath();

        String expected = "test1.json";

        //assert that the returned path is the expected path
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Rqmt 14 - loadToDoList: returns ToDoList")
    public void test_that_loadToDoList_returns_a_valid_ToDoList() {
        //Instantiate expected to do list
        ToDoList expectedList = new ToDoList();

        //add items to expected to do list
        for(int i = 0; i < 6; i++) {
            Item item = new Item();
            item.setDescription("Item "+ i);
            item.setDueDate("2021-07-07");
            item.setStatus(i % 2 == 0);
            expectedList.addItem(item);
        }

        StringBuilder expectedString = new StringBuilder();

        for(Item item : expectedList.getItems()) {
            expectedString.append(String.format("%s, %s, %s%n",item.getDescription(), item.getDueDate(), item.isStatus()));
        }

        //Instantiate file to open
        File test2 = new File("test2.json");

        //Instantiate actual ToDoList
        //call openToDoList method with the title of the test file, store in actual ToDoList
        ToDoList actualList = testMe.loadToDoList(test2);

        StringBuilder actualString = new StringBuilder();

        for(Item item: actualList.getItems()) {
            actualString.append(String.format("%s, %s, %s%n",item.getDescription(), item.getDueDate(), item.isStatus()));
        }

        //assert that expected list equals actual list
        assertEquals(expectedString.toString(), actualString.toString());
    }
}