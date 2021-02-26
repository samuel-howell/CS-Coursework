

import java.util.Arrays;

public class EvenOddArray{
//Samuel Howell 11-6-19
    public static void main(String[] args) {

        //read command line arguments
        int rows = Integer.parseInt(args[0]);
        System.out.println("rows are " + rows);
        int columns = Integer.parseInt(args[1]);
        System.out.println("columns are " + columns);

        //initialize the array
        int[][] array = new int [rows][columns];

        //call method to print a array (unsorted)
        System.out.println("Loaded Array");
        int[][] unsortedArray = loadUnsortedArray(array);

        // print a space divider between unsorted and sorted array
        System.out.println();

        //call method to print a array (sorted)
        System.out.println("Loaded and Sorted Array");
        int[][] SortedArray = loadSortedArray(array);



    }

    //method to load the array with random numbers
    public static int[][]  loadUnsortedArray(int[][]array){
        for(int row = 0; row < array.length; row++){
            for(int column = 0; column < array[row].length; column++){
                array[row][column] = (int)(Math.random() * 9) +1;
                System.out.print(array[row][column] + " ");
            } System.out.println();
        }return array;
    }

    //method to sort the Unsorted array
    public static int[][]  loadSortedArray(int[][]unsortedArray){
        for(int row = 0; row < unsortedArray.length; row++){
            for(int column = 0; column < unsortedArray[row].length; column++){
               Arrays.sort(unsortedArray[column]);
                System.out.print(unsortedArray[row][column] + " ");
            } System.out.println();
        }return unsortedArray;
    }
}
