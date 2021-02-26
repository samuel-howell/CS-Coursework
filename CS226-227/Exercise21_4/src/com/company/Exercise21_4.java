package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
Name:           Samuel Howell
Date:           10-1-20
Class:          CS227
File:           Exercise21_4
Description:    (Count consonants and vowels) Write a program that prompts the user to enter a text file name and displays
                the number of vowels and consonants in the file. Use a set to store the vowels A, E, I, O, and U.
 */
public class Exercise21_4
{

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        HashSet<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        System.out.print("Enter the name of the file (ex. test.txt) : ");
        String file = sc.nextLine();
        Scanner fileInput = null;
        try
        {
            fileInput = new Scanner(new File(file));                //  create a scanner to read what is on the file.
                                                                    //  NOTE: file must be in project folder, or exception will be thrown
        } catch (FileNotFoundException e)
        {
            System.out.println("The file was not found. Please check the file location and/or correct the format of your input.");
            System.exit(0);
        }

        int vowelCount = 0;
        int consonantCount = 0;

        while(fileInput.hasNext())
        {
            String lineOfFile = fileInput.nextLine().toLowerCase();

            for(int i = 0; i < lineOfFile.length(); i++)
            {
                if (vowelSet.contains(lineOfFile.charAt(i)))            //  check and see if the character is a vowel
                {
                    vowelCount++;
                }
                else if (Character.isLetter(lineOfFile.charAt(i)))      //  check and see if the character is any other letter
                                                                        //  this prevent the consonantCount from including non-letter characters
                {
                    consonantCount++;
                }
            }
        }
        System.out.println("Vowel count: " + vowelCount);
        System.out.println("Consonant count: " + consonantCount);
    }
}
