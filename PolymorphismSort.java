/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.polymorphismsort;

/**
 *
 * @author JHoang2026
 */

public class PolymorphismSort {
/**
* @param args the command line arguments
*/
    public static void main(String[] args)
    {
        //Creating the list of contacts with first name, last name, and phone number
        Contact[] friends = new Contact[8];
        friends[0] = new Contact("John", "Smith", "610-555-7384");
        friends[1] = new Contact("Sarah", "Barnes", "215-555-3827");
        friends[2] = new Contact("Mark", "Riley", "733-555-2969");
        friends[3] = new Contact("Laura", "Getz", "663-555-3984");
        friends[4] = new Contact("Larry", "Smith", "464-555-3489");
        friends[5] = new Contact("Frank", "Phelps", "322-555-2284");
        friends[6] = new Contact("Mario", "Guzman", "322-555-9066");
        friends[7] = new Contact("Marsha", "Grant", "243-555-2837");
        //Printing out the contacts in telephone (numerical) order using Selection sort and Insertion sort
        Sorting.selectionSort(friends);
        System.out.println("*** Selection Sort ***");
        for (Contact friend : friends)
            System.out.println(friend);
        Sorting.insertionSort(friends);
        System.out.println();
        System.out.println("*** Insertion Sort ***");
        for (Contact friend : friends)
            System.out.println(friend);
    }
}
//Sorting class
class Sorting{
    //Selection Sort
    public static void selectionSort(Comparable[] list)
    {
        int min;
        Comparable temp;
        for (int index = 0; index < list.length-1; index++)
        {
            min = index;
            //Finds smallest value and swaps it with another value so that smallest value ends up in right spot
            for (int scan = index+1; scan < list.length; scan++)
                if (list[scan].compareTo(list[min]) < 0)
                    min = scan;
            // Swap the values
            temp = list[min];
            list[min] = list[index];
            list[index] = temp;
        }
    }
    /**
    * @param args the command line arguments
    */
    //Insertion Sort, picks a value and inserts in its proper spot
    public static void insertionSort(Comparable[] list)
    {
        for (int index = 1; index < list.length; index++)
        {
            Comparable key = list[index];
            int position = index;
        // Shift larger values to the right
            while (position > 0 && key.compareTo(list[position-1]) < 0)
            {
                list[position] = list[position+1];
                position++;
            }
            list[position] = key;
        }
    }
}
//Comparable class
class Contact implements Comparable
{
    private String firstName, lastName, phone;
    //-----------------------------------------------------------------
    // Constructor: Sets up this contact with the specified data.
    //-----------------------------------------------------------------
    public Contact(String first, String last, String telephone)
    {
        firstName = first;
        lastName = last;
        phone = telephone;
    }
    //-----------------------------------------------------------------
    // Returns a description of this contact as a string.
    //-----------------------------------------------------------------
    public String toString()
    {
        return lastName + ", " + firstName + "\t" + phone;
    }
    //-----------------------------------------------------------------
    // Returns a description of this contact as a string.
    //-----------------------------------------------------------------
    
    //ADDED CODE: I changed this code so that it uses the phone number information rather than first & last names
    public boolean equals(Object other)
    {
        return (phone.equals(((Contact)other).getPhoneNum()));
    }
    //-----------------------------------------------------------------
    // Uses both last and first names to determine ordering.
    //-----------------------------------------------------------------
    
    //ADDED CODE: I changed this compareTo so that it compares phone numbers rather than names. If 2 phone numbers are the same (which is really rare), sort by last name
    public int compareTo(Object other)
    {
        int result;
        String otherPhone = ((Contact)other).getPhoneNum();
        String otherLast = ((Contact)other).getLastName();
        if (phone.equals(otherPhone))
            result = lastName.compareTo(otherLast);
        else
            result = phone.compareTo(otherPhone);
        return result;
    }
    //-----------------------------------------------------------------
    // First name accessor.
    //-----------------------------------------------------------------
    public String getFirstName()
    {
        return firstName;
    }
    //-----------------------------------------------------------------
    // Last name accessor.
    //-----------------------------------------------------------------
    public String getLastName()
    {
        return lastName;
    }
    
    //ADDED CODE: adding getter method for phone number
    public String getPhoneNum(){
        return phone;
    }
}