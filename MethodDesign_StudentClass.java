/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.methoddesign_studentclass;

/**
 *
 * @author JHoang2026
 * 
 * Project Plan:
 * Goal: Each student has 3 courses. In each course, they took a test and got a test score. Find the average of the 3 test scores for each student. 
 * 
 * 3 Classes: Driver (main), Student, Course
 * 
 * The Course class will have 2 variables for the name and test scores. 
 * There will be setters and getters to establish the test score for the specific course.
 * Remember to initialize the test score to 0. 
 * 
 * The Student class will use the Course class.
 * This class will have 2 variables for the student name and for a list of courses. 
 * Have the driver class declare the 3 classes for each student. In the student class, try having a setter and getter for the whole course list. 
 * Each student gets 3 courses (use the Course class)
 * Overload the constructor
 * Add setters and getters for the test scores. These scores will be pulled from the Course class. 
 * Find the average of the 3 test scores. 
 * Have a for loop that cycles 3 times. Each time, it goes to the Course class, and uses the getter method to get the test score from the Course class. 
 * Each time the loop is run, add a new test score to the total score (add 3 of them up). 
 * Finally, divide the total score by 3 to find the average score. 
 * Have a toString that outputs the student’s name, 3 courses, 3 test scores of each course, and the average score. 
 * The toString will have a loop similar to the getTestScore loop. This loop will use the Course class for test scores. 
 * 
 * The main driver class will initialize each student object. 
 * Student objects will include the student's name and 3 courses. 
 * There will also be setters for the test scores to go into the Course class. 
 * Remember to print everything out. 

 */
import java.util.*;
public class MethodDesign_StudentClass {

    public static void main(String[] args) {
        //Initializing courses for student 1
        Course[] courses1 = new Course[3];
        courses1[0] = new Course("AP Lang");
        courses1[1] = new Course("AP CSA");
        courses1[2] = new Course("Latin 3");
        
        //Initializing test scores for student 1
        Student student1 = new Student("Jayden", "Hoang", courses1);
        student1.setTestScore(0, 95);
        student1.setTestScore(1, 88);
        student1.setTestScore(2, 92);
        System.out.println(student1);
        
        //Initializing courses for student 2
        Course[] courses2 = new Course[3];
        courses2[0] = new Course("Chemistry");
        courses2[1] = new Course("Art");
        courses2[2] = new Course("Spanish");
        
        //Initializing test scores for student 2
        Student student2 = new Student("Billy", "Johnson", courses2);
        student2.setTestScore(0, 78);
        student2.setTestScore(1, 89);
        student2.setTestScore(2, 95);
        System.out.println(student2);

        //Initializing courses for student 3
        Course[] courses3 = new Course[3];
        courses3[0] = new Course("Algebra 2");
        courses3[1] = new Course("Intro to STEAM");
        courses3[2] = new Course("P.E.");
        
        //Initializing test scores for student 3
        Student student3 = new Student("Gabe", "Smith", courses3);
        student3.setTestScore(0, 99);
        student3.setTestScore(1, 94);
        student3.setTestScore(2, 86);
        System.out.println(student3);
    }
}

//Class for student
class Student{
    private String firstName;
    private String lastName;
    private double average;
    private Course[] classes;
    
    //Default constructor to initialize values
    public Student(){
        firstName = "";
        lastName = "";
    }
    //This constructor has the student's first and last name
    public Student(String first, String last){
        firstName = first;
        lastName = last;
    }
    //This constructor overrides the others. 
    //Has initialization for first and last name, and course list
    public Student(String first, String last, Course[] inClasses){
        firstName = first;
        lastName = last;
        classes = inClasses;
    }

    //Setter and getter for the test score of each class
    public void setTestScore(int courseNumber, int inScore){
        classes[courseNumber].setTestScore(inScore);
    }
    public int getTestScore(int courseNumber){
        return classes[courseNumber].getTestScore();
    }
    
    //Get average
    //This finds the average of the 3 test scores of the 3 classes. 
    public double getAverage(){
        int totalScore = 0;
        for (int i=0; i<classes.length; i++){
            totalScore = totalScore + classes[i].getTestScore();
        }
        average = totalScore / (double) classes.length;
        return average;
    }
    
    //To string to output "sentence"
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Name: " + firstName + " " + lastName + "\n" + "Average: " + getAverage() + "\n");
        for (Course course: classes){
            result.append(course).append("\n");
        }
        return result.toString();
    }
}

//Making the Course class
class Course{
    //Creating private variables for the Course class
    private String courseName = "";
    private int testScore = 0;
    
    //Setter and getter for course name
    public Course(String name){
        courseName = name;
    }
    public String getCourseName(){
        return courseName;
    }
    
    //Setter and getter for test score
    public void setTestScore(int inScore){
        testScore = inScore;
    }
    public int getTestScore(){
        return testScore;
    }
    //To string for Course class
    @Override
    public String toString(){
        return courseName + ": " + testScore;
    }
}