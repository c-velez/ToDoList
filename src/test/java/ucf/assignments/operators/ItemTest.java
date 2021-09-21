/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Christopher Velez
 */

package ucf.assignments.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ucf.assignments.Item;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item testItem = new Item();

    @Test
    @DisplayName("Rqmt 7: Item setDescription: Test that set description sets item to expected description")
    public void test_that_setDescription_sets_item_description_to_given_description() {

        testItem.setDescription("This is my test description");

        String actual = testItem.getDescription();

        String expected = "This is my test description";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Rqmt 7: Item setDescription: Test that set description sets item to default when < 1 char")
    public void test_that_setDescription_sets_item_description_to_default_when_input_is_less_than_1_character() {
        testItem.setDescription("");

        String actual = testItem.getDescription();

        String expected = "description";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Rqmt 7: Item setDescription: Test that set description sets item to default when > 256")
    public void test_that_setDescription_sets_item_description_to_default_when_input_is_greater_than_256_characters() {

        testItem.setDescription("A".repeat(257));

        String actual = testItem.getDescription();

        String expected = "description";

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Rqmt 8: Item setDueDate: Test that setDueDate sets date to default when date is not in the proper format")
    public void test_that_setDueDate_sets_date_to_default_when_not_given_in_the_proper_format() {
        testItem.setDueDate("");

        String actual = testItem.getDueDate();

        String expected = "YYYY-MM-DD";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Rqmt 8: Item setDueDate: Test that setDueDate sets date to default for invalid day")
    public void test_that_setDueDate_sets_date_to_default_for_invalid_day() {
        testItem.setDueDate("2021-06-43");

        String actual = testItem.getDueDate();

        String expected = "YYYY-MM-DD";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Rqmt 8: Item setDueDate: Test that setDueDate sets date to default for invalid month")
    public void test_that_setDueDate_sets_date_to_default_for_invalid_month() {
        testItem.setDueDate("2021-13-01");

        String actual = testItem.getDueDate();

        String expected = "YYYY-MM-DD";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Rqmt 8: Item setDueDate: Test that setDueDate sets date to default for invalid month/day combination")
    public void test_that_setDueDate_sets_date_to_default_for_invalid_month_day_combination() {
        testItem.setDueDate("2021-06-31");

        String actual = testItem.getDueDate();

        String expected = "YYYY-MM-DD";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Rqmt 8: Item setDueDate: Test that setDueDate sets date for leap year")
    public void test_that_setDueDate_sets_date_properly_for_leap_year() {
        testItem.setDueDate("2020-02-29");

        String actual = testItem.getDueDate();

        String expected = "2020-02-29";

        assertEquals(expected, actual);
    }

}