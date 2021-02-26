package com.company;


//--->Samuel Howell //
//_______________________//
import java.util.Arrays;
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] list = {2, 5, 7, 5, 3, 8, 2, 8, 5, 10, 2, 3}; //size of the array is 12
        printArray(list);  //print original list
        Arrays.sort(list); //use sort method of Arrays class
        printArray(list);  //print sorted list
        while (moreDuplicates(list)) removeDuplicates(list);
        printArray(list);  //print list with no duplicates
    }//end main

    public static void printArray(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + ",");
        }
        System.out.println();
    }//end printArray

    public static void removeDuplicates(int[] list) {
        System.out.println("Screw you Jerry");
       for (int i = 0; i < list.length - 1; i++) {
           System.out.println("     i is " + i);
           for (int j = i + 1; j < list.length; j++) {
               System.out.println("j is " + j);
               if (list[i] == list[j]) {
                   list[i] = 0;
               }
           }
       }
    }//end removeDuplicates

    public static boolean moreDuplicates(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for(int j = i+1; j < list.length; j++) {
                System.out.println("yes");
                if (list[i] == list[j]) return true;
            }
        }//end moreDuplicates
        return false;
    }//end class
}
/*
1.sort
2. remove dupes
3. shift left
4. pad zeroes
 */