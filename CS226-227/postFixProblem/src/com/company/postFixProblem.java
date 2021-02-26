import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/*
Name        :   Samuel Howell
Email       :   samuel.howell@g.fmarion.edu
Date        :   9-22-2020
File name   :   postFixProblem.java
Class       :   CS-227
Description :   **20.14 (Postfix notation) Postfix notation is a way of writing expressions without using parentheses.
                For example, the expression (1 + 2) * 3 would be written as 1 2 + 3 *. A postfix expression is evaluated using a stack.
                Scan a postfix expression from left to right. A variable or constant is pushed into the stack. When an operator is
                encountered, apply the operator with the top two operands in the stack and replace the two operands with the result.
 */
public class postFixProblem
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please follow the format as follows: [(1 + 2) * 3] would be written as [1 2 + 3 *].  Enter function to be evaluated:   ");

        String input = sc.nextLine();
        String[] inputArr = input.split(" ");        //  split at every space to separate the different parts o the function.

        solvePostFix(inputArr);
    }

    //  this method takes in a valid string Array, (created from a String containing a post-fix notation function) and calculates a result
    public static void solvePostFix(String[] inputArr)
    {
        double var1 = 0;
        double var2 = 0;
        double resultVar = 0;

        Stack<Double> varStack = new Stack<>();
        try
        {
            for (String element : inputArr)                     // step through each element in the String Array
            {
                switch (element)
                {
                    case "*":                                   //  handles multiplication
                        var1 = varStack.pop();
                        var2 = varStack.pop();
                        resultVar = var2 * var1;
                        varStack.push(resultVar);
                        break;

                    case "/":                                   //  handles division
                        var1 = varStack.pop();
                        var2 = varStack.pop();
                        resultVar = var2 / var1;
                        varStack.push(resultVar);
                        break;

                    case "+":                                   //  handles addition
                        var1 = varStack.pop();
                        var2 = varStack.pop();
                        resultVar = var2 + var1;
                        varStack.push(resultVar);
                        break;

                    case "-":                                    //  handles subtraction
                        var1 = varStack.pop();
                        var2 = varStack.pop();
                        resultVar = var2 - var1;
                        varStack.push(resultVar);
                        break;

                    default:                                    //  if the element is not an operator, try to add it as an double to the Stack.  Else,  gracefully exit the program.
                        try
                        {
                            var1 = Double.parseDouble(element);
                            varStack.push(var1);
                        }
                        catch (NumberFormatException ignored)
                        {
                        }
                }
            }

            //  output the result
            if (varStack.size() == 1)                                //  handles if the proper format was entered.  Outputs the answer.
            {
                System.out.println("result is " + varStack.pop());
            } else                                                   //  executes if there is more than one element left in the stack, indicating that the string was entered incorrectly.
            {
                System.out.println("Improper function structure");
            }
        }
        catch (EmptyStackException e)
        {
            System.out.println("Improper function structure.");
        }
    }
}
