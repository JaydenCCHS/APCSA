/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.constructorsassignment;

/**
 *
 * @author JHoang2026
 */
public class ConstructorsAssignment {
    //This is the main method, everything will be printed from here
    public static void main(String[] args) {
        //Prints out CSA course using the full object constructor
        Course CSA = new Course("Computer Science", "AP CS A", 98, "Mr. Nelson");
        System.out.println(CSA + "\n");
        
        //Prints out AP Chemistry course using the full object constructor also
        Course APChem = new Course("Chemistry", "AP Chemistry", 95, "Mrs. H");
        System.out.println(APChem + "\n");
        
        //Prints out Campus Ministry 11 course using the name only creator
        //Uses the setter methods to set the values for course code, points total, and course instructor
        Course CM11 = new Course("Campus Ministry");
        CM11.setCC("CM 11");
        CM11.setPT(97);
        CM11.setCI("Mr. Cunha");
        System.out.println(CM11 + "\n");

    }
}

//New class called "Course" that represents a course offered to students
class Course {
    //Setting up private variables
    private String courseTitle;
    private String courseCode;
    private int pointsTotal;
    private String courseInstructor;
    
    //Creating a constructor that accepts and initializes all instance data
    public Course(String title, String code, int points, String instructor) {
        courseTitle = title;
        courseCode = code;
        pointsTotal = points;
        courseInstructor = instructor;
    }
    
    //Creating a constructor that only accepts the course name
    public Course(String title) {
        courseTitle = title;
    }
    
    //Below are my accessors (getters) methods for all instance data
    public String getCT() {
        return courseTitle;
    }
    public String getCC() {
        return courseCode;
    }
    public int getPT() {
        return pointsTotal;
    }
    public String getCI() {
        return courseInstructor;
    }

    //Below are my mutators (setters) methods for all instance data
    public void setCT(String ct) {
        courseTitle = ct;
    }
    public void setCC(String cc) {
        courseCode = cc;
    }
    public void setPT(int pt) {
        pointsTotal = pt;
    }
    public void setCI(String ci) {
        courseInstructor = ci;
    }
    
    //Below is my toString method that returns a multi-line description of the course
    public String toString() {
        String result = "";
        result = "Course Title: " + courseTitle + "\n" +
                "Course Code: " + courseCode + "\n" +
                "Total Points: " + pointsTotal + "\n" +
                "Name of Course Instructor: " + courseInstructor;
        return result;
    }
    
}




