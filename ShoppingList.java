/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.shoppinglist;

/**
 *
 * @author JHoang2026
 */
//Importing java class, includes scanner and array list
import java.util.*;
public class ShoppingList {

    public static void main(String[] args) {
        //Creating the new ArrayList that will hold the variables of the shopping list
        ArrayList SL = new ArrayList();
        //Creating variables for adding and removing items in the list
        String addItem = "";
        String removeItem = "";
        //Creating while loop so that code keeps running. This allows multiple items to be added to the shopping list
        while(true){
            //Creating scanner for user inputs
            Scanner scan = new Scanner(System.in);
            System.out.println("What do you want to add to the Shopping List?");
            addItem = scan.nextLine();
            //Adds user input to the array list
            SL.add(addItem);
            //Setting i equals to 0
            int i = 0;
            //Prints out the shopping list with each item numbered appropriately
            //A while loop is used to print out multiple items
            System.out.println("New Shopping List:");
            while(i < SL.size()){
                System.out.println((i+1) + ": " + SL.get(i));
                i++;
            }
            //Asks if the user wants to remove anything from their shopping list
            System.out.println("Do you want to remove anything? If yes, which item (string)? If not, say \"no\".");
            removeItem = scan.nextLine();
            //Removes item from array list
            SL.remove(removeItem); 
            i=0;
            //Prints out the new shopping list (new array list)
            //The while loop repeats the code to print multiple items
            System.out.println("New Shopping List:");
            while(i < SL.size()){
                System.out.println((i+1) + ": " + SL.get(i));
                i++;
            }

        }
    }
}
