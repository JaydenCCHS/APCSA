/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.recursionpascalstriangle;

/**
 *
 * @author JHoang2026
 */

//Importing scanner
import java.util.*;

public class RecursionPascalsTriangle {

    public static void main(String[] args) {
        //Creating the scanner
        Scanner scanner = new Scanner(System.in);
        
        //Giving the user instructions to input the line # they want to see
        System.out.println("Enter which line of the Paschal's Triangle you want to see. (starting with 0)");
        
//Taking the user's input 
        int lineNum = scanner.nextInt();
        System.out.println("You entered: " + lineNum);
        
        //Printing out the line number the user chose
        PascalsTriangle.printTriangle(lineNum);
    }
}

//New class for the Pascal's Triangle
class PascalsTriangle{
    
    //Recursive function to calculate values
    //pos = position
    public static int findNumber(int row, int pos){
        //Return 1 for the first and last digit of the line
        if ((pos == 0) || (pos == row)){
            return 1;
            //Return the sum of two numbers above in the previous row
        } else
            return findNumber(row-1, pos-1) + findNumber(row-1, pos);
    }
    
    //Printing out each number in the correct row and position
    public static void printTriangle(int row){
        for (int p = 0; p <= row; p++) {
            System.out.print(findNumber(row, p) + " ");
        } 
    }
}