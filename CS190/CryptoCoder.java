//Samuel Howell
//idea came from https://stackoverflow.com/questions/21290382/creating-a-simple-encryption-program
/*d like to use java to make a cipher of sorts, but im not sure how to go about it.

Basically, I'd want the machine to accept a string of text, say "Abcd"

and then a key, say '4532'

The program should move the characters forward in the alphabet if the number matching the place of the letter is even, and backward if it's odd.

If there is no number, the key should loop around until it's out of characters in the string to change.

the program would then print the key. Ideally, if im pseudocoding this correctly, deciphering the string would be a reverse process only applicable with the key.

I'm guessing i'd use a combination of an array and if/else statements.

I'm not sure where to start.

Example & edit String: 'hello' Key: '12'

a b c d e f g h i j k l m n o p q r s t u v w x y z

Because the corresponding key value is 1, h will travel backwards that many spaces.

h = g

because e has a 2, it'll move forward that many spaces.

e = g

the first l then becomes k, while the second becomes n. The Key is repeated because the string is out of numbers to compare. o turns into n because it's matched with 1.

hello would become ggknn with the key 42.

 */


package com.company;

import java.util.Scanner;

public class CryptoCoder {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

    System.out.println("Enter a word: ");
    String userStr = sc.nextLine();


    System.out.println(userStr);

    }
}
