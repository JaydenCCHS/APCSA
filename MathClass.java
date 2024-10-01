/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mathclass;

/**
 *
 * @author JHoang2026
 */

//Importing libraries
import java.util.Random;
import java.util.Scanner;
public class MathClass {

    public static void main(String[] args) {
        //Setting up the random number generator
        Random generator = new Random();
        //Generates a random number between 0-90
        int num1 = generator.nextInt(91);
        //Finds the sine value of the generated number
        double sinValue = Math.sin(num1);
        //Rounds the sine value to 3 decimal places
        sinValue = roundAvoid(sinValue, 3);
        //Finds the cosine value of the generated number
        double cosValue = Math.cos(num1);
        //Rounds the cosine value to 3 decimal places
        cosValue = roundAvoid(cosValue, 3);
        //Finds the tangent value of the generated number
        double tanValue = Math.tan(num1);
        //Rounds the tangent value to 3 decimal places
        tanValue = roundAvoid(tanValue, 3);
        //Prints out random number and its sine, cosine, and tangent values
        System.out.println("Number: " + num1 + "\n" + "Sine: " + sinValue + " Cosine: " + cosValue + " Tangent: " + tanValue);

        //Generates random real number from 1.0-20.0 for the radius of the circle
        //Calculates the area and volume, as well as rounding both values to 3 decimal places
        double radius = generator.nextDouble(20.0) + 1.0;
        radius = roundAvoid(radius, 1);
        double circleArea = radius * radius * Math.PI;
        circleArea = roundAvoid(circleArea, 3);
        double circleVolume = (4.0/3.0) * Math.PI * (radius * radius * radius);
        circleVolume = roundAvoid(circleVolume, 3);
        //Print out radius, area of the circle, and volume of the sphere (all rounded values)
        System.out.println("Radius: " + radius + "\n" + "Area of the circle: " + circleArea + "\n" + "Volume of the sphere: " + circleVolume);
        
        //Generates random number from 1000.0-100,000,000.0
        //Finds square root, natural logarithm, and log10 value of the random number
        //Rounds all values to 5 decimal places
        double bigNumber = generator.nextDouble(99990001.0) + 1000.0;
        bigNumber = roundAvoid(bigNumber, 5);
        double sqrtBigNumber = Math.sqrt(bigNumber);
        sqrtBigNumber = roundAvoid(sqrtBigNumber, 5);
        double natLogBigNumber = Math.log(bigNumber);
        natLogBigNumber = roundAvoid(natLogBigNumber, 5);
        double log10BigNumber = Math.log10(bigNumber);
        log10BigNumber = roundAvoid(log10BigNumber, 5);
        //Prints big number, its square root, natural log, and log10 values, rounded to 5 decimal places
        System.out.println("Number: " + bigNumber + "\n" + "Square root: " + sqrtBigNumber + "\n" + "Natural log: " + natLogBigNumber + "\n" + "Log10: " + log10BigNumber);
        
        //Uses the random number from above
        //Calculating the mass needed to generate E or energy with the equation E = mc^2
        //E = bigNumber (big number from previous problem)
        //C = the speed of light in meters/second
        //Calculates mass in grams to generate E and rounds it to a user defined number of decimal places
        double c = 299792458;
        double cSquared = c * c;
        double grams = bigNumber / cSquared;
        System.out.println("Grams before rounding: " + grams);
        //Setting up a scanner to take in user inputs for decimal places, real numbers, integers, etc.
        Scanner scan = new Scanner(System.in);
        int decimalPlaces = 0;
        System.out.println("Enter a number of decimal places: ");
        decimalPlaces = scan.nextInt();
        double roundedGrams  = roundAvoid(grams, decimalPlaces);
        //Prints rounded value of grams
        System.out.println("Mass in grams rounded to a chosen number of decimal places: " + roundedGrams);
        
        //Uses user given numbers to find the power of the user's inputs
        //Takes the user's first input and raises to the power of the user's second input
        //Also, rounds the value to the user's defined number of decimal places
        System.out.println("Enter a real number value");
        double realValue = scan.nextDouble();
        System.out.println("Enter an integer value for the power");
        int integerValue = scan.nextInt();
        double finalValue = Math.pow(realValue, integerValue);
        System.out.println("Enter the amount of decimal places to round to");
        int decimalPlaces2 = scan.nextInt();
        finalValue = roundAvoid(finalValue, decimalPlaces2);
        //Prints final rounded value
        System.out.println("The real number raised to the power of the integer value is: " + finalValue);
        
        
     
        
    }
    
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    
}
