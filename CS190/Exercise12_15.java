package com.company;

import java.util.*;
import java.io.*;

public class Exercise12_15 {

    public static void main(String[] args)  throws Exception {
        // Write a program to create a file named Exercise 12_15.txt jf it does not exist.  Write 100 integers created randomly into the file using text i/o  Integers are separated by spaces in the file.  Read the data back from the file and display the data in increasing order.

        // create a file with 100 sorted random integers
        File file = new File("Exercise 12_15.txt");
        System.out.println("Attempting to read from file in: "+file.getCanonicalPath());

        int[] randomNumber = new int[100];
        for(int i = 0; i < 100; i++){
            randomNumber[i] = (int)(Math.random() * 10);
            Arrays.sort(randomNumber);
        }


        try (
                //create a printWriter for the specified file
                PrintWriter output = new PrintWriter("Exercise12_15.txt");
        ) {

            //print 100 integers to the file
            for (int i = 0; i < 100; i++) {
                output.print(randomNumber[i] + " ");
            }
        }

        //I used this just to make sure the file was in the right place.  It didn't work.
        System.err.println(file.getAbsolutePath());

          //create a scanner
        Scanner input = new Scanner(file);

        //read data from the file
        while (input.hasNext()) {
            String result = input.next();
            System.out.println(result);
        }

       //close the file
       input.close();
        }
    }


