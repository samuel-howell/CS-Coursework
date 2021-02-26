package com.company;

import java.util.Scanner;

public class GrayCode {
//Samuel Howell      CS190 Lab       10-18-19
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	//ask user for string input and create a grayCode string
	System.out.println("Enter a binary value of length 2 to 16 bits");
    String userBin = sc.nextLine();
    String grayCodeStr = "";

    //print user response back out to user
    System.out.println("You entered " + userBin);

    int length = userBin.length();

    //throw error if string too long or short

        if(length > 8 || length < 2) {
        System.out.print("Input has the incorrect length");
        }

    //split the string into individual integer digits
        for (int i = length-2; i>=0; i--) {

            if(userBin.charAt(i) == '0'){                           //if 0, add the character to the right to the Gray Code string
                grayCodeStr = userBin.charAt(i+1) + grayCodeStr ;
            }

           else if(userBin.charAt(i) == '1'){

                if (userBin.charAt(i+1) == '1'){                     //if 1, and character to the right is one, add 0 to gray code string
                    grayCodeStr = '0' + grayCodeStr ;
                }
                else if(userBin.charAt(i+1) == '0'){                 //if 0, and character to the right is one, add 1 to gray code string
                    grayCodeStr = '1' + grayCodeStr;
                }
            }



        }


        System.out.println(userBin.charAt(0) + grayCodeStr);

    }
}
