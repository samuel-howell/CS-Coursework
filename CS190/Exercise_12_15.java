package com.company;

import java.util.*;
import java.io.*;
//Samuel Howell CS190
public class Exercise_12_15 {

    public static void main(String[] args) throws Exception {

        File file = new File("Exercise12_15.txt");


        try (
                // Create printwriter for output
                PrintWriter output = new PrintWriter(file);
        ) {
            // create 100 random numbers and put them in the file
            for (int counter = 0; counter < 100; counter++) {
                output.print(((int)(Math.random() * 9)));
                output.print(" ");
            }
        }

        // form an array list to hold all the integers
        ArrayList<Integer> outputList = new ArrayList<>();

        try(
                // Create a Scanner
                Scanner sc = new Scanner(file);
        ) {
            // Read the data from the .txt file and add to the array list
            while (sc.hasNext()) {
                outputList.add(sc.nextInt());
            }
        }

        // Sort array list to put everything in the right order
        Collections.sort(outputList);

        // Display result
        System.out.print(outputList.toString());
        System.out.println();
    }
}