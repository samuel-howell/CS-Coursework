package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/************************************************************************************
 * (Create a text file) Write a program to create a file named Exercise17_01.txt if  *
 * it does not exist. Append new data to it if it already exists. Write 100 integers *
 * created randomly into the file using text I/O. Integers are separated by a space. *
 ************************************************************************************/

public class Exercise17_01 {

    public static void main(String[] args) throws FileNotFoundException {
        //create a file named Exercise17_01.txt
        File file = new File("Exercise17_01.txt");
        //create a list array to hold the numbers in
        ArrayList<String> numList = new ArrayList<>();

        if (file.exists()) {
            try (
                    //create a Scanner for input
                    Scanner sc = new Scanner(file);
            ) {//read data already stored on the file and add it to numlist
                while (sc.hasNext()) {
                    numList.add(sc.nextLine());
                }
            }
        }
        //create 100 random numbers (between 1 and 100) and put them in the numList array
        for (int i = 0; i < 100; i++) {
            numList.add(((int)(Math.random()*100)) + " ");
        }
        try(
                //create a PrintWriter for output
                PrintWriter pr = new PrintWriter((file));
                ) {
            //iterate over the numList, writing the random values into the txt file
            for (String num : numList){
                pr.print(num);
            }
        }
    }
}
