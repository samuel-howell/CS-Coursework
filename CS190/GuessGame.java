package com.company;

import java.util.Scanner;
// Samuel Howell CS190 Lab 10-11-19
public class GuessGame {

    public static void main(String[] args) {

        while (1 == 1) {
        Scanner sc = new Scanner(System.in);

        // ask the user for a random letter and state how many guesses they get.
            System.out.println("Guess the random letter.");
            System.out.println("You get 10 guesses.");

        //create a random character
            char randomChar = (char) (Math.random() * 26 + 97);

        //create a for loop checking if the user character matches the random computer character.
            for (int guess = 1; guess < 11; guess++) {

                //take a user input as a character.
                char userChar = sc.next().charAt(0);

                //compare the user character to the computer character
                if (userChar == randomChar) {
                    System.out.println("The letter was " + randomChar + "! You got it in " + guess + "guesses.");
                    break;
                } else if ((userChar != randomChar) && (guess != 10)) {
                    System.out.println("Nope. Please try again.");
                } else if ((userChar != randomChar) && (guess == 10)) {
                    System.out.println("Too bad. The letter was " + randomChar + ".");
                }

            }

            //ending sequence
            System.out.println("Play again?");
            System.out.println("Enter 'y' to continue, 'n' to exit game:");

            //take another input from the user. Either a 'y' or a 'n'
            char userAnswer = sc.next().charAt(0);

            //If  'y', loop back and begin the game again.  If 'n', break from the loop.
            if (userAnswer == 'y') continue;
            else if (userAnswer == 'n') break;


        }
        //print ending statement verifying that the 'n' input was accepted
        System.out.println("Thanks for playing!");
    }
}
