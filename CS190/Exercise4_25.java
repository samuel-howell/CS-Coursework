package com.company;

public class Exercise4_25 {

    public static void main(String[] args) {
    /*
    Samuel Howell
    Generate 3 random letters
    Make them uppercase
    Generate 4 random digits (1-9)
    concatenate the three uppercase letters and the 4 random digits
    print result
     */
// generate 3 random uppercase letters
    char randomLetter1 = (char)(Math.random() * 26 + 65);
    char randomLetter2 = (char)(Math.random() * 26 + 65);
    char randomLetter3 = (char)(Math.random() * 26 + 65);


       // Generate 4 random digits (1-9)
    int randomNumber1 = (int)(Math.random() * 10);
    int randomNumber2 = (int)(Math.random() * 10);
    int randomNumber3 = (int)(Math.random() * 10);
    int randomNumber4 = (int)(Math.random() * 10);

    //concatenate and print solution
    System.out.println("Your license plate number is " + randomLetter1 + randomLetter2 + randomLetter3 + randomNumber1 + randomNumber2 + randomNumber3 + randomNumber4);
    }
}
