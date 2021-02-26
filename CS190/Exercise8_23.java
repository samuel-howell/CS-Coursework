package com.company;

import java.util.Scanner;

public class Exercise8_23 {
    //Samuel Howell      Assignment 8.23         pg 316
    public static void main(String[] args) {

        Scanner input =new Scanner(System.in);

        //initialize a 6-by-6 grid
        int array[][] = new int[6][6];


        //prompt user to fill 6-by-6 array row by row
        System.out.println("Enter a 6-by-6 matrix row by row");

        for(int row = 0; row < array.length; row++){
            for(int column = 0; column < array[row].length; column++){
                array[row][column] = input.nextInt();
            }
        }


        //for traversing the rows
        int r =0; //creates a variable to assign rowNumber to outside of the for loop
        for (int rowNumber = 0; rowNumber < array.length; rowNumber++) {
            int rowCounter = 0;
            for (int i = 0; i < array[0].length; i++) {
                if (array[rowNumber][i] == 1) rowCounter++;
            }
            if (rowCounter % 2 == 1) {
                r = rowNumber;
                break;
            }
        }


        //for traversing the columns
        int c = 0; //creates a variable to assign columnNumber to outside of the for loop
        for (int columnNumber = 0; columnNumber < array.length; columnNumber++) {
            int columnCounter = 0;
            for (int i = 0; i < array[0].length; i++) {
                if (array[i][columnNumber] == 1) columnCounter++;
            }
            if (columnCounter % 2 == 1) {
                c = columnNumber;
                break;
            }
        }

        System.out.println("The flipped cell is at (" + r + ", " + c + ")");
    }
}

