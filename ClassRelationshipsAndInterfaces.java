/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.classrelationshipsandinterfaces;

/**
 *
 * @author JHoang2026
 */
//Importing Java package 
import java.util.*;
public class ClassRelationshipsAndInterfaces {

    public static void main(String[] args) {
        
        //Creating new list
        ArrayList list = new ArrayList();
        //Declaring my tasks and adding them to the list
        Task task1 = new Task("Washing the dishes", 8, 4);
        list.add(task1);
        Task task2 = new Task("Taking the dog on a walk", 5, 3);
        list.add(task2);
        Task task3 = new Task("Exercise", 2, 9);
        list.add(task3);
        Task task4 = new Task("Eat breakfast", 7, 2);
        list.add(task4);
        Task task5 = new Task("Brush my teeth", 10, 3);
        list.add(task5);
        
        //Sorts the list in order or priority, then complexity
        Collections.sort(list);
        for (int i = 1; i <= list.size(); i++){
            System.out.println(list.get(i-1));
        }        
        
        
    }
}
//Making interface for Priority
interface Priority {
    int getPriority();
    void setPriority(int priority);
    //public void setPriority(int priority);
    //public int getPriority();
}
//Making interface for Complexity
interface Complexity {
    int getComplexity();
    void setComplexity(int complexity);
    //public void setComplexity(int complexity);
    //public int getComplexiy();
}

//This class implements all 3 interfaces
class Task implements Priority, Complexity, Comparable<Task> {
    //Setting up private variabels 
    private int priority;
    private int complexity;
    private String taskName;
    //Construtor for task, this takes inputs of task name, priority, and complexity
    public Task (String inTaskName, int inPriority, int inComplexity){
        priority = inPriority;
        complexity = inComplexity;
        taskName = inTaskName;
    }
    //Setter and getter for Priority
    public void setPriority(int inPriority){
        priority = inPriority;
    }
    public int getPriority(){
        return priority;
    }    
    
    //Setter and getter for Complexity
    public void setComplexity(int inComplexity){
        complexity = inComplexity;
    }
    public int getComplexity(){
        return complexity;
    }    
    
    //CompareTo, this compares the priority and complexity of different tasks, and orders them properly
    public int compareTo(Task t){
        //int task1 = this.getPriority().compareTo(t.getPriority());
        if (this.getPriority() > t.getPriority()){
            return -1;
        }else if (this.getPriority() < t.getPriority()){
            return 1;
        }else {
            if (this.getComplexity() > t.getComplexity()){
                return -1;
            }else if (this.getComplexity() < t.getComplexity()){
                return 1;
            }else
                return 0;

        }
    }
    //To string, this is the format of the final output
    public String toString(){
            String result = "";
            result = taskName + ", Priority: " + priority + ", Complexity: " + complexity;
            return result;
        }
}