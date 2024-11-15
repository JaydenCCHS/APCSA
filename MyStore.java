/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mystore;

/**
 *
 * @author JHoang2026
 */
//Importing scanner
import java.util.Scanner;
public class MyStore {

    public static void main(String[] args) {
        //Establishing a CONSTANT, which represents the budget
        final double MAX_BUDGET = 250.00;
        //Declaring more variables, such as totalCost and budgetLeft
        //These are useful for the customer to know so that they won't go over budget
        double totalCost = 0.00;
        double budgetLeft = MAX_BUDGET - totalCost;
        int count = 0;
        
        //Creating variables for each item in the store
        //Sets name (String) and price (double) of each item
        Item tShirt = new Item();
        tShirt.setItemName("T Shirt");
        tShirt.setPrice(29.99);
        
        Item shoes = new Item();
        shoes.setItemName("Shoes");
        shoes.setPrice(125.99);
        
        Item jeans = new Item();
        jeans.setItemName("Jeans");
        jeans.setPrice(60.99);
        
        Item jacket = new Item();
        jacket.setItemName("Jacket");
        jacket.setPrice(250.00);
        
        Item hat = new Item();
        hat.setItemName("Hat");
        hat.setPrice(25.99);
        
        Item shorts = new Item();
        shorts.setItemName("Shorts");
        shorts.setPrice(75.99);
        
        Item blouse = new Item();
        blouse.setItemName("Blouse");
        blouse.setPrice(88.99);
        
        //A while loop runs so that the user can "buy" as many items as they want
        //The loop contains a scanner that scans for user inputs
        System.out.println("Items to buy: T Shirt, Shoes, Jeans, Jacket, Hat, Shorts, & Blouse");
        while (true){
            Scanner scan = new Scanner(System.in);
            String myItem = "";
            System.out.println("Enter the next item you want to buy.");
            myItem = scan.nextLine();
            //If the user inputs a specific item, return the item name and price
            //After each input, updates the variables: total cost so far, budget left, and the count of items
            //If the user inputs an item that isn't being sold, will return "Sorry we do not sell that item."
            if (myItem.equalsIgnoreCase("T Shirt")){
                System.out.println(tShirt);
                totalCost = totalCost + tShirt.getPrice();
                budgetLeft = MAX_BUDGET - totalCost;
                count = count + 1;
            } else if (myItem.equalsIgnoreCase("Shoes")){
                System.out.println(shoes);
                totalCost = totalCost + shoes.getPrice();
                budgetLeft = MAX_BUDGET - totalCost;
                count = count + 1;
            } else if (myItem.equalsIgnoreCase("Jeans")){
                System.out.println(jeans);
                totalCost = totalCost + jeans.getPrice();
                budgetLeft = MAX_BUDGET - totalCost;
                count = count + 1;
            } else if (myItem.equalsIgnoreCase("Jacket")){
                System.out.println(jacket);
                totalCost = totalCost + jacket.getPrice();
                budgetLeft = MAX_BUDGET - totalCost;
                count = count + 1;
            } else if (myItem.equalsIgnoreCase("Hat")){
                System.out.println(hat);
                totalCost = totalCost + hat.getPrice();
                budgetLeft = MAX_BUDGET - totalCost;
                count = count + 1;
            } else if (myItem.equalsIgnoreCase("Shorts")){
                System.out.println(shorts);
                totalCost = totalCost + shorts.getPrice();
                budgetLeft = MAX_BUDGET - totalCost;
                count = count + 1;
            } else if (myItem.equalsIgnoreCase("Blouse")){
                System.out.println(blouse);
                totalCost = totalCost + blouse.getPrice();
                budgetLeft = MAX_BUDGET - totalCost;
                count = count + 1;
            }else{
                System.out.println("Sorry we do not sell that item.");
            }
            
            //Prints out variables/values the customer should know
            System.out.println("Amount Of Items: " + count);
            System.out.println("Total Cost So Far: $" + totalCost);
            System.out.println("Budget Left: $" + budgetLeft);
            
            //If the customer goes over the budget, make a warning
            if (totalCost > MAX_BUDGET){
                System.out.println("WARNING: You are over your budget!!");
            }
            System.out.print("\n");
        }
    }
}

//Creating class for Item
class Item{
    //Declaring private variables
    private String strName;
    private double dblPrice;
    
    //Creating accessor (getter) methods for the item's name and price
    public String getItemName(){
        return strName;
    }
    public double getPrice(){
        return dblPrice;
    }
    
    //Creating mutator (setters) methods for the item's name and price
    public void setItemName(String inItem){
        strName = inItem;
    }
    public void setPrice(double inPrice){
        dblPrice = inPrice;
    }
    
    //Returns final statement, this includes the item's name and price
    public String toString(){
        String result = "";
        result = "Item: " + strName + "\n" + "Price: " + dblPrice;
        return result;
    }
}








