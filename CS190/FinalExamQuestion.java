package com.company;

import java.util.Scanner;
//Samuel Howell   CS190 Final Exam Coding Assignment    11-25-19
public class FinalExamQuestion {

    public static void main(String[] args) {

        //initializing and converting user input to char arrays
        Scanner input = new Scanner(System.in);
        System.out.print("Enter message: ");
        String message = input.nextLine();
        char[] messageArray = message.trim().toLowerCase().toCharArray();
        System.out.print("enter keyword: ");
        String key = input.nextLine();
        char[] keyArray = key.toLowerCase().replaceAll(" ", "").toCharArray();

        //final output
        String convertedMessage = String.valueOf(encryptMessage(messageArray, keyArray));         //take the returned char[] convertedMessage and transform it into a string
        System.out.println();

//################################################################################################################################################################
        //create a finalKey string that shows the iteration the key over the message and includes the spaces
        String finalKey = "";
        int counter = 0;
        for (int i = 0; i < message.length(); i++){
            if(messageArray[i] == ' ') {
                finalKey = finalKey + ' ';
            }
            else {
                finalKey = finalKey + (keyArray[counter]);
                counter++;
            }
            if (counter == keyArray.length) counter = 0;
            }
//################################################################################################################################################################

        System.out.println(finalKey.toUpperCase());
        System.out.println(convertedMessage.toUpperCase());
        System.out.println(message.toUpperCase());
    }

    //the logic portion
    public static char[] encryptMessage(char[] messageArray, char[] keyArray) {
        char[] convertedMessage = new char[messageArray.length];

        for (int x = 0, y = 0; x < messageArray.length; x++) {
            char characterOfMessage = messageArray[x];
            char characterOfKey = keyArray[(y % keyArray.length)];

            if (characterOfMessage == ' ') {
                convertedMessage[x] = ' ';
            }
            else {
                /*  By casting to int and subtracting 97, the ASCII codes are converted to 0 - 25.
                    Because it's an int, dividing the characterOfKey by 2 will make every two letters (ex. "A,B" , "C,D" , etc.) one row.
                    casting the characterOfMessage to int and subtracting 97 will tell the computer which column to use.

                    Increment the y to move to the next character position in the key
                 */
                convertedMessage[x] = portaCypherTableau[(((int)characterOfKey)-97) / 2][((int)characterOfMessage)-97];
                y++;
            }
        }   return convertedMessage;
    }

    //                                                    Keys        a    b    c    d    e    f    g    h    i    j    k    l    m    m    o    p    q    r    s    t    u    v    w    x    y    z
    public static final char  portaCypherTableau[][] = /* A,B */   {{'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm' },
                                                       /* C,D */    {'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'n', 'm', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l' },
                                                       /* E,F */    {'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'n', 'o', 'l', 'm', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k' },
                                                       /* G,H */    {'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'n', 'o', 'p', 'k', 'l', 'm', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' },
                                                       /* I,G */    {'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'n', 'o', 'p', 'q', 'j', 'k', 'l', 'm', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
                                                       /* K,L */    {'s', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'n', 'o', 'p', 'q', 'r', 'i', 'j', 'k', 'l', 'm', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' },
                                                       /* M,N */    {'t', 'u', 'v', 'w', 'x', 'y', 'z', 'n', 'o', 'p', 'q', 'r', 's', 'h', 'i', 'j', 'k', 'l', 'm', 'a', 'b', 'c', 'd', 'e', 'f', 'g' },
                                                       /* O,P */    {'u', 'v', 'w', 'x', 'y', 'z', 'n', 'o', 'p', 'q', 'r', 's', 't', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'a', 'b', 'c', 'd', 'e', 'f' },
                                                       /* Q,R */    {'v', 'w', 'x', 'y', 'z', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'a', 'b', 'c', 'd', 'e' },
                                                       /* S,T */    {'w', 'x', 'y', 'z', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'a', 'b', 'c', 'd' },
                                                       /* U,V */    {'x', 'y', 'z', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'a', 'b', 'c' },
                                                       /* W,X */    {'y', 'z', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'a', 'b' },
                                                       /* Y,Z */    {'z', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'a' }};
}