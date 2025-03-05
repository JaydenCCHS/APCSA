/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inheritancetriviagame;

/**
 *
 * @author JHoang2026
 */

//Importing essential parts, such as the scanner and the timer
import java.util.*;
public class InheritanceTriviaGame {
    //Main class
    public static void main(String[] args) {
        //Introduction/instructions for the user
        System.out.println("Welcome to the Animal Trivia Game! There will be 3 questions, some multiple choice and some with a time limit. You will have 1 hint powerup and 1 retry powerup. You will get 10 points for each correct question! Good luck!" + "\n");
        
        //Creating scanner
        Scanner scanner = new Scanner(System.in);
        
        //Creating new array lists and initializing variables 
        ArrayList<Question> questionList = new ArrayList<>();
        ArrayList<Question> selectedQuestion = new ArrayList<>();
        ArrayList<String> powerUpsList = new ArrayList<>();
        int score = 0;
        int difficultyLevel = 0;
        
        //Establishing the 3 of hints the user gets
        Hint hintPU = new Hint("Hint", 1,"firstLetter");
        Retry retryPU = new Retry("Retry", 1, true);
        
        //Adding questions to the question list (MCQ and time limit questions
        questionList.add(new MCQ("What is the largest land animal? (enter the word)", "Elephant", 2,
                new ArrayList<>(List.of("Elephant", "Rhino", "Giraffe", "Hippo"))));
        questionList.add(new TimeLimit("What is the fastest land animal? (You have 5 seconds to answer)", "Cheetah", 5, 5));
        questionList.add(new MCQ("Which animal is known for playing dead? (enter the word)", "Opossum", 7,
                new ArrayList<>(List.of("Fox", "Racoon", "Opossum", "Badger"))));
        questionList.add(new TimeLimit("Which mammal can fly? (You have 5 seconds to answer)", "Bat", 9, 5));
        questionList.add(new MCQ("Which animal is known as the 'King of the Jungle'? (enter the word)", "Lion", 1,
                new ArrayList<>(List.of("Tiger", "Lion", "Elephant", "Bear"))));
        questionList.add(new TimeLimit("What is the largest mammal? (You have 5 seconds to answer)", "Blue Whale", 3, 5));
        questionList.add(new MCQ("What is the tallest land animal? (enter the word)", "Giraffe", 1,
                new ArrayList<>(List.of("Elephant", "Giraffe", "Horse", "Rhino"))));        

        //Shuffling questions, and choosing 3 random questions
        Collections.shuffle(questionList);
        for (int i = 0; i < 3; i++){
            selectedQuestion.add(questionList.get(i));
        }

        //For each question, ask if the user wants to use a hint or retry powerup
        for(Question question : selectedQuestion){

            question.askQuestion();
            
            //Asks if the user wants to use a hint powerup
            System.out.println("\nWould you like to use a hint? (yes/no)");
            while (true){
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("yes")){
                    hintPU.revealHint(question.answer);
                    break;
                }else if (input.equals("no")){
                    break;
                }else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
            
            //Asks if the user wants to use a retry powerup
            boolean retryUsed = false;
            System.out.println("Would you like to use the second chance power up? (yes/no)");
            while (true){
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("yes")){
                    retryUsed = retryPU.activate();
                    break;
                }else if (input.equals("no")){
                    break;
                }else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
            
            
            boolean correct = false;
            //Creating format for time-limit question
            if (question instanceof TimeLimit) {
                correct = ((TimeLimit) question).askWithTimer(scanner);
            } 
            //Creating format for multiple choice question
            if (question instanceof MCQ) {
                String userAnswer = scanner.nextLine();
                correct = question.checkAnswer(userAnswer);
            } 

            //Prints message for when user gets the question wrong when retry is used
            if (!correct && retryUsed){
                System.out.println("Retrying! Try again. (If this is a time-limit question, you now have infinite time.");
                correct = question.checkAnswer(scanner.nextLine());
            }
            
            //Prints message for when user gets the question right/wrong
            if (correct){
                System.out.println("Correct!" + "\n");
                score = score + 10;
            }else{
                System.out.println("Wrong answer! The correct answer was: " + question.getAnswer() + "\n");
            }
        }
        //Prints final game message and user's score
        System.out.println("\n" + "Game Over! Your final score: " + score);
    }
}

//Parent class 'Question'
class Question {
    //Establishing variables
    private String q = "";
    public String answer = "";
    private int difficultyLevel = 0;
    
    //Gets inputs from main
    Question(String inQ, String inAnswer, int inDifficultyLevel){
        q = inQ;
        answer = inAnswer;
        difficultyLevel = inDifficultyLevel;
    }
    //Prints the question and checks user's answer
    void askQuestion(){
        //q = ("Question: " + q);
        System.out.println("Question: " + q);
    }
    public boolean checkAnswer(String userAnswer){
        return userAnswer.equalsIgnoreCase(answer);
    }
    public String getAnswer(){
        return answer;
    }
    public String toString(){
        String result = "";
        result = q;
        return result;
    }
}

//Child class of question (TimeLimit)
class TimeLimit extends Question {
    //Adding new variable
    private int timeLimit;
    
    //Gets inputs from main
    public TimeLimit(String inQ, String inAnswer, int inDifficultyLevel, int inTime){
        super(inQ, inAnswer, inDifficultyLevel);
        this.timeLimit = inTime;
    }
   
    //Creating the time limit sequence
    boolean askWithTimer(Scanner scanner) {
        final boolean[] answered = {false};
        final String[] userAnswer = {""};

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered[0]) {
                    System.out.println("\nTime's up! Moving to the next question. Press any key to keep playing.");
                    answered[0] = true;
                }
            }
        }, timeLimit * 1000);

        //Lets user type answer and stops timer
        System.out.print("Your answer: ");
        userAnswer[0] = scanner.nextLine();
        answered[0] = true;
        timer.cancel();

        //Check user's answer
        return checkAnswer(userAnswer[0]);
    }
}

//Child class of question (MCQ)
class MCQ extends Question {
    //Adding new ArrayList
    private ArrayList<String> choices = new ArrayList<>();
    
    //Gets inputs from main
    public MCQ(String inQ, String inAnswer, int inDifficultyLevel, ArrayList inChoices){
        super(inQ, inAnswer, inDifficultyLevel);
        choices = inChoices;
    }
    //Overrides askQuestion from parent class, adds multiple choice options
    @Override
    void askQuestion(){
        super.askQuestion();
        for (int i = 0; i < choices.size(); i++){
            System.out.println((i+1) + ". " + choices.get(i));
        }
    }
}

//Parent Class 'PowerUp', gives the user a powerup
class PowerUp {
    //Creating variables
    protected String pName = "";
    protected int pLeft = 0;
    
    //Gets inputs from the main
    PowerUp(String name, int usesLeft) {
        this.pName = name;
        this.pLeft = usesLeft;
    }
    
    //Code for if the user activates the powerup (also checks if user has any powerups left)
    public boolean activate(){
        if (pLeft > 0){
            System.out.println(pName + "power-up activated!");
            pLeft--;
            return true;
        }else{
            System.out.println("No uses left for " + pName);
            return false;
        }
    }
}

//Child class of PowerUp (Hint)
class Hint extends PowerUp {
    //Creating an additonal variable
    private String hintType = "";
    
    //Gets inputs from the main
    Hint(String inName, int inUsesLeft, String inHintType) {
        super(inName, inUsesLeft);
        hintType = inHintType;
    }
    
    //If user uses a hint powerup, print the first letter of the answer
    void revealHint(String answer){
        if (pLeft > 0){
            if (hintType.equals("firstLetter")){
                System.out.println("Hint: The first letter is " + answer.charAt(0));
            }
            pLeft--;
        }else{
            System.out.println("No hints left.");
        }   
    }
    
}

//Child class of PowerUp (Retry)
class Retry extends PowerUp {
    //Creating an additional variable
    private boolean isActivated = false;
    
    //Gets inputs from the main class
    Retry(String inName, int inUsesLeft, boolean inIsActivated) {
        super(inName, inUsesLeft);
        isActivated = inIsActivated;
    }
    
    //Overrides activate from PowerUP
    //If user activates the retry powerup, give them 2 tries to answer the question
    @Override
    public boolean activate(){
        if (pLeft > 0){
            System.out.println("Second chance activated: You get two tries for this question.");
            pLeft--;
            return true;
        }else{
            System.out.println("No retries left.");
            return false;
        }
    }
}

