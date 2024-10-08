/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numberformat;

/**
 *
 * @author JHoang2026
 */




import java.util.*;
import java.text.*;
public class NumberFormatAssignment {

    public static void main(String[] args) {
        //Setting up a scanner that will be used throughout the program
        //User inputs a number of studens at a school and the number of girls attending there
        //Code prints out the percent of girls and percent of boy at the school
        Scanner scan = new Scanner(System.in);
        int totalStudents;
        System.out.println("Enter the amount of students at a school.");
        totalStudents = scan.nextInt();
        System.out.println(totalStudents + " total students");
        int girls;
        System.out.println("Enter the amount of girls at the school.");
        girls = scan.nextInt();
        System.out.println(girls + " girls");
        int boys = totalStudents - girls;
        System.out.println(boys + " boys");
        double girlsPercent = ((double)girls / totalStudents);
        double boysPercent = ((double)boys / totalStudents);
        NumberFormat fmt1 = NumberFormat.getPercentInstance();
        NumberFormat fmt2 = NumberFormat.getPercentInstance();
        System.out.println("Percent of students that are girls: " + fmt1.format(girlsPercent));
        System.out.println("Percent of students that are boys: " + fmt1.format(boysPercent));
        
        
        //User inputs an amount of money in USD
        //Code converts this value in USD to GBP (British Pounds)
        System.out.println("Enter an amount of money in USD.");
        double totalCost;
        totalCost = scan.nextDouble();
        double gBP = totalCost * 0.83;
        NumberFormat BP = NumberFormat.getCurrencyInstance(Locale.UK);
        System.out.println("The exchange rate from USD to GBP is 0.83 pence per $. Your amount in GBP is: " + BP.format(gBP));
        
        
        //User inputs a number 0-15. This determines the number of decimal places
        //Code will round Pi to the number of decimal places inputed by the user
        System.out.println("Enter the amount of decimal places you want to round to (0-15).");
        int decimalPlaces = scan.nextInt();
        DecimalFormat fmt3 = new DecimalFormat();
        
        if(decimalPlaces == 0){
            fmt3 = new DecimalFormat("0");
        } else if (decimalPlaces == 1){
            fmt3 = new DecimalFormat("0.#");
        } else if (decimalPlaces == 2){
            fmt3 = new DecimalFormat("0.##");
        } else if (decimalPlaces == 3){
            fmt3 = new DecimalFormat("0.###");
        } else if (decimalPlaces == 4){
            fmt3 = new DecimalFormat("0.####");
        } else if (decimalPlaces == 5){
            fmt3 = new DecimalFormat("0.#####");
        } else if (decimalPlaces == 6){
            fmt3 = new DecimalFormat("0.######");
        } else if (decimalPlaces == 7){
            fmt3 = new DecimalFormat("0.#######");
        } else if (decimalPlaces == 8){
            fmt3 = new DecimalFormat("0.########");
        } else if (decimalPlaces == 9){
            fmt3 = new DecimalFormat("0.#########");
        } else if (decimalPlaces == 10){
            fmt3 = new DecimalFormat("0.##########");
        } else if (decimalPlaces == 11){
            fmt3 = new DecimalFormat("0.###########");
        } else if (decimalPlaces == 12){
            fmt3 = new DecimalFormat("0.############");
        } else if (decimalPlaces == 13){
            fmt3 = new DecimalFormat("0.#############");
        } else if (decimalPlaces == 14){
            fmt3 = new DecimalFormat("0.##############");
        } else if (decimalPlaces == 15){
            fmt3 = new DecimalFormat("0.###############");
        }
        
        double finalPi = roundAvoid(Math.PI, decimalPlaces);
        System.out.println(fmt3.format(finalPi));
        
        
        //Generates a random number from 100000000 to 999e18
        //The code will rewrite the number as a decimal, with no scientific notation.
        System.out.println("Below is a random number between 100,000,000 to 999e18 in decimal form (no scientific notation).");
        Random generator = new Random();
        double bigNumber = generator.nextDouble(100000000, 999e18 + 1);
        //System.out.println(bigNumber);
        DecimalFormat df = new DecimalFormat("#,###.######");
        System.out.println(df.format(bigNumber));
        
        
        
    }
   //Function for roundAvoid code
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

}
