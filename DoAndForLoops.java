/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.doandforloops;

/**
 *
 * @author JHoang2026
 */
public class DoAndForLoops {

    public static void main(String[] args) {
        //Setting the CONSTANT for the maximum number of rows
        final int MAX_ROWS = 10;
        //Prints out part "A", which has the stars from 1-10, but shifted to the left
        System.out.println("a.");
        //For each part
        for (int row = 1; row <= MAX_ROWS; row++)
        {
            //Prints the correct number of stars per row
            for (int star = 1; star <= row; star++){
                System.out.print("*");
            }
            //Print new line
            System.out.println();
        }
        
        //Prints out part "B", which has the stars from 1-10, but shifted to the right
        System.out.println("b.");
        //For each part
        for (int row = 1; row <= MAX_ROWS; row++)
        {
            //Prints the correct number of spaces per row
            for (int spaces = MAX_ROWS; spaces > row; spaces--){
                System.out.print(" ");
            }
            //Prints the correct number of stars per row
            for (int star = 1; star <= row; star++){
                System.out.print("*");
            }
            //Print new line
            System.out.println();
        }
        
        //Prints out part "C", which has the stars from 10-1, but shifted to the right
        System.out.println("c.");
        //For each part
        for (int row = 1; row <= MAX_ROWS; row++)
        {
            //Prints the correct number of spaces per row
            for (int spaces = 1; spaces < row; spaces++){
                System.out.print(" ");
            }
            //Prints the correct number of stars per row
            for (int star = MAX_ROWS; star >= row; star--){
                System.out.print("*");
            }
            //Print new line
            System.out.println();
        }
        
        //Prints out part "D", which has the stars from 1-9 and then 9-1, but only prints an odd number of stars that are all centered
        System.out.println("d.");
        //For each part (first half of d)
        for (int row = 1; row <= MAX_ROWS; row = row + 2)
        {
            //Prints the correct number of spaces per row
            for (int spaces = MAX_ROWS; spaces > row + 1; spaces = spaces - 2){
                System.out.print(" ");
            }
            //Prints the correct number of stars per row
            for (int star = 1; star <= row; star++){
                System.out.print("*");
            }
            //Print new line
            System.out.println();
        }
        //For each part (second half of d)
        for (int row = 1; row <= MAX_ROWS; row = row + 2)
        {
            //Prints the correct number of spaces per row
            for (int spaces = 2; spaces < row + 1; spaces = spaces + 2){
                System.out.print(" ");
            }
            //Prints the correct number of stars per row
            for (int star = MAX_ROWS; star > row; star--){
                System.out.print("*");
            }
            //Print new line
            System.out.println();
        }
    }
}
