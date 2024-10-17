/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.anatomyclassassignment;

/**
 *
 * @author JHoang2026
 */
public class AnatomyClassAssignment {

    public static void main(String[] args) {
        //Prints out car brand, engine power, max speed, and price of specific cars
        //Uses the Car Class and its methods to do so
        //Prints out info for a VW Bug
        String car1 = "VW Bug";
        System.out.println("Car 1: " + car1);
        Car vwbug = new Car();
        vwbug.setBrand("Volkswagen");
        vwbug.setEnginePower(174);
        vwbug.setSpeed(82.5);
        vwbug.setPrice(20875);
        System.out.println(vwbug + "\n");
        
        //Prints out info for a Toyota Prius
        String car2 = "Toyota Prius";
        System.out.println("Car 2: " + car2);
        Car prius = new Car();
        prius.setBrand("Toyota");
        prius.setEnginePower(194);
        prius.setSpeed(112);
        prius.setPrice(29045);
        System.out.println(prius + "\n");
        
        //Prints out info for a BMW i8
        String car3 = "BMW i8";
        System.out.println("Car 3: " + car3);
        Car bmw = new Car();
        bmw.setBrand("BMW");
        bmw.setEnginePower(369);
        bmw.setSpeed(155);
        bmw.setPrice(40999);
        System.out.println(bmw + "\n");
        
        //Prints out info for a Tesla Model 3
        String car4 = "Tesla Model 3";
        System.out.println("Car 4: " + car4);
        Car tesla = new Car();
        tesla.setBrand("Tesla");
        tesla.setEnginePower(510);
        tesla.setSpeed(145);
        tesla.setPrice(40380);
        System.out.println(tesla + "\n");
    }

}
//Creating car class
class Car{
    //setting up private variables
    private String carBrand = "";
    private int enginePower = 0;
    private double maxSpeed = 0.00;
    private double price = 0.00;
    
    //Sets the car brand of the car
    public void setBrand(String inBrand){
        carBrand = inBrand;
    }
    
    //Sets the engine power of the car
    public void setEnginePower(int inEnginePower){
        enginePower = inEnginePower;  
    }
    
    //Sets the max speed of the car
    public void setSpeed(double inSpeed){
        maxSpeed = inSpeed;  
    }
    
    //Sets the price of the car
    public void setPrice(double inPrice){
        price = inPrice;
    }
    
    //Returns the final statement, which includes all the info about the specific vehicle
    public String toString(){
        String result = "";
        result = "Car Brand: " + carBrand + "\n" + 
                "Engine Power: " + enginePower + " HP"+ "\n" + 
                "Max Speed: " + maxSpeed + " MPH" + "\n" + 
                "Price: $" + price;
        return result;
    }

}
        

