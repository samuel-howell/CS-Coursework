package com.company;

import java.util.Scanner;
import java.util.Stack;

/*
Names:  Samuel Howell, Javerea Neely
emails: samuel.howell@g.fmarion.edu, javerea.neely@g.fmarion.edu
Date: 9-17-20
File name: classProblem91720
Class: cs-227

Description: check and see if there is proper balance of grouping symbols in a given string.
 */
public class classProblem91720
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);                         //  initialize scanner

        System.out.print("enter a string: ");
        String input = sc.nextLine();                                // take the user input
        System.out.println("The statement \"There is a balanced amount of grouping symbols\" is " + checkGrouping(input));
    }

    public static boolean checkGrouping(String input)
    {
        Stack<Character> charStack = new Stack<>();                               //  initialize Stack to hold open grouping symbols
        for (int i = 0; i < input.length(); i++)                                  //  step through the string and process each character using for loop
        {
            char character = input.charAt(i);                                     //  single out each individual character in the string to be processed
            if (character == '{' || character == '[' || character == '(')         //  if the character is an opening grouping symbol, push it onto the charStack
            {
                charStack.push(character);
            } else if (character == ')')   //  handles parentheses
            {
                if (charStack.isEmpty() || charStack.pop() != '(') return false;
            } else if (character == ']')   //  handles brackets
            {
                if (charStack.isEmpty() || charStack.pop() != '[') return false;
            } else if (character == '}')   //  handles curly braces
            {
                if (charStack.isEmpty() || charStack.pop() != '{') return false;
            }
        }
        return charStack.isEmpty();
    }
}

