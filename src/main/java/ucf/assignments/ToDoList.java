/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Christopher Velez
 */

package ucf.assignments;

import java.util.ArrayList;

public class ToDoList {
    private final ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        //add item to Item array list
        items.add(item);
    }

    public void deleteItem(String description) {
        //for each item in the list
        for (Item item : items) {

            //if the given description matches the item description
            if (description.equals(item.getDescription())) {

                //remove the item from the list
                items.remove(item);
                break;
            }
        }
    }

    public void deleteAllItems() {
        items.clear();
    }

    public ArrayList<Item> getItems() {
        //return arraylist of items
        return items;
    }

    public Item getSingleItem(String description) {
        //instantiate item object
        Item requestedItem = new Item();

        //for each item in the array list
        for (Item item : items) {

            //if item is the same as item description
            if (description.equals(item.getDescription())) {

                //store the item in the requestedItem
                requestedItem = item;
            }
        }

        //return item
        return requestedItem;
    }

    public ArrayList<Item> getCompleteItems() {
        //declare completed array list
        ArrayList<Item> completedItems = new ArrayList<>();

        //for each item in the list
        for (Item item : items) {

            //if isStatus
            if (item.isStatus()) {

                //add item to completed array
                completedItems.add(item);
            }
        }

        //return completed array list
        return completedItems;
    }

    public ArrayList<Item> getIncompleteItems() {
        //declare incomplete array list
        ArrayList<Item> incompleteItems = new ArrayList<>();

        //for each item in the current list
        for (Item item : items) {

            //if not isStatus
            if (!item.isStatus()) {

                //add item to incomplete array list
                incompleteItems.add(item);
            }
        }

        //return incomplete array list
        return incompleteItems;
    }

}
