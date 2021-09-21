/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Christopher Velez
 */

package ucf.assignments.operators;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ucf.assignments.Item;
import ucf.assignments.ToDoList;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {

    @Test
    @DisplayName("Rqmt 4: ToDoList addItem: test that 100 items can be added to the to do list")
    public void test_that_ToDoList_can_hold_100_items() {
        ToDoList testMe = new ToDoList();

        for(int i = 0; i <100; i++) {
            Item item = new Item();
            testMe.addItem(item);
        }

        assertEquals(100, testMe.getItems().size());
    }

    @Test
    @DisplayName("Rqmt 5: ToDoList deleteItem: test that the correct item is deleted from the list")
    void test_that_deleteItem_deletes_the_correct_item_from_the_list() {
        ToDoList testMe = new ToDoList();

        Item item1 = new Item();
        item1.setDescription("This is item 1");
        Item item2 = new Item();
        item2.setDescription("Delete me");

        testMe.addItem(item1);
        testMe.addItem(item2);

        testMe.deleteItem("Delete me");

        assertEquals(1, testMe.getItems().size());
    }

    @Test
    @DisplayName("Rqmt 6: ToDoList deleteAllItems: test that all items are deleted from a given list")
    public void test_that_deleteAllItems_deletes_all_items_from_the_list() {
        //instantiate test list
        ToDoList testMe = new ToDoList();

        //add items to test list
        for(int i = 0; i < 10; i++) {
            Item item = new Item();
            item.setDescription("Item "+ (i+1));
            item.setDueDate("2021-07-08");
            item.setStatus(i % 2 == 0);

            testMe.addItem(item);
        }

        //deleteAllItems from test list
        testMe.deleteAllItems();

        //get items from the list
        ArrayList<Item> actual = testMe.getItems();

        //assert that the list is empty
        assertThat(actual, IsEmptyCollection.empty());
    }

    @Test
    @DisplayName("ToDoList getSingleItem: test that the requested item is returned")
    void getSingleItem() {

        ToDoList testMe = new ToDoList();

        for(int i = 0; i < 3; i++) {
            Item item = new Item();
            item.setDescription("This is item "+ i);
            testMe.addItem(item);
        }

        Item actual = testMe.getSingleItem("This is item 2");

        String expected = "This is item 2";

        assertEquals(expected, actual.getDescription());
    }

    @Test
    @DisplayName("Rqmt 10: ToDoList getItems: test that a list of ALL items is returned")
    public void test_that_getItems_returns_a_list_of_all_items_in_the_to_do_list() {

        //instantiate test list
        ToDoList testMe = new ToDoList();

        //instantiate string builder
        StringBuilder actual = new StringBuilder();

        //Add items to test list
        for(int i = 0; i < 10; i++) {
            Item item = new Item();
            item.setDescription("Item "+ (i+1));
            item.setDueDate("2021-07-08");
            item.setStatus(i % 2 == 0);

            testMe.addItem(item);
        }

        //build string of items in the test list, store it in actual
        for(Item item : testMe.getItems()) {
            actual.append(String.format("%s, %s, %s%n", item.getDescription(), item.getDueDate(), item.isStatus()));
        }

        //instantiate expected string builder
        StringBuilder expected = new StringBuilder();

        //Add items to string
        for(int i = 0; i < 10; i++) {
            Item item = new Item();
            item.setDescription("Item "+ (i+1));
            item.setDueDate("2021-07-08");
            item.setStatus(i % 2 == 0);

            //build string of expected items
            expected.append(String.format("%s, %s, %s%n", item.getDescription(), item.getDueDate(), item.isStatus()));
        }

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @DisplayName("Rqmt 11: ToDoList getIncompleteItems: test that a list of incomplete items is returned")
    public void test_that_getIncompleteItems_returns_a_list_of_incomplete_items() {

        ToDoList testMe = new ToDoList();

        ArrayList<Item> expected = new ArrayList<>();

        for(int i = 0; i < 7; i++) {
            Item item = new Item();
            if(i % 2 == 0) {
                item.setDescription("Complete");
                item.setStatus(true);
            } else {
                item.setDescription("Incomplete");
                expected.add(item);
            }
            testMe.addItem(item);
        }

        ArrayList<Item> actual = testMe.getIncompleteItems();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Rqmt 12: ToDoList getCompleteItems: test that a list of completed items is returned")
    public void test_that_getCompleteItems_returns_a_list_of_completed_items() {

        ToDoList testMe = new ToDoList();

        ArrayList<Item> expected = new ArrayList<>();

        for(int i = 0; i < 7; i++) {
            Item item = new Item();
            if(i % 2 == 0) {
                item.setDescription("Complete");
                item.setStatus(true);
                expected.add(item);
            } else {
                item.setDescription("Incomplete");
            }
            testMe.addItem(item);
        }

        ArrayList<Item> actual = testMe.getCompleteItems();

        assertEquals(expected, actual);

    }
}