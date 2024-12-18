/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.apcsa_finalexam;

/**
 *
 * @author JHoang2026
 * Create a while loop that runs 5 times
 * add if statements to compare cards to see which is higher value and make sure the are not equal to each other
 * 
 * Random num gen (1-13) to decide face value
 * Random num gen (1-4) to decide suit
 * add arrayList for suits
 */

//Importing necesary classes
import java.util.ArrayList;
import java.util.Random;
public class Unit4Test {

    public static void main(String[] args) {
        //Creating a variable to count the number of cards
        int cardNum = 1;
        //Creating a loop that will produce 5 random cards
        while (cardNum <= 5){
            Card card = new Card();
            //Card card = new Card();
            System.out.println(card);
            cardNum++;

            
        }
        
        //Below I am trying to write code to determine the highets value of the cards
        //I am also trying to figure out how to make sure the cards won't repeat
        /*if (card.getValue){
            
        }
        
        for (int cardNum = 1; cardNum <= 5; cardNum++){
                Card card = new Card();
                //Card card = new Card();
                System.out.println(card);
            }*/
    }
}

//Create new class for Card
class Card{
    //Declaring private variables, one for suit, one for face value
    private String suit;
    private int value;
    
    //Accessors that will get the value of suit or face value
    public String getSuit(){
        return suit;
    }
    public int getValue(){
        return value;
    }
    
    //Creating a construtor that will establish suit and value
    public Card(){
        //Creating random number generator. This will choose a number 1-13, determining the face value
        Random rand = new Random();
        int valueNum = rand.nextInt(13) + 1;
        value = valueNum;
        
        //Creating a random number generator. 
        //Also creates an array list and adds the 4 suits to it
        //Each suit is assigned a random number
        //The random num generator "chooses" a suit
        int suitNum = rand.nextInt(4);
        ArrayList<String> suitList = new ArrayList<String>();
        suitList.add("Clubs");
        suitList.add("Diamonds");
        suitList.add("Hearts");
        suitList.add("Spades");
        suit = suitList.get(suitNum);
    }
   
    //Print out the 5 cards with their suits and face values
    public String toString(){
        String result = "";
        result = "New Card" + "\n" + "Suit: " + suit + "\n" + "Face Value: " + value;
        return result;
    }
}