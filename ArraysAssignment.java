/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arraysassignment;

/**
 *
 * @author JHoang2026
 */
import java.util.Random;

public class ArraysAssignment {

    public static void main(String[] args) {
        //Creating an array and initializing it with the 7 weekdays
        String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        System.out.println("Here are the 7 days of the week:");
        //Having a loop that prints each day of the week, 1 day per row
        for(int i = 0; i < weekDays.length; i++){
            System.out.println(weekDays[i]);
        }
        
        //Creating a new line
        System.out.println();
        System.out.println("Here are the 5 weekdays (not Sunday or Saturday):");
        //Creating a new temporary array
        String[] temp;
        //Resizing the array to only 5 items, for the 5 week days (not Sunday or Saturday)
        temp = new String[5];
        //Copying the elements of the old array into the new array
        for(int j = 0; j < temp.length; j++){
            //Setting up the temporary list to equal to the elements of the original list, but only elements 1-5
            temp[j] = weekDays[j+1];
            //Changing the original array so that the first element is now "Monday" and the last element is now "Friday"
            weekDays[j] = temp[j];
            //Prints out the original array that is now resized
            System.out.println(weekDays[j]);
        }
        
        //Code for shuffled list, does not work
        /*System.out.println();
        Random rand = new Random();
        String[] tempRnd;
        tempRnd = new String[5];
        for(int p = weekDays.length-1; p > 0; p--){
            int rndInt = rand.nextInt(p+1);
            tempRnd[p] = weekDays[p];
            weekDays[p] = tempRnd[rndInt];
            weekDays[rndInt] = tempRnd[p];
            System.out.println(weekDays[p]);
        }
        
        String[] shuffledDays = {};*/
    }
}
