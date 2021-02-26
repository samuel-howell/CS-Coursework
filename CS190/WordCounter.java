package com.company;
import java.io.*;
import java.util.*;
//Samuel Howell 2-28-20

/*Psuedocode: pull each line from the text file and turn it into a string.  Then shoot it to different
methods to calculate characters, words, and lines. Return those values
 */

public class WordCounter {
    public static void main(String[] args) throws FileNotFoundException {
        String textFile = args[0];
        //File file = new File("/C:/Users/slide/Desktop/test.txt");  //FOR TESTING
        File file = new File(textFile);
        Scanner sc = new Scanner(textFile);
        //Scanner sc = new Scanner(file);  //FOR TESTING

        //initialize counters
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;
        while(sc.hasNext()) {
            String s = sc.nextLine();

            charCount += findCharCount(s); //each iteration, add the characters of the line to the total character count.
            wordCount += findWordCount(s); //each iteration, add the words      of the line to the total word      count.
            lineCount++;                   //each iteration, add the line                   to the total line      count.
        }

        sc.close();

        //print out results
        System.out.println("The character count is " + charCount);
        System.out.println("The word count is " + wordCount);
        System.out.println("The line count is " + lineCount);
    }

    //find character count
    public static int findCharCount(String s){
       String[] characterString =s.split("");
       return characterString.length;
    }

    //find word count
    public static int findWordCount(String s){
        String[] word =s.split(" ");
        return word.length;
    }
}
