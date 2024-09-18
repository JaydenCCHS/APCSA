/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stringobjectsassignment;

/**
 *
 * @author JHoang2026
 */
public class StringObjectsAssignment {

    public static void main(String[] args) {
        
        //Creating a new string. The intial value of the string variable is set to "Jayden Hoang", which is my name
        String strMyName = new String("Jayden Hoang");
        //The comment beneath this line is to test if the string prints correctly. It is not necessary for the assignment
        //System.out.println(strMyName);
        
        //Printing out "My name is "Jayden Hoang"" by using the strMyName variable
        System.out.println("My name is \"" + strMyName + "\"");
        //Printing out "My name length is "12"" by using the strMyName.length() tool. This code finds the length of my name and prints it.  
        System.out.println("My name length is \"" + strMyName.length() + "\"");
        //Printing out "My name in upper case is "JAYDEN HOANG"" by using the strMyName.toUpperCase() tool. This code sets all of the letters in my name to upper case and prints it.  
        System.out.println("My name in upper case is \"" + strMyName.toUpperCase() + "\"");
        //Printing out "My name in lower case is "jayden hoang"" by using the strMyName.toLowerCase() tool. This code sets all of the letters in my name to lower case and prints it.  
        System.out.println("My name in lower case is \"" + strMyName.toLowerCase() + "\"");
        //Printing out "The first letter in my name is "J"" by using the strMyName.charAt() tool. In the parenthesis, I put "0" because I am trying to find the first letter (0th character) of my name. This code finds the first letter in my name and prints it. 
        System.out.println("The first letter in my name is \"" + strMyName.charAt(0) + "\"");
        //Printing out "The last letter in my name is "g"" by using the strMyName.charAt() tool. In the parenthesis, I put "11" because I am trying to find the last letter (12th charater) of my name. This code finds the last letter in my name and prints it.
        System.out.println("The last letter in my name is \"" + strMyName.charAt(11) + "\"");
        //Printing out "The first letter in my name is 6" by using the strMyName.indexOf(" ") tool. In the parenthesis, I put "" "" because I am trying to find the character " " (space). This code finds "" "" character, find its location, and and prints the information.
        System.out.println("The first letter in my name is " + strMyName.indexOf(" "));
    }
}
