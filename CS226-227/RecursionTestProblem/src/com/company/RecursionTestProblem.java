package com.company;

public class RecursionTestProblem
{
    /*
    Name       :  Samuel Howell
    Email      :  samuel.howell@g.fmarion.edu
    Date       :  9-3-20
    File       :  RecursionTestProblem.java
    Class      :  CS227

    Description: creates a program that has a recursive method and an iterative method that are designed to calculate the number of handshakes
                 that would occur if every person in the room shook hands with every other person once.
     */

    public static void main(String[] args)
    {
        System.out.println("The result of the handshakeRecursion method is " + handshakeRecursion(5));         //  handshakeRecursion test case
        System.out.println("The result of the handshakeIteration method is " + handshakeIteration(5));         //  handshakeIteration test case
    }


    /*
    What does this method do?
        This class uses recursion to find the number of handshakes that would occur if every person in a room shook hands with every other person once.
        This number is calculated recursively by calling the handshakeRecursion() method inside of itself in order to split the overall
        problem into smaller sub-problems, with the base case being less than 2 people in the room.
     */
    public static int handshakeRecursion(int people)
    {
        if (people < 2)                                                       //  base case
        {
            return 0;
        }
         else
        {
            return (people - 1) + handshakeRecursion(people - 1);       //  recursive call
        }
    }


    /*
    What does this method do?
        This class uses iteration to find the number of handshakes that would occur if every person in a room shook hands with every other person once.
        This number is calculated iteratively by using an i value in a for loop to gradually "build up" to the required number of people, calculating and updating
        the total number of handshakes after each iteration.
     */
    public static int handshakeIteration(int people)
    {
        int handshakes = 0;                                                    // initializes handshakes

        if (people == 2)                                                       // handles the only case that isn't calculated by the function correctly
        {
            handshakes = people - 1;
        }
        else
        {
            for (int i = 0; i <= people; i++)                                  // use a for loop to calculate the handshakes as i increases
            {
                handshakes = (i * (i - 1)) / 2;
            }
        }
        return handshakes;
    }
}

