/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.classinheritance;

/**
 *
 * @author JHoang2026
 */
import java.util.*;
public class ClassInheritance {

    public static void main(String[] args){
            //create a base Vehicle object 9in this case a Boat
            Vehicle v = new Vehicle("Boat", 30.0, 2000, 100000.00);
            //print out the object (toString)
            System.out.println(v);
            
            //now create a child object (a Car)
            Car myCar = new Car("BMW", 200.00, 2, 100.00, 30.0);
            //couple of variables to alter, to change the output a little
            //myCar.setSpoiler(true);
            //myCar.setStereo(true);
            System.out.println(myCar);
            
            SportCar sc = new SportCar("Ferrari", 200.00, 2, 100.00, 30.0);
            //couple of variables to alter, to change the output a little
            //sc.setSpoiler(true);
            //sc.setStereo(true);
            //sc.setAirIntakes(true);
            //sc.setDiffusers(true);
            //sc.setTurbo(true);
            System.out.println(sc);
            
            Hybrid prius = new Hybrid("Toyota Prius", 200.00, 2, 100.00, 30.0);
            //couple of variables to alter, to change the output a little
            //prius.setSpoiler(true);
            //prius.setStereo(true);
            prius.setICE(true);
            prius.setRegenBrake(true);
            System.out.println(prius);
            
            //now create a child object (a Car)
            CruiseShip disneyCruises = new CruiseShip("Disney Magic", 21.50, 2713, 83969.00, 1200.0);
            //couple of variables to alter, to change the output a little
            disneyCruises.setFloors(11);
            disneyCruises.setBoulbousBow(true);
            System.out.println(disneyCruises);
    }
}

// The Base Vehicle Class, implements the Speedometer interface
class Vehicle implements Speedometer{
    //base (Class wide) variables
    protected String brandName = "";
    protected double speed = 0.0;
    protected int passengers = 0;
    protected double cargoWeight = 0.0;
    //Base default constructor 
    public Vehicle(){
        brandName = "";
        speed = 0.0;
        passengers = 0;
        cargoWeight = 0.0;
    }

    public Vehicle(String inBrand, double inSpeed, int inPassengers, double inCargo){
        brandName = inBrand;
        speed = inSpeed;
        passengers = inPassengers;
        cargoWeight = inCargo;
    }

    //getters and setters
    public Vehicle(String inBrand){
        brandName = inBrand;
    }

    public String getBrand(){
        return brandName;
    }

    public  void setBrandName(String inBrand){
        brandName = inBrand;
    }

    public double getSpeed(){
        return  speed;
    }

    public void setSpeed(double inSpeed){
        speed = inSpeed;
    }

    public int getPassengers(){
        return  passengers;
    }

    public void setPassengers(int inPassengers){
        speed = inPassengers;
    }

    public double getCargoWeight(){
        return  cargoWeight;
    }

    public void setCargoWeight(double inCargoWeight){
        cargoWeight = inCargoWeight;
    }

    //Base toString
    public String toString(){
        String result = "";
        result = "Brand: \t\t\t" + getBrand() + "\n" +
                "Speed (mph): \t" + getSpeed() + "\n" +
                "Passengers: \t" + getPassengers() + "\n" +
                "Cargo (lbs): \t" + getCargoWeight() + "\n";
        return result;
    }
}
//the Speedometer interface to show the speed of any vehicle in the same way
interface Speedometer{
    public void setSpeed(double inSpeed);
    public double getSpeed();
 }


// Car Class inherits from Vehicle Class
class Car extends Vehicle{
    int wheels = 4;
    String color = "White";
    boolean spoiler = false;
    boolean stereo = false;
    double mpg = 0.0; //has an extra variable, mpg

    public Car(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG){
        super(inBrand, inSpeed, inPassengers, inCargo); //uses the super constructor
        mpg = inMPG; //also include the extra variable in the Car constructor
    }
    //another additional variable
    public void setSpoiler(boolean inSpoiler){
        spoiler = inSpoiler;
    }

    public boolean getSpoiler(){
        return spoiler;
    }
    //another additional variable
    public void setStereo(boolean inStereo){
        stereo = inStereo;
    }

    public boolean getStereo(){
        return  stereo;
    }
    //overrides the super getSpeed method
    @Override
    public double getSpeed() {
        if (spoiler)
            return super.getSpeed() + 20;
        else
            return super.getSpeed();
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public double getMPG(){
        if(stereo)
            return mpg - (mpg / 10);
        else
            return mpg;
    }
    //usesd the super toString, as well as addingnthe new variable to it.
    public String toString(){
        String result = super.toString() +
                "MPG :\t\t\t" + this.getMPG() + "\n";
        return  result ;
    }
}

class SportCar extends Car{
    /*int wheels = 4;
    String color = "White";
    boolean spoiler = false;
    boolean stereo = false;
    double mpg = 0.0; //has an extra variable, mpg*/
    boolean airIntakes = false; //if true, + 10 speed
    boolean diffusers = false; //if true, + 10 speed
    boolean turbo = false; //if true, + 30 speed
    
    

    public SportCar(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG){
        super(inBrand, inSpeed, inPassengers, inCargo, inMPG); //uses the super constructor
        
        //mpg = inMPG; //also include the extra variable in the Car constructor
    }
    //another additional variable
    public void setAirIntakes(boolean inAirIntakes){
        airIntakes = inAirIntakes;
    }
    public boolean getAirIntakes(){
        return airIntakes;
    }
    //another additional variable
    public void setDiffusers(boolean inDiffusers){
        diffusers = inDiffusers;
    }
    public boolean getDiffusers(){
        return  diffusers;
    }
    //another additional variable
    public void setTurbo(boolean inTurbo){
        turbo = inTurbo;
    }
    public boolean getTurbo(){
        return  turbo;
    }
    //overrides the super getSpeed method
    @Override
    public double getSpeed() {
        if (airIntakes){
            if (diffusers){
                if (turbo){
                    return super.getSpeed() + 50;
                }else
                    return super.getSpeed() + 20;
            }else{
                if (turbo){
                    return super.getSpeed() + 40;
                }else
                    return super.getSpeed() + 10;
            }
        }else{
            if (diffusers){
                if (turbo){
                    return super.getSpeed() + 40;
                }else
                    return super.getSpeed() + 10;
            }else{
                if (turbo){
                    return super.getSpeed() + 30;
                }else
                    return super.getSpeed();
            }
        }
    }
    /*public void setMpg(double mpg) {
        this.mpg = mpg;
    }
    public double getMPG(){
        if(stereo)
            return mpg - (mpg / 10);
        else
            return mpg;
    }*/
    //usesd the super toString, as well as addingnthe new variable to it.
    public String toString(){
        String result = super.toString();
        return  result ;
    }
}

class Hybrid extends Car{
    /*int wheels = 4;
    String color = "White";
    boolean spoiler = false;
    boolean stereo = false;
    double mpg = 0.0; //has an extra variable, mpg*/
    //boolean airIntakes = false; //if true, + 10 speed
    //boolean diffusers = false; //if true, + 10 speed
    //boolean turbo = false; //if true, + 30 speed
    boolean ICE = false; // ICE = internal combustion engine
    boolean regenBrake = false; // regenerative braking
    

    public Hybrid(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG){
        super(inBrand, inSpeed, inPassengers, inCargo, inMPG); //uses the super constructor
        
        //mpg = inMPG; //also include the extra variable in the Car constructor
    }
    //another additional variable
    public void setICE(boolean inICE){
        ICE = inICE;
    }
    public boolean getICE(){
        return ICE;
    }
    //another additional variable
    public void setRegenBrake(boolean inRegenBrake){
        regenBrake = inRegenBrake;
    }
    public boolean getRegenBrake(){
        return  regenBrake;
    }
    //overrides the super getSpeed method
    @Override
    /*public double getSpeed() {
        if (airIntakes){
            if (diffusers){
                if (turbo){
                    return super.getSpeed() + 50;
                }else
                    return super.getSpeed() + 20;
            }else{
                if (turbo){
                    return super.getSpeed() + 40;
                }else
                    return super.getSpeed() + 10;
            }
        }else{
            if (diffusers){
                if (turbo){
                    return super.getSpeed() + 40;
                }else
                    return super.getSpeed() + 10;
            }else{
                if (turbo){
                    return super.getSpeed() + 30;
                }else
                    return super.getSpeed();
            }
        }
    }*/
    public void setMpg(double mpg) {
        this.mpg = mpg;
    }
    public double getMPG(){
        if(ICE){
            if (regenBrake){
                return mpg + (mpg / 2);
            }else{
                return mpg + (mpg / 4);
            }
        }else{
            if (regenBrake){
                return mpg + (mpg / 4);
            }else{
                return mpg;
            }
        }
    }
    //usesd the super toString, as well as addingnthe new variable to it.
    public String toString(){
        String result = super.toString();
        return  result ;
    }
}

class CruiseShip extends Vehicle{
    /*int wheels = 4;
    String color = "White";
    boolean spoiler = false;
    boolean stereo = false;
    double mpg = 0.0; //has an extra variable, mpg*/
    double tpd = 0.0; //has an extra variable, tons of fuel per day
    int floors = 0; // more floors = more tpd
    boolean boulbousBow = false; //if true, ship goes faster

    public CruiseShip(String inBrand, double inSpeed, int inPassengers, double inCargo, double inTPD){
        super(inBrand, inSpeed, inPassengers, inCargo); //uses the super constructor
        tpd = inTPD; //also include the extra variable in the Car constructor
    }
    //another additional variable
    public void setFloors(int inFloors){
        floors = inFloors;
    }
    public int getFloors(){
        return floors;
    }
    //another additional variable
    public void setBoulbousBow(boolean inBoulbousBow){
        boulbousBow = inBoulbousBow;
    }
    public boolean getBoulbousBow(){
        return  boulbousBow;
    }
    //overrides the super getSpeed method
    @Override
    public double getSpeed() {
        if (boulbousBow)
            return super.getSpeed() + 20;
        else
            return super.getSpeed();
    }
    public void setTPD(double tpd){
        this.tpd = tpd;
    }
    public double getTPD(){
        if(floors >= 10)
            return tpd + (tpd / 10);
        else
            return tpd;
    }
    //usesd the super toString, as well as addingnthe new variable to it.
    public String toString(){
        String result = super.toString() +
                "TPD (tons of fuel per day):\t" + this.getTPD() + "\n";
        return  result ;
    }
}

/*class Canoe extends Vehicle{
    int wheels = 4;
    String color = "White";
    boolean spoiler = false;
    boolean stereo = false;
    double mpg = 0.0; //has an extra variable, mpg
    double tpd = 0.0; //has an extra variable, tons of fuel per day
    int floors = 0; // more floors = more tpd
    boolean boulbousBow = false; //if true, ship goes faster

    public CruiseShip(String inBrand, double inSpeed, int inPassengers, double inCargo, double inTPD){
        super(inBrand, inSpeed, inPassengers, inCargo); //uses the super constructor
        tpd = inTPD; //also include the extra variable in the Car constructor
    }
    //another additional variable
    public void setFloors(int inFloors){
        floors = inFloors;
    }
    public int getFloors(){
        return floors;
    }
    //another additional variable
    public void setBoulbousBow(boolean inBoulbousBow){
        boulbousBow = inBoulbousBow;
    }
    public boolean getBoulbousBow(){
        return  boulbousBow;
    }
    //overrides the super getSpeed method
    @Override
    public double getSpeed() {
        if (boulbousBow)
            return super.getSpeed() + 20;
        else
            return super.getSpeed();
    }
    public void setTPD(double tpd){
        this.tpd = tpd;
    }
    public double getTPD(){
        if(floors >= 10)
            return tpd + (tpd / 10);
        else
            return tpd;
    }
    //usesd the super toString, as well as addingnthe new variable to it.
    public String toString(){
        String result = super.toString() +
                "TPD (tons of fuel per day):\t" + this.getTPD() + "\n";
        return  result ;
    }
}
*/
