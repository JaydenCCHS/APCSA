/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.randomnumberproject;

/**
 *
 * @author JHoang2026
 */

import java.util.Random;
import java.util.Scanner;
public class RandomNumberProject {

    public static void main(String[] args) {
        //Declaring scanner
        Scanner scan = new Scanner(System.in);
        //Making a variable for user's inputs
        String strIn = "";
        //If user enters p, code will run; enter -1 to escape
        System.out.println("Enter the letter \"" + "p" + "\" to generate a new number.");
        //This is a while loop, as long as the user doesn't enter "-1", code will run when user enters something (such as p)
        while (!strIn.equals("-1")){
            strIn = scan.nextLine();
            
            //Declaring random number generator
            Random generator = new Random();
            //Creating first 3 digits for the phone number
            //Declaring integers for digits 1-3
            int num1;
            int num2;
            int num3;
            //Giving a random number 0-7 to each digit
            num1 = generator.nextInt(8);
            num2 = generator.nextInt(8);
            num3 = generator.nextInt(8);
        
            //Creating next 3 digits for the phone number
            //Declaring integers for digits 4-6
            int num4;
            int num5;
            int num6;
            //Giving a random number for each digit so that the number doesn't surpass 655
            num4 = generator.nextInt(7);
            num5 = generator.nextInt(6);
            num6 = generator.nextInt(6);
        
            //Creating last 4 dgits for the phone number
            //Declaring integers for digits 7-10
            int num7;
            int num8;
            int num9;
            int num10;
            //Giving a random number 0-9 for each digit for the last 4 digits of the number
            num7 = generator.nextInt(10);
            num8 = generator.nextInt(10);
            num9 = generator.nextInt(10);
            num10 = generator.nextInt(10);
        
            //Printing out the phone number. 
            System.out.println("Phone Number: " + num1 + num2 + num3 + "-" + num4 + num5 + num6 + "-" + num7 + num8 + num9 + num10);
        
        }
        
    }
}
