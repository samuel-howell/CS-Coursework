package com.company;
import java.util.Scanner;

public class DecToHex {
	//Samuel Howell CS 190L     10-4-19

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter a decimal number in the format xx.xx: ");
		String decimal = userInput.nextLine();
		int point = decimal.indexOf('.');

		//whole number
		String wholeNumber = decimal.substring(0, point);
		int wholeNumberDec = Integer.parseInt(wholeNumber);

		//Fraction
		String fractionNumber = decimal.substring(point + 1, decimal.length());
		double fraction = Double.parseDouble(fractionNumber);
		fraction = fraction * .01;																			//put the decimal back in front of the number

		//calculate hex of whole number
		int wholeHexRemainder;
		String userHexFormat = "";

		char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};		 //create an array for determining hex values

		//calculate hex of whole number portion
		do {
			wholeHexRemainder = wholeNumberDec % 16;                                         				//find remainder of the user input
			userHexFormat = hex[wholeHexRemainder] + userHexFormat;                       					// take aforementioned remainder and tack onto userHexFormat string
			wholeNumberDec /= 16;                             											   //update your original userInput for the next iteration by dividing it by sixteen

		} while (wholeNumberDec != 0);                                          						   // exit the loop when wholeNumberDec = 0

		//calculate hex of decimal portion
		double fracHexRemainder = 0;
		String userFracHexFormat = "";
		int count = 0;

		do{
			fracHexRemainder = fraction * 16;
			int truncFracHexRemainder = (int)fracHexRemainder;         								   //  truncate fracHexRemainder to get the what is on the left of the decimal point
			fraction = fracHexRemainder - truncFracHexRemainder;										//substract the original fracHexRemainder from the truncated version to get what is on the right side of the decimal point.
		userFracHexFormat = userFracHexFormat + hex[truncFracHexRemainder] ;   						 //add your hex value to the hex string
			count++;
		}while (count != 8);    																	//8 places after the decimal point

		System.out.println("The hex value is: " + userHexFormat + "." + userFracHexFormat);
	}
}

