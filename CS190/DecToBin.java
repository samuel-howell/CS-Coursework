package com.company;
import java.util.*;
public class DecToBin {
//Samuel Howell CS190

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	System.out.print("Please enter a decimal integer value: ");
	int userInput = input.nextInt();
	int userHexInput = userInput;
	int copy = userHexInput;
	int binRemainder;
	int hexRemainder;
	String userBinFormat = ""; 													// take all the remainders and tack them onto this string for the binary output
	String userHexFormat = "";												//take all the remainders and tack them onto this string for the binary output

	//Binary Value:
	do {
	    binRemainder = userInput % 2;   										 //find remainder of the user input
	    userBinFormat = binRemainder + userBinFormat;  						// take aforementioned remainder and tack onto userBinFormat string
		userInput = userInput / 2;     										//update your original userInput for the next iteration by dividing it by two
    } while (userInput != 0);       										 // exit the loop when userInput = 0

	System.out.println("Your number in binary code is " + userBinFormat);	// print binary format of the user's number


	//Hex Value:
		userHexInput = copy;

	char[] hex = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	do{
		hexRemainder = userHexInput % 16;   										 //find remainder of the user input
		userHexFormat = hex[hexRemainder] + userHexFormat;  						// take aforementioned remainder and tack onto userHexFormat string
		userHexInput /= 16;								//update your original userInput for the next iteration by dividing it by sixteen



	} while (userHexInput != 0);       										 // exit the loop when userInput = 0

		System.out.println("Your number in hex code is " + userHexFormat); 	// print hex format of the user's number
	}
}

