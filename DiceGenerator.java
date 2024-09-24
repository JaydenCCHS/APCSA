/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dicegenerator;

/**
 *
 * @author JHoang2026
 */

//Importing libraries for Random and Scanner, which are part of the java.util package
import java.util.Random;
import java.util.Scanner;
public class DiceGenerator {

    public static void main(String[] args) {
        //Declaring scanner        
        Scanner scan = new Scanner(System.in);
        //Creating a string variable for the user's input
        String strIn = "";
        //Printing instructions or guide for the user to follow
        System.out.println("To roll the dice, enter the letter \"" + "r" + "\"");
        //Creating a loop so that the code continues to run after "r" is entered
        //Code will close when user enters "-1"
        while (!strIn.equals("-1")){
            strIn = scan.nextLine();
            
            //Declaring random number generator
            Random generator = new Random();
            //Making variable for random number
            int random;
            //The variable stores a random number between 0-5
            random = generator.nextInt(6);
            //The variable equals itself plus 1; this changes the values from 0-5 to 1-6
            random = random + 1;
            //Prints out the random number of the dice roll
            System.out.println("You rolled a " + random);

        }
        
    }
}
