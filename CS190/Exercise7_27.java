package com.company;
//Samuel Howell 10-30-19

import java.util.Scanner;
import java.util.Arrays;

public class Exercise7_27 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //taking the user input and putting it in an array for list1
        System.out.println("Enter list1 size and contents: ");
        int[] list1 = new int[6];        //create int list

        for (int i = 0; i < list1.length; i++) {
            list1[i] = sc.nextInt();
        }

        //taking the user input and putting it in an array for list2
        System.out.println("Enter list2 size and contents: ");
        int[] list2 = new int[6];        //create int list

        for (int i = 0; i < list2.length; i++) {
            list2[i] = sc.nextInt();
        }



        //print whether the arrays are identical or not
        System.out.println("Two lists are" + (equals(list1, list2) ? " " : " not ")
                + "identical");
    }



    //compare the individual array positions to see if list1 and list2 are equal at each position
    public static boolean equals(int[] list1, int[] list2) {
        if (list1.length != list2.length) return false;


        //sort list1 and list2 into ascending order
        Arrays.sort(list1);
        Arrays.sort(list2);

        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != list2[i]) return false;
        }
        return true;
        Chapter 6,7
    }
}
