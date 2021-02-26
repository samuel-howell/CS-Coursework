package com.company;
//Samuel Howell CS190L 11-15-19
import java.io.*;
import java.util.*;

public class FordCars {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("-------  Escape   Explorer F150     F250     Flex     Mustang  Taurus");
        int numberArray[][] = new int[7][7];


        //add the .txt file for the scanner
        File file = new File("C:\\Users\\slide\\Desktop\\dataFileCars.txt");

        //create a scanner to read input from the dataFileCars.txt
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String car = input.nextLine();
            int divider = car.indexOf(',');
            String carType = car.substring(0, divider);
            String carColor = car.substring(divider + 1);

            switch (carColor){
                case "black"  : ++numberArray[0][findModel(carType)]; break;
                case "blue"   : ++numberArray[1][findModel(carType)]; break;
                case "brown"  : ++numberArray[2][findModel(carType)]; break;
                case "green"  : ++numberArray[3][findModel(carType)]; break;
                case "red"    : ++numberArray[4][findModel(carType)]; break;
                case "silver" : ++numberArray[5][findModel(carType)]; break;
                case "white"  : ++numberArray[6][findModel(carType)]; break;
            }// end switch
        }//end while

        //color identifiers array
        String[] possibleCarColors = new String[7];
        possibleCarColors[0] = "BLACK";
        possibleCarColors[1] = "BLUE";
        possibleCarColors[2] = "BROWN";
        possibleCarColors[3] = "GREEN";
        possibleCarColors[4] = "RED";
        possibleCarColors[5] = "SILVER";
        possibleCarColors[6] = "WHITE";

        //print color identifier array
        for (int i = 0; i < numberArray.length; i++) {
            System.out.println();
            System.out.printf("%-9s", possibleCarColors[i]);
            for (int j = 0; j < numberArray[i].length; j++)
                System.out.printf("%-9d", numberArray[i][j]);
        }// end for
    }// end main

    //method to find the model position in the array
    public static int findModel(String carType) {
        int j =-1;
        switch(carType){
            case "Escape": j = 0; break;
            case "Explorer": j = 1; break;
            case "F150": j = 2; break;
            case "F250": j = 3; break;
            case "Flex": j = 4; break;
            case "Mustang": j = 5; break;
            case "Taurus": j = 6; break;
        }return j;
    }// end findModel method
}// end class

