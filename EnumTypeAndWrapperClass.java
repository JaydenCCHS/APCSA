/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.enumtypeandwrapperclass;

/**
 *
 * @author JHoang2026
 */

import java.util.Scanner;
import java.lang.*;
public class EnumTypeAndWrapperClass {

    public static void main(String[] args) {
        
        
        enum weekDays {Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday};
        System.out.println("Days of the week:" + "\n" + 
                            "Sunday: " + (weekDays.Sunday.ordinal()+1) + "\n" + 
                            "Monday: " + (weekDays.Monday.ordinal()+1) + "\n" + 
                            "Tuesday: " + (weekDays.Tuesday.ordinal()+1) + "\n" +
                            "Wednesday: " + (weekDays.Wednesday.ordinal()+1) + "\n" +
                            "Thursday: " + (weekDays.Thursday.ordinal()+1) + "\n" +
                            "Friday: " + (weekDays.Friday.ordinal()+1) + "\n" +
                            "Saturday: " + (weekDays.Saturday.ordinal()+1) + "\n");
        
        
        enum months {January, February, March, April, May, June, July, August, September, October, November, December};
        System.out.println("Months of the year: " + "\n" + 
                            "January: " + (months.January.ordinal()+1) + "\n" + 
                            "February: " + (months.February.ordinal()+1) + "\n" + 
                            "March: " + (months.March.ordinal()+1) + "\n" + 
                            "April: " + (months.April.ordinal()+1) + "\n" + 
                            "May: " + (months.May.ordinal()+1) + "\n" + 
                            "June: " + (months.June.ordinal()+1) + "\n" + 
                            "July: " + (months.July.ordinal()+1) + "\n" + 
                            "August: " + (months.August.ordinal()+1) + "\n" + 
                            "September: " + (months.September.ordinal()+1) + "\n" + 
                            "October: " + (months.October.ordinal()+1) + "\n" + 
                            "November: " + (months.November.ordinal()+1) + "\n" + 
                            "December: " + (months.December.ordinal()+1) + "\n");
        
        //Sets up a scanner to take in user inputs
        //User will input their school email
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your school email (include the year part)");
        String email = scan.nextLine();
        System.out.println(email);
        String num = email.substring((email.length()-4), email.length());
        //Parsing last 4 characters of input to convert the string into an integer of the year
        Integer year = Integer.parseInt(num);
        System.out.println("Your graduation year: " + year);
        System.out.println("The year after your graduation year: " + (year + 1));
        //Converts the graduation year into binary, and prints it
        String yearInBinary = Integer.toBinaryString(year);
        System.out.println("In computer language, you graduate in: " + yearInBinary);
        
        
    }
}
