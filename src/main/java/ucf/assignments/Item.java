/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Christopher Velez
 */

package ucf.assignments;

public class Item {
    private String description;
    private String dueDate;
    private boolean status;

    public Item() {
        this.description = "description";
        this.dueDate = "YYYY-MM-DD";
        this.status = false;
    }

    public void setDescription(String description) {
        //if description is at least one character and no more than 256 characters
        if (description.length() < 1) {
            //set to default
            this.description = "description";
        } else if (description.length() > 256) {
            //set to message that the description is too long
            this.description = "must be less than 256 characters";
        }
        //else set current item description to description
        else {
            this.description = description;
        }
    }

    public String getDescription() {
        //return current item description
        return description;
    }

    public void setDueDate(String dueDate) {

        //if input matches the prescribed format
        if (dueDate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            //check to see if it exists within the Gregorian Calendar
            if (DateOperator.isDate(dueDate)) {
                //set current item dueDate to given dueDate
                this.dueDate = dueDate;
                //otherwise
            } else {
                //set current item dueDate to YYYY-MM-DD
                this.dueDate = "YYYY-MM-DD";
            }
        }
    }

    public String getDueDate() {
        //return current item dueDate
        return dueDate;
    }

    public void setStatus(boolean status) {
        //set current item status to given status
        this.status = status;
    }

    public boolean isStatus() {
        //return current item status
        return status;
    }

}
