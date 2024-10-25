/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.interestratecalculatorassignment;

/**
 *
 * @author JHoang2026
 */

//Importing the Scanner and code for the Number Format
import java.text.NumberFormat;
import java.util.*;
public class InterestRateCalculatorAssignment {

    public static void main(String[] args) {
        //Creating a scanner to get user inputs
        //User will input amount of money for the loan and number of months to pay it off
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter an amount of money.");
        double money = scan.nextDouble();
        System.out.println("Your financial amount: $" + money);
        
        System.out.println("Enter the number of months for repayment.");
        int months = scan.nextInt();
        System.out.println("The number of months for repayment: " + months);
        
        //Uses the InterestRateCalulator class to find how much the user needs to pay per month (including compound interest)
        InterestRateCalculator payment = new InterestRateCalculator();
        
        //This loop finds how much money the user needs to pay monthly
        for (int i = 1; i <= 1; i++) {
            payment.setValues(money, months);
            for (int j = 1; j <= months; j++) {
                payment.getCompoundInterestPayments(j);
                System.out.println(payment);
            }
        }
    }
}

//Establishing the class for the interest calculator
class InterestRateCalculator {
    //Declaring all the variables
    //All variables are private except for the constant RATE
    public static final double RATE = 0.035;
    private double amount = 0.00;
    private int months = 0;
    private int totalMonths = 0;
    private double paymentPerMonth = 0.00;
    private double remainingAmount = 0.00;
    private double paymentPerMonthPlusInterest = 0.00;
    private double remainingAmountPlusInterest = 0.00;
    private double totalPayment = 0.00;
    NumberFormat USD1 = NumberFormat.getCurrencyInstance();
    NumberFormat USD2 = NumberFormat.getCurrencyInstance();
    
    //This method sets the values that are inputted by the user
    public void setValues(double inAmount, int inMonths){
        amount = inAmount;
        totalMonths = inMonths;
     
    }
    
    //This method is the actual "calculator" part
    //This will determine the amount of the money the user needs to pay per month by using math
    public double getCompoundInterestPayments(int inMonths){
        months = inMonths;
        
        paymentPerMonth = amount / (totalMonths - (months - 1));
        paymentPerMonthPlusInterest = paymentPerMonth + (paymentPerMonth * RATE);
        remainingAmount = amount - paymentPerMonth;
        remainingAmountPlusInterest = remainingAmount + (remainingAmount * RATE);
        amount = remainingAmountPlusInterest;

        totalPayment += paymentPerMonthPlusInterest;
        
        
        return amount;
    }

    
    //The toString displays what will be printed in the output
    public String toString(){
        String result = "";
        //result = "Month: " + months + " " + paymentPerMonth + " " + remainingAmount + " " + paymentPerMonthPlusInterest + " " + remainingAmountPlusInterest + " " + amount;
        result = "Month: " + months + " Payment Per Month: " + USD2.format(paymentPerMonthPlusInterest) + " Total Amount Paid So Far: " + USD1.format(totalPayment);
        return result;
    }
}