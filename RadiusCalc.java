/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.radiuscalc;

/**
 *
 * @author JHoang2026
 */
import java.util.Scanner;
//Renamed by project to "RadiusCalc" to fix the error with the next line
public class RadiusCalc {

     /**
     * @param args the command line arguments
     */
    //carry out calculations or circular items
    //such as a circle, a sphere, a cone, a column
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("This program calculates round item numbers such as \n" +
                "1 - Area of a circle (pi r^2)\n" +
                "2 - Volume of a sphere (4/3 pi r^3)\n" +
                "3 - Volume of a cone (pi r^2 h/3)\n" +
                "4 - Volume of a column (pi r^2 h)");
        System.out.println("Type the number for which one you want to calculate");
        int i = s.nextInt();
        if (i == 1){
            cCalc();
        }else if (i == 2){
            sCalc();
        }else if(i == 3){
            cCalc2();
        }else if(i == 4){
            cCalc3();
        }
    }
    //Code for column
    public static void cCalc3(){
        //Changed the System.out.println to say "column" instead of "cone"
        System.out.println("enter the radius of your column, then height of your column");
        //Added new scanner
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        //Added scanner input for height
        int h = s.nextInt();
        double result = Math.PI * Math.pow(r, 2) * h;
        //Added a description to the result for the reader to understand clearly
        System.out.println("Volume of your column: " + result);
    }
    
    //Code for cone
    public static void cCalc2(){
        System.out.println("enter the radius of your cone, then height of your cone");
        //Added new scanner
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int h = s.nextInt();
        //Grouped the original equation together, and then divided all of that by 3
        double result = (Math.PI * Math.pow(r, 2) * h) / 3;
        //Changed what the output is to "result" instead of "r"
        //Added a description to the result for the reader to understand clearly
        System.out.println("Volume of your cone: " + result);
    }
    //Area of circle
    public static void cCalc(){
        System.out.println("enter the radius of your circle");
        //Added new scanner
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        double result = Math.PI * Math.pow(r, 2);
        //Added a description to the result for the reader to understand clearly
        System.out.println("Area of your circle: " + result);
    }
    //Volume of sphere
    public static void sCalc(){
        //Changed the system.out.print to say "sphere" instead of "circle"
        System.out.println("enter the radius of your sphere");
        //Added new scanner
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        //Oringal code has (4/3), which are integers
        //I changed the integers to double to result in correct output (widening conversion)
        double result = (4.0/3.0) * Math.PI * Math.pow(r, 3);
        //Changed what the output is to "result" instead of "r"
        //Added a description to the result for the reader to understand clearly
        System.out.println("Volume of your sphere: " + result);
    }
}
