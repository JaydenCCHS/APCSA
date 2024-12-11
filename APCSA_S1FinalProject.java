/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.apcsa_finalproject;

/**
 *
 * @author JHoang2026
 * 
 * Make a rock, paper, scissors game
 * Import java.util.* to have the scanner and random
 * Make an array list that holds 3 variables: rock, paper, scissors
 * Add the variables to the list
 * Have variables for the computer and user scores
 * Create a while loop that loops a conditional until someone reaches 10 points (while user score is less than 10 and computer score is less than 10, repeat)
    * The computer will randomly pick between rock, paper, and scissors (pick a number between 0-2)
    * Create a scanner
    * The user will select either rock, paper, or scissors
    * (Make sure to allow capitalization errors (ignore case))
    * Have a conditional that says:
    *      If user chooses rock
    *          If computer chooses scissors, user wins
    *          If computer chooses paper, user loses
    *          If computer chooses rock, round is a tie
    *      If user chooses paper
    *          If computer chooses rock, user wins
    *          If computer chooses scissors, user loses
    *          If computer chooses paper, round is a tie
    *      If user chooses scissors
    *          If computer chooses paper, user wins
    *          If computer chooses rock, user loses
    *          If computer chooses scissors, round is a tie
    * If user wins a round, add 1 to their score
    * If user loses a round, add 1 to computer score
    * Display both scores after each round
    * Once one person has reached a score of ten, end program
 * 
 * 3 different objects: rock, paper, and scissors
 * 1 object is rock
 * 1 object is paper
 * 1 object is scissors
 * The computer chooses an object, and the user chooses an object
 * Two of the same object = tie
 * Two different objects, one person will win
 * 
 * Make a class, with a private variable for a choice/move (rock or paper or scissors)
 * Have mutators (setters) that set the name of the object (rock, paper, or scissors)
 * Have accessors (getters) that receive the name of the object
 * 
 */

//Import scanner and random
import java.util.*;
public class APCSA_S1FinalProject {

    //Calls the code for the game to start (This avoids an error of having a non static variable, which cannot be referenced from a static context)
    public static void main(String[] args) {
        Choice myGame = new Choice();
        myGame.PlayGame();
    }
}
    //New class for all the code, including methods at the end
    class Choice{
        //Creating a private variable
        private String strMove;
        
        //Code of the actual game
        public void PlayGame(){
        //Welcomes the user
        System.out.println("Hello! Welcome to my Rock Paper Scissors game!");
        
        //Creates a list and adds the appropriate variables to the list
        ArrayList<String> movesList = new ArrayList<String>();
        movesList.add("Rock");
        movesList.add("Paper");
        movesList.add("Scissors");
        
        //Create variables to keep score of the player's and computer's points
        int userScore = 0;
        int computerScore = 0;
        
        //Creating different objects for each move (rock, paper, and scissors)
        Choice rock = new Choice();
        rock.setSelection("Rock");
        
        Choice paper = new Choice();
        paper.setSelection("Paper");

        Choice scissors = new Choice();
        scissors.setSelection("Scissors");
        
        //Creating a while loop so that the game keeps running until someone reaches 10 wins
        while((userScore < 10) && (computerScore < 10)){
            //Creating scanner to read user inputs
            Scanner scan = new Scanner(System.in);
            String playerChoice = "";
            System.out.println("Pick a move (rock, paper, or scisssors)");
            playerChoice = scan.next();
            System.out.println("You chose: " + playerChoice);

            //Creating a random number generator that generates a number from 0-2
            //This random number determines what the computer's move is
            //For example, if the random number is 0, the computer chose rock
            Random generator = new Random();
            int random;
            random = generator.nextInt(3);
            String computerChoice = movesList.get(random);
            System.out.println("The computer chose: " + computerChoice);
            
            //Creating a conditional that compares the player's and computer's choices to determine who wins each round
            //If the player choose rock...
            if(playerChoice.equalsIgnoreCase("Rock")){
                //If computer chooses scissors, user wins
                if(computerChoice == scissors.getSelection()){
                    System.out.println("User wins!");
                    userScore++;
                }
                //If computer chooses paper, computer wins
                if(computerChoice == paper.getSelection()){
                    System.out.println("Computer wins!");
                    computerScore++;
                }
                //If computer chooses scissors, tie
                if(computerChoice == rock.getSelection()){
                    System.out.println("Tie!");
                }
            //If the player chooses paper...
            } else if (playerChoice.equalsIgnoreCase("Paper")){
                //If computer chooses rock, user wins
                if(computerChoice == rock.getSelection()){
                    System.out.println("User wins!");
                    userScore++;
                }
                //If computer chooses scissors, computer wins
                if(computerChoice == scissors.getSelection()){
                    System.out.println("Computer wins!");
                    computerScore++;
                }
                //If computer chooses paper, tie
                if(computerChoice == paper.getSelection()){
                    System.out.println("Tie!");
                }
            //If the player chooses scissors...
            }else if (playerChoice.equalsIgnoreCase("Scissors")){
                //If computer chooses paper, user wins
                if(computerChoice == paper.getSelection()){
                    System.out.println("User wins!");
                    userScore++;
                }
                //If computer chooses rock, computer wins
                if(computerChoice == rock.getSelection()){
                    System.out.println("Computer wins!");
                    computerScore++;
                }
                //If computer chooses scissors, tie
                if(computerChoice == scissors.getSelection()){
                    System.out.println("Tie!");
                }
            //This makes sure that there are no errors/crashes that can occur
            //This also reminds the reader to double check their input in case of a typo
            }else{
                System.out.println("Uh oh! We don't understand what you meant. Make sure to choose between Rock, Paper, or Scissors.");
            }
            //Prints out user and computer scores
            System.out.println("Your score is: " + userScore + "\n" + "The computer's score is: " + computerScore);
            //This code will ouput the winner of the game (whoever reaches 10 wins first)
            if(userScore == 10){
                System.out.println("Player Wins! Great job!");
            }else if (computerScore == 10){
                System.out.println("Computer Wins! Better luck next time!");
            }
        }
        }
        
        //This is a mutator or setter, which establishes what the private variable changes into
        public void setSelection(String inSelection){
            strMove = inSelection;
        }
        //This is an accessor or getter, which receive the value of strMove that was previous set (changed)
        public String getSelection(){
            return strMove;
        }
        //The toString below is not used, but is kept inside the code in case I want to use it in the future
        //This would print out "result" after it has been called
        public String toString(){
            String result = "";
            result = "a";
            return result;
        }
    
}
