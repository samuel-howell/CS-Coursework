package com.company;

import java.util.Scanner;
//Samuel Howell CS190 Lab 10-25-19
public class scratchOff {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of five-character fields in code: ");  //ask for fields
        int fields = sc.nextInt();

        System.out.println("Enter number of access codes needed: ");  //ask for number of codes
        int numOfCodes = sc.nextInt();


        //for loop to call methods to  generate numbers
        int i;

        //number of access codes needed
        for(int o=0; o<numOfCodes; o++) {
            String finalResult = "";
            for (i = 0; i < fields; i++) {
                generateCode();
                finalResult = finalResult + (generateCode() + '-');
            }
            System.out.println(finalResult.substring(0, finalResult.length() - 1));
        }


    }

    //create a method to generate 5 random numbers
    public static String generateCode(){
        int j;
        String result ="";
        for(j=0; j<5; j++) {
            char randomLetter = (char) (Math.random() * 26 + 65);
            result = result + randomLetter;
        }//end of for loop
        return result;

    }
}


