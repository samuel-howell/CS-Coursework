package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

/*
Name:           Samuel Howell
Date:           10-1-20
Class:          CS227
File:           MovieRatingProblem.java
Description:    Write a program that reads a file in a specific format, calculates the average rating for each movie listed in the file, and outputs the
                average rating along with the number of reviews.
 */
public class MovieRatingProblem
{

    public static void main(String[] args)
    {
        //  communicate with the file
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name (ex. movieRatings.txt) : ");
        String file = sc.nextLine();

        Scanner fileInput = null;
        try
        {
            fileInput = new Scanner(new File(file));                //  create a scanner to read what is on the file.
                                                                    //  NOTE: file must be in project folder, or exception will be thrown
        }
        catch (FileNotFoundException e)
        {
            System.out.println("The file was not found. Please check the file location and/or correct the format of your input.");
            System.exit(0);
        }

        //  finds out how many movie reviews are in the file.
        String totalReviews = fileInput.nextLine();

        HashMap<String, Integer> movieRatings = new HashMap<>();                //  create a hashmap to store the movies and their ratings
        HashMap<String, Integer> movieOccurrence = new HashMap<>();             //  create a HashMap to store the occurrence of the movies in the text file

        while (fileInput.hasNextLine())
        {

            String movie = fileInput.nextLine();
            Integer rating = Integer.parseInt(fileInput.nextLine());

            if (movieRatings.get(movie) == null)
            {
                movieRatings.put(movie, rating);                                //  enters in an initial key value pair (rating) in the hashMap
                movieOccurrence.put(movie, 1);                                  //  initialize the key value pair as having appeared once.
            } else
            {
                movieRatings.put(movie, movieRatings.get(movie) + rating);                                              //  updates the value (rating) in the hashmap
                movieOccurrence.put(movie, movieOccurrence.get(movie) + 1);                                             //  updates the count tracking how many times the movie has been reviewed.
            }

        }

        //  lambda expression that outputs the reviews and averages in the correct format.
        movieRatings.forEach((movie, rating) -> System.out.println(movie + ": " + movieOccurrence.get(movie) + " review(s), average of " + getAverage(movieRatings, movieOccurrence, movie)));
    }

    //  gets the average for the movie ratings.
    public static String getAverage(HashMap<String, Integer> movieRatings, HashMap<String, Integer> movieOccurrence, String movie)
    {
        DecimalFormat df = new DecimalFormat("###.#");                                                            //  set up the format of the numerator of the fraction
        return df.format((double) movieRatings.get(movie) / movieOccurrence.get(movie)) + "/5";                   //  return the result as String
    }
}