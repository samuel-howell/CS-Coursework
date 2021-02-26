package com.company;

import java.util.Arrays;


//--->Samuel Howell //
//_______________________//
public class RemoveDuplicatesLab {
    public static void main(String[] args){

       int[] list = {2,5,7,5,3,8,2,8,5,10,2,3};

        printArray(list);  //print original list
        Arrays.sort(list); //use sort method of Arrays class
        printArray(list);  //print sorted list
        while(moreDuplicates(list))removeDuplicates(list);
        printArray(list);  //print list with no duplicates
   }//end main

    public static void printArray( int[] list ){
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + ",");
        }
        System.out.println();
    }//end printArray

    //remove all repeated occurrences of a individual value
    public static void removeDuplicates( int[] list ){
        for (int i = 0; i < list.length - 1; i++){
            for (int j = i + 1; j < list.length; j++){
                if (list[i] == list[j]) {
                    list[j] =0;
                    for (int k = j; k < list.length - 1; k++){      //creating a subarray
                        list[k] = list[k + 1];
                        list[k + 1] = 0;
                    }
                }
            }
        }

    }//end removeDuplicates

    public static boolean moreDuplicates( int[] list ) {
        int zero = list.length;
        for(int i = 0; i < list.length - 1; i++){
            if (list[i] == 0){
                zero = i;
                break;
            }
        }
        for (int i = 0; i < zero; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] == list[j]) return true;
            }
        }return false;
    }
}//end class