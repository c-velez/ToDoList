/*
 * UCF COP3330 Summer 2021 Assignment 4 Solution
 * Copyright 2021 Christopher Velez
 */

package ucf.assignments;

public class DateOperator {

    public static boolean isDate(String date) {
        String[] splitDate = date.split("-");

        int year = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int day = Integer.parseInt(splitDate[2]);

        //if month is between 01 and 12
        if (month >= 1 && month <= 12) {
            //if month is february
            if (month == 2) {
                //if the year is a leap year
                if (isLeapYear(year)) {
                    //if day is > 29
                    //it is not a valid date
                    return day <= 29;
                } else {
                    //else if day is > 28
                    //it is not a valid date
                    return day <= 28;
                }
            }
            //else if month is April, June, September, or November
            else if (month == 4 || month == 6 || month == 9 || month == 11) {
                //if day > 30
                //it is not a valid date
                return day <= 30;
            } else {
                //if day > 31
                //it is not a valid date
                //else it is a valid date
                return day <= 31;
            }
        } else {
            //month is not in the correct range
            return false;
        }
    }

    private static boolean isLeapYear(int year) {
        //if the year is not divisible by 4
        if (year % 4 != 0) {
            //it is not a leap year
            return false;

            //otherwise, if the the year is not divisible by 100
        } else if (year % 100 != 0) {
            //it is a leap year
            return true;

            //otherwise, if the year is not divisible by 400
            //it is not a leap year
        } else return year % 400 == 0;
    }

}
