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
            //Commented below is code for Vehicle and Car
            /*//create a base Vehicle object 9in this case a Boat
            Vehicle v = new Vehicle("Boat", 30.0, 2000, 100000.00);
            //print out the object (toString)
            System.out.println(v);
            
            //now create a child object (a Car)
            Car myCar = new Car("BMW", 200.00, 2, 100.00, 30.0);
            //couple of variables to alter, to change the output a little
            //myCar.setSpoiler(true);
            //myCar.setStereo(true);
            System.out.println(myCar);*/
            
            //child object that inherits Car
            SportCar sc = new SportCar("Ferrari", 200.00, 2, 100.00, 30.0);
            //couple of variables to alter, to change the output a little
            sc.setSpoiler(true);
            //sc.setStereo(true);
            sc.setAirIntakes(true);
            //sc.setDiffusers(true);
            sc.setTurbo(true);
            System.out.println(sc);
            
            //child object that inherits Car
            Hybrid prius = new Hybrid("Toyota Prius", 75.00, 5, 150.00, 40.0);
            //couple of variables to alter, to change the output a little
            //prius.setSpoiler(true);
            //prius.setStereo(true);
            prius.setICE(true);
            prius.setRegenBrake(true);
            System.out.println(prius);
            
            //child object that inherits Vehicle (boat)
            CruiseShip disneyCruises = new CruiseShip("Disney Magic", 21.50, 2713, 83969.00, 1200.0);
            //couple of variables to alter, to change the output a little
            disneyCruises.setFloors(11);
            disneyCruises.setBoulbousBow(true);
            System.out.println(disneyCruises);
            
            //child object that inherits Vehicle (boat)
            Canoe osprey = new Canoe("Osprey Fishing Pro 360", 3, 5, 44.00);
            //couple of variables to alter, to change the output a little
            osprey.setFishing(true);
            osprey.setRacing(false);
            System.out.println(osprey);
            
            //child object that inherits Vehicle (airplane)
            PassengerAirplane boeing = new PassengerAirplane("Boeing 747", 656.00, 416, 398000.00, 100.0);
            //couple of variables to alter, to change the output a little
            boeing.setEngines(4);
            boeing.setDecks(2);
            System.out.println(boeing);
            
            //child object that inherits Vehicle (airplane)
            Jet f16 = new Jet("F-16 Fighting Falcon", 1500.00, 1, 37500.00, 0.7);
            //couple of variables to alter, to change the output a little
            f16.setTurboprop(true);
            f16.setGuns(true);
            System.out.println(f16);
            
            //child object that inherits Vehicle (train)
            Train myTrain = new Train("Shinkansen", 199.00, 1300, 30.00, 70.0);
            //couple of variables to alter, to change the output a little
            myTrain.setCars(16);
            myTrain.setMaglev(true);
            System.out.println(myTrain);
            
            //child object that inherits Vehicle (submarine)
            Submarine mySub = new Submarine("USS Thresher", 38.00, 129, 2370.00, 40.0);
            //couple of variables to alter, to change the output a little
            mySub.setNuclear(false);
            mySub.setSonar(true);
            System.out.println(mySub);
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
//child class that extends Car
class SportCar extends Car{
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
    
    //usesd the super toString, as well as addingnthe new variable to it.
    public String toString(){
        String result = super.toString();
        return  result ;
    }
}
//child class that extends Car
class Hybrid extends Car{
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
//child class that extends Vehicle (boat)
class CruiseShip extends Vehicle{
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
//child class that extends Vehicle (boat)
class Canoe extends Vehicle{
    boolean fishing = false; // if true, the canoe can be used for fishing
    boolean racing = false; // if true, the canoe is used for racing

    public Canoe(String inBrand, double inSpeed, int inPassengers, double inCargo){
        super(inBrand, inSpeed, inPassengers, inCargo); //uses the super constructor
        //tpd = inTPD; //also include the extra variable in the Car constructor
    }
    //another additional variable
    public void setFishing(boolean inFishing){
        fishing = inFishing;
    }
    public boolean getFishing(){
        return fishing;
    }
    //another additional variable
    public void setRacing(boolean inRacing){
        racing = inRacing;
    }
    public boolean getRacing(){
        return  racing;
    }
    //overrides the super getSpeed method
    @Override
    public double getSpeed() {
        if (racing)
            return super.getSpeed() + 2;
        else
            return super.getSpeed();
    }
    //overrides the super getSpeed method
    @Override
    public double getCargoWeight() {
        if (fishing)
            return super.getCargoWeight() + 5;
        else
            return super.getCargoWeight();
    }
    //usesd the super toString, as well as addingnthe new variable to it.
    public String toString(){
        String result = super.toString() + "\n";
                //"TPD (tons of fuel per day):\t" + this.getTPD() + "\n";
        return  result ;
    }
}
//child class that extends Vehicle (airplane)
class PassengerAirplane extends Vehicle{
    int wings = 2;
    double pmpg = 0.0; //has an extra variable, passenger-miles per gallon
    int engines = 0; // number of engines
    int decks = 1; // number of decks(floors) of the plane
    
    public PassengerAirplane(String inBrand, double inSpeed, int inPassengers, double inCargo, double inPMPG){
        super(inBrand, inSpeed, inPassengers, inCargo); //uses the super constructor
        pmpg = inPMPG; //also include the extra variable in the Car constructor
    }
    //another additional variable
    public void setEngines(int inEngines){
        engines = inEngines;
    }

    public int getEngines(){
        return engines;
    }
    //another additional variable
    public void setDecks(int inDecks){
        decks = inDecks;
    }

    public int getDecks(){
        return  decks;
    }
    //overrides the super getSpeed method
    @Override
    public double getSpeed() {
        if (engines > 2)
            return super.getSpeed() + 100;
        else
            return super.getSpeed();
    }

    public void setPMpg(double pmpg) {
        this.pmpg = pmpg;
    }

    public double getPMPG(){
        if(decks > 1)
            return pmpg - (pmpg / 5);
        else
            return pmpg;
    }
    //usesd the super toString, as well as addingnthe new variable to it.
    public String toString(){
        String result = super.toString() +
                "PMPG :\t\t\t" + this.getPMPG() + "\n";
        return  result ;
    }
}
//child class that extends Vehicle (airplane)
class Jet extends Vehicle{
    int wings = 2;
    double mpg = 0.0; //has an extra variable, passenger-miles per gallon
    boolean turboprop = false; // extra variable for turbo engines
    boolean guns = false; //extra variables for weapons
    
    public Jet(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG){
        super(inBrand, inSpeed, inPassengers, inCargo); //uses the super constructor
        mpg = inMPG; //also include the extra variable in the Car constructor
    }
    //another additional variable
    public void setTurboprop(boolean inTurboprop){
        turboprop = inTurboprop;
    }

    public boolean getTurboprop(){
        return turboprop;
    }
    //another additional variable
    public void setGuns(boolean inGuns){
        guns = inGuns;
    }

    public boolean getGuns(){
        return  guns;
    }
    //overrides the super getSpeed method
    @Override
    public double getSpeed() {
        if (turboprop)
            return super.getSpeed() + 100;
        else
            return super.getSpeed();
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public double getMPG(){
        if(guns)
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
//child class that extends Vehicle (train)
class Train extends Vehicle{
    int cars = 1;
    boolean maglev = false; // does the train use magnetic levitation to move
    double mpg = 0.0; //has an extra variable, mpg

    public Train(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG){
        super(inBrand, inSpeed, inPassengers, inCargo); //uses the super constructor
        mpg = inMPG; //also include the extra variable in the Car constructor
    }
    //another additional variable
    public void setCars(int inCars){
        cars = inCars;
    }

    public int getCars(){
        return cars;
    }
    //another additional variable
    public void setMaglev(boolean inMaglev){
        maglev = inMaglev;
    }

    public boolean getMaglev(){
        return  maglev;
    }
    //overrides the super getSpeed method
    @Override
    public double getSpeed() {
        if (maglev)
            return super.getSpeed() + 100;
        else
            return super.getSpeed();
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public double getMPG(){
        if(cars > 10)
            return mpg - (mpg / 4);
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

// Car Class inherits from Vehicle Class (submarine)
class Submarine extends Vehicle{
    boolean nuclear = false;// extra variable for nuclear power
    boolean sonar = false;// extra variable for sonar
    double mpg = 0.0; //has an extra variable, mpg

    public Submarine(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG){
        super(inBrand, inSpeed, inPassengers, inCargo); //uses the super constructor
        mpg = inMPG; //also include the extra variable in the Car constructor
    }
    //another additional variable
    public void setNuclear(boolean inNuclear){
        nuclear = inNuclear;
    }

    public boolean getNuclear(){
        return nuclear;
    }
    //another additional variable
    public void setSonar(boolean inSonar){
        sonar = inSonar;
    }

    public boolean getSonar(){
        return  sonar;
    }
    //overrides the super getSpeed method
    @Override
    public double getSpeed() {
        if (nuclear)
            return super.getSpeed() + 50;
        else
            return super.getSpeed();
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public double getMPG(){
        if(sonar)
            return mpg - (mpg / 20);
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