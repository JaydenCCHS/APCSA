/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.darrays;

/**
 *
 * @author jhoang2026
 */
//Importing the random generator
import java.util.*;
public class App {

    public static void main(String[] args) {
        //Creating the deck of 52 cards
        String[][] deckOfCards = {
            {"Ace of Hearts", "2 of Hearts", "3 of Hearts", "4 of Hearts", "5 of Hearts", "6 of Hearts", "7 of Hearts", "8 of Hearts", "9 of Hearts", "10 of Hearts", "Jack of Hearts", "Queen of Hearts", "King of Hearts"},
            {"Ace of Diamonds", "2 of Diamonds", "3 of Diamonds", "4 of Diamonds", "5 of Diamonds", "6 of Diamonds", "7 of Diamonds", "8 of Diamonds", "9 of Diamonds", "10 of Diamonds", "Jack of Diamonds", "Queen of Diamonds", "King of Diamonds"},
            {"Ace of Clubs", "2 of Clubs", "3 of Clubs", "4 of Clubs", "5 of Clubs", "6 of Clubs", "7 of Clubs", "8 of Clubs", "9 of Clubs", "10 of Clubs", "Jack of Clubs", "Queen of Clubs", "King of Clubs"},
            {"Ace of Spades", "2 of Spades", "3 of Spades", "4 of Spades", "5 of Spades", "6 of Spades", "7 of Spades", "8 of Spades", "9 of Spades", "10 of Spades", "Jack of Spades", "Queen of Spades", "King of Spades"}
        };
        //Printing the deck of cards
        System.out.println("Deck of cards: ");
        for (int row=0; row < deckOfCards.length; row++)
            {
            for (int col=0; col < deckOfCards[row].length; col++)
            System.out.print(deckOfCards[row][col] + "\t");
            System.out.println();
        }
        
        //Printing the shuffled deck
        System.out.println();
        System.out.println("Shuffled Deck: ");
        shuffle(deckOfCards);
        //This is used to print the shuffled deck of cards
        for (int row=0; row < deckOfCards.length; row++)
            {
            for (int col=0; col < deckOfCards[row].length; col++)
            System.out.print(deckOfCards[row][col] + "\t");
            System.out.println();
        }
        
        //Setting up the random number generator
        Random random = new Random();
        //Dealing 4 hands of 5 cards with no repeats
        System.out.println();
        for (int ppl = 0; ppl < 4; ppl++){
            System.out.println("Hand " + (char)('A' + ppl) + ": ");
            for (int cardNum = 0; cardNum < 5; cardNum++){
                String card = null;
                //This makes sure there won't be repeated cards
                while (card == (null)){
                    //Picks a random card using 2 random numbers
                    int randomRow = random.nextInt(deckOfCards.length);
                    int randomColumn = random.nextInt(deckOfCards[randomRow].length);
                    card = deckOfCards[randomRow][randomColumn];
                    if (card != null){
                        //If this is a "new" card, print it
                        System.out.println(card);
                        deckOfCards[randomRow][randomColumn] = null;
                    }
                }
            }
            System.out.println();
        }
    }
    //Shuffles the cards randomly using Collections and Arrays.asList
    public static void shuffle(String[][] deckOfCards){
        List<String[]> rows = Arrays.asList(deckOfCards);
        Collections.shuffle(rows);
        for (String[] row : deckOfCards){
            Collections.shuffle(Arrays.asList(row));
        }
        
    }
    
}
