package com.company;

import java.util.*;

/*
Name:      Samuel Howell
Email:     samuel.howell@g.fmarion.edu
Date:      8-25-20
File name: StringPermutation.java
Class:     CS-227

Description: Write a recursive method to print all the permutations of a string.
 */

public class StringPermutation
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string to be permutated: ");
        String s = sc.nextLine();
        System.out.println("Printing permutations of " + s + "...");
        displayPermutation(s);         //  call the initial recursive method  
    }
    public static void displayPermutation(String s)
    {
        displayPermutation(" ", s);    //  call the recursive helper method
    }  

    public static void displayPermutation(String s1, String s2)
    {
        if(s2.isEmpty())                //  base case
        {
            System.out.println(s1);
        }
        else
        {
            for(int i = 0; i < s2.length(); i++)
            {
                displayPermutation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));        /*
                                                                                                            NOTE: this is a somewhat psuedo-explanation (just to talk myself through
                                                                                                             the gist of what is happening).

                                                                                                            In this line of logic, I (basically) make 3 instances of s1, containing  a, b, and c
                                                                                                            respectively. Those then become the new s1's in the recursive call, while the new s2's
                                                                                                            consists of bc, then ac, then ab as i increases. We see these s2's are combined with their
                                                                                                            respective s1's to form the first, third, and fifth lines of output.

                                                                                                            BUT...before we move to the 3rd line we have to deal with the 2nd
                                                                                                            line. To get the 2nd, 4th, and 6th lines, we know that, due to the recursive nature
                                                                                                            of the function, before the program can move to an s1 that begins with a different
                                                                                                            character, it must exhaust all the combinations of the remaining characters
                                                                                                            to the right of it, (thus we get aBC and aCB before we can move
                                                                                                            to a s1 beginning with "b")
                                                                                                        */
            }
        }
    }
}
