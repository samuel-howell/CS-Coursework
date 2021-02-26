package com.company;


import java.util.Scanner;
public class TicTacToe{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numberPlays = 5;
        char M[][] = new char[7][7];
        System.out.println("User plays 'X'");
        System.out.println("Computer plays 'O'");
        loadGrid(M);
        printArray(M);
        for(int i=0; i<=numberPlays; i++){
            UserPlays(M, scanner);
            printArray(M);
            checkForWinner(M);
            ComputerPlays(M);
            printArray(M);
            checkForWinner(M);
        }
        System.out.println("No winner!");
    }//end main

    public static char[][] UserPlays(char[][] M, Scanner scanner){
        System.out.print("Enter your grid position: ");
	//*** user play code ***
        return M;
    }//end User Play

    public static char[][] ComputerPlays(char[][] M){
        System.out.println("Computer selects grid position...");
	//*** computer play code ***
        return M;
    }//end Computer Play

    public static void printArray(char[][] M){
	//*** code to print updated grid with players positions ***
    }//end printArray

    public static void loadGrid(char[][] M){
	//*** code to print initial grid ***
        for(int row = 0; row < M.length; row++){
            for(int column = 0; column < M[row].length; column++){
                M[row][column] = 'v';
                System.out.print(M[row][column] + " ");

            }System.out.println();
        }
    }//end loadGrid

    public static boolean occupied(char m){
	//*** code to check if position is occupied ***
    }//end occupied

    public static boolean occupied(char m, String computer){
	//*** code to check if position is occupied ***
    }//end occupied

    static void checkForWinner(char[][] M){
        //check for three consecutive columns
        //check for three consecutive rows
        //check the diagonals
        //use if statements if m[3,3] ||  m[3,3] ||  m[3,3]
    }//end winner
}//end class