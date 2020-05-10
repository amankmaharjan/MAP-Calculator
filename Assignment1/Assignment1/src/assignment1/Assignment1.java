/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Scanner;

/**
 *
 * @author 12102452
 */
// Class that calculates the  map Value and display summary result
public class Assignment1 {

    // Main method
    public static void main(String[] args) {

        // Initializing the variables
        int choice = 0; // flag variable for checking the  range between 5-10
        double minMAP = 1000000; // variable for storing minimum map value
        double maxMAP = 0;// variable for storing maximum map value
        double avgMAP = 0;//variable for storing average map value
        double totalMAP = 0;//variable for storing total map value
        int patientCounter = 0; //variable for storing the count of patient records inserted

        // Create scanner object for taking input
        Scanner scanner = new Scanner(System.in);
        // Instaniate MAPCalculator instance to calculate map value and category
        MAPCalculator mAPCalculator = new MAPCalculator();
        
        // Displaying the  sample example for inserting input
        System.out.println("****************APP-MAP-CALCULATOR****************");
        System.out.println("--------------------------------------------------");
        System.out.println("Enter patient details:");
        System.out.println("EXAMPLE,");//displaying the sample e.g for inserting input
        System.out.println("\tID:1");
        System.out.println("\tSBP:100");
        System.out.println("\tDBP:80");
        System.out.println("-----------------------");

        // loop that runs  untill the  choice =-1
        while (choice != -1) {

            System.out.println("Patient no:" + (patientCounter + 1));
            System.out.println("ID <between 1-100>:");
            // Taking identifier input
            int id = scanner.nextInt(); // Variable for storing identifier
            System.out.println("SBP <between 90mmHg-120mmHg>:");
            // Take SBP input from user
            double sbp = scanner.nextDouble(); // Variable for storing SBP value
            System.out.println("DBP <between 60mmHg-80mmHg>:");
            //  Take DBP input from user
            double dbp = scanner.nextDouble(); // Variable for storing DBP value
            System.out.println("--------------------------------------------------");

            //  Checking if dbp is greater than sbp
            if (sbp < dbp) {
                // Display the error message  SBP greater than DBP
                System.out.println("\033[1;31m[ERROR]:INPUT ERROR:'SBP' must be greater than 'DBP'");

            } else {

                // Calculating the map value
                double map = mAPCalculator.value(sbp, dbp);
                // Computing  category in which map value belongs to
                String category = mAPCalculator.category(map);
                // Displaying  summary results of patient
                System.out.println("[INFO]" + " " + "RECORDS INSERTED:" + " " + (patientCounter + 1)); // Display the  number of records inserted
                System.out.println("[INFO] DISPLAYING  PATIENT MAP RESULT");
                System.out.println("--------------------------------------------------");
                System.out.println("\tPATIENT ID:" + id); // Show the  patient identifier value
                System.out.printf("\tSBP: %.1f " + "mmHg%n", sbp);// Show the SBP value
                System.out.printf("\tDBP: %.1f " + "mmHg%n", dbp);// Show the DBP value
                System.out.printf("\tMAP: %.1f " + "mmHg%n", map);// Show the MAP value
                System.out.println("\tCATEGORY:" + "" + "'" + category + "'");// Show the Category
                System.out.println("--------------------------------------------------");

                // Find greatest map value
                if (maxMAP < map) {
                    maxMAP = map; // Assign the  maximum map value
                }
                // Find smallest map value
                if (minMAP > map) {
                    minMAP = map; // Assign the minium map value
                }
                // Find total map value
                totalMAP += map; // stores the total sum of map value
                patientCounter++; // Increasing the patientcounter variable for each succesful insertion

                // Check whether to proceed or not after taking 5 records 
                if (patientCounter >= 5 && patientCounter < 10) {
                    System.out.println("Do you want to continue? 'Y' or 'N':");// Display for confirmation
                    String confirm = scanner.next(); // Variable for storing the confirmation value to take input from user
                    if (!confirm.equalsIgnoreCase("Y")) {
                        choice = -1; // Exit from the loop if the confirm value is not equal to "Y"
                    }
                    // Check if the range exceeds more than 10
                } else if (patientCounter >= 10) {
                    System.out.println("\033[1;31m[ERROR]:'Patient entry exceed to 10'"); // Display error message if the range exceeds more than 10
                    System.out.println("--------------------------------------------------");
                    System.out.println("[INFO] TERMINATING DATA ENTRY");
                    choice = -1; // Exit from the loop if the patient count is greater than 10
                }
            }
        }// While loop ends

        // Calculate the average map value
        avgMAP = totalMAP / patientCounter;

        // Display the final summary result
        System.out.println("--------------------------------------------------");
        System.out.println("[INFO] DISPLAYING  SUMMARY RESULT"); // Display the summary result
        System.out.println("--------------------------------------------------");
        System.out.printf("\tHighest MAP value: %.1f%n", maxMAP); // Display the maximum MAP value
        System.out.printf("\tLowest MAP value: %.1f%n", minMAP); // Display the minimum MAP value
        System.out.printf("\tAverage MAP value: %.1f%n", avgMAP);// Display the average MAP value
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
        
    }// Main function ends
}// Assignment1 class ends
