/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.polymorphismarraylist;

/**
 *
 * @author JHoang2026
 */

//Importing the arrayList
import java.util.*;
public class PolymorphismArrayList {

    public static void main(String[] args) {
        //Creating a new ArrayList for the list of aircrafts
        ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();
        
        //Creating an object for the aircraft class (parent class), and adding it to the ArrayList
        Aircraft myAircraft = new Aircraft(2);
        aircrafts.add(myAircraft);
        
        //Creating an object for the single-engine-plane class (child class), and adding it to the ArrayList
        SingleEnginePlane mySEPlane = new SingleEnginePlane(1, "rotary engine");
        aircrafts.add(mySEPlane);
        
        //Creating an object for the helicopter class (child class of child class), and adding it to the ArrayList
        Helicopter myHeli = new Helicopter(0, "rotary engine", "rotating helicopter blades");
        aircrafts.add(myHeli);
        
        //Printing out the ArrayList
        for(Aircraft aircraft : aircrafts){
            System.out.println(aircraft);
        }
        
    }
}

//Parent class: Aircraft (1 var)
class Aircraft{
    //Creating variable for wings
    int wings;
    
    public Aircraft(){
        wings = 0;
    }
    
    public Aircraft(int inWings){
        wings = inWings;
    }
    
    //Creating setter and getter for # of wings
    public void setWings(int inWings){
        wings = inWings;
    }
    public int getWings(){
        return wings;
    }
    
    //To string prints out # of wings
    public String toString(){
        String result = "";
        result = "Wings: " + getWings() + "\n";
        return result;
    }
}

//Child class of Aircraft: SingleEnginePlane (2 vars)
class SingleEnginePlane extends Aircraft{
    //Adding variable for engine types
    String engineType = "rotary engine"; 
    
    //Calling information from the parent class
    public SingleEnginePlane(int inWings, String inEngine){
        super(inWings);
        engineType = inEngine;
    }
    
    //Creating setter and getter for engineType
    public void setEngineType(String inEngine){
        engineType = inEngine;
    }
    public String getEngineType(){
        return engineType;
    }
    
    //To string prints out information from parent class + engineType
    @Override
    public String toString(){
        String result = "";
        result = super.toString() + "Engine Type: " + getEngineType() + "\n";
        return result;
    }
}

//Child class of SingleEnginePlane: Helicopter (3 vars)
class Helicopter extends SingleEnginePlane{
    //Adding another variable for blade type
    String bladeType = "rotating Helicopter blades";
    
    //Calling information from the parent classes above
    public Helicopter(int inWings, String inEngine, String inBlade){
        super(inWings, inEngine);
        bladeType = inBlade;
    }
    
    //Creating setter and getter for blade type
    public void setBladeType(String inBlade){
        bladeType = inBlade;
    }
    public String getBladeType(){
        return bladeType;
    }
    
    //To string prints out information from previous parent classes + bladeType
    @Override
    public String toString(){
        String result = "";
        result = super.toString() + "Blade Type: " + getBladeType() + "\n";
        return result;
    }
}