package com.company;

import java.util.Scanner;
//Samuel Howell CS190 Lab
//the computer position overrides user position
public class TicTacToeNovLab {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberPlays = 5;
        char M[][] = new char[7][7];
        System.out.println("User plays 'X'");
        System.out.println("Computer plays 'O'");
	    loadGrid(M);
        for(int i=0; i<=numberPlays; i++){
            UserPlays(M, scanner);
            printArray(M);
            checkForWinner(M);
            ComputerPlays(M);
            printArray(M);
            checkForWinner(M);
        }
        System.out.println("No winner!");

    }

    public static void loadGrid(char[][] M){
        //*** code to print initial grid ***
        M[0][0] = '-';  M[0][1] = '-'; M[0][2] = '-'; M[0][3] = '-'; M[0][4] = '-'; M[0][5] = '-'; M[0][6] = '-';
        M[1][0] = '|';  M[1][1] = ' '; M[1][2] = '|'; M[1][3] = ' '; M[1][4] = '|'; M[1][5] = ' '; M[1][6] = '|';
        M[2][0] = '-';  M[2][1] = '-'; M[2][2] = '-'; M[2][3] = '-'; M[2][4] = '-'; M[2][5] = '-'; M[2][6] = '-';
        M[3][0] = '|';  M[3][1] = ' '; M[3][2] = '|'; M[3][3] = ' '; M[3][4] = '|'; M[3][5] = ' '; M[3][6] = '|';
        M[4][0] = '-';  M[4][1] = '-'; M[4][2] = '-'; M[4][3] = '-'; M[4][4] = '-'; M[4][5] = '-'; M[4][6] = '-';
        M[5][0] = '|';  M[5][1] = ' '; M[5][2] = '|'; M[5][3] = ' '; M[5][4] = '|'; M[5][5] = ' '; M[5][6] = '|';
        M[6][0] = '-';  M[6][1] = '-'; M[6][2] = '-'; M[6][3] = '-'; M[6][4] = '-'; M[6][5] = '-'; M[6][6] = '-';

        for(int row = 0; row < M.length; row++){
            for(int column = 0; column < M[row].length; column++){
                System.out.print(M[row][column] + " ");
            }System.out.println();
        }
    }//end loadGrid


    public static char[][] UserPlays(char[][] M, Scanner scanner){
        System.out.print("Enter your grid position: ");
        boolean occupied = false;
        while(!occupied) {
            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    if (occupied(M[1][1])) break;
                    else {
                        M[1][1] = 'X';
                        occupied = true;
                        return M;
                    }

                case 2:
                    if (occupied(M[1][3])) break;
                    else {
                        M[1][3] = 'X';
                        occupied = true;
                        return M;
                    }

                case 3:
                    if (occupied(M[1][5])) break;
                    else {
                        M[1][5] = 'X';
                        occupied = true;
                        return M;
                    }

                case 4:
                    if (occupied(M[3][1])) break;
                    else {
                        M[3][1] = 'X';
                        occupied = true;
                        return M;
                    }

                case 5:
                    if (occupied(M[3][3])) break;
                    else {
                        M[3][3] = 'X';
                        occupied = true;
                        return M;
                    }

                case 6:
                    if (occupied(M[3][5])) break;
                    else {
                        M[3][5] = 'X';
                        occupied = true;
                        return M;
                    }

                case 7:
                    if (occupied(M[5][1])) break;
                    else {
                        M[5][1] = 'X';
                        occupied = true;
                        return M;
                    }

                case 8:
                    if (occupied(M[5][3])) break;
                    else {
                        M[5][3] = 'X';
                        occupied = true;
                        return M;
                    }

                case 9:
                    if (occupied(M[5][5])) break;
                    else {
                        M[5][5] = 'X';
                        occupied = true;
                        return M;
                    }

            }//end userChoice switch statement
        }//end while loop
                return M;
    }//end User Play

    public static void printArray(char[][] M){
        //*** code to print updated grid with players positions ***
        for(int row = 0; row < M.length; row++){
            for(int column = 0; column < M[row].length; column++){
                System.out.print(M[row][column] + " ");

            }System.out.println();
        }
    }//end printArray

    public static char[][] ComputerPlays(char[][] M){
        System.out.println("Computer selects grid position...");
        //*** computer play code ***
        boolean occupied = false;
        int timesComputerHasTried = 0;
        while (!occupied) {
            int computerChoice = (int)(Math.random() * 9 + 1);
            timesComputerHasTried++;

            if(timesComputerHasTried > 9){
                System.out.println("There aren't an more open spaces!");
                System.exit(1);
            }
            switch (computerChoice) {
                case 1:
                    if (occupied(M[1][1], "computer"))  break;
                    else {
                        M[1][1] = 'O';
                        occupied = true;
                        return M;
                    }

                case 2:
                    if (occupied(M[1][3], "computer")) break;
                    else {
                        M[1][3] = 'O';
                        occupied = true;
                        return M;
                    }

                case 3:
                    if (occupied(M[1][5], "computer")) break;
                    else {
                        M[1][5] = 'O';
                        occupied = true;
                        return M;
                    }

                case 4:
                    if (occupied(M[3][1], "computer")) break;
                    else {
                        M[3][1] = 'O';
                        occupied = true;
                        return M;
                    }

                case 5:
                    if (occupied(M[3][3], "computer")) break;
                    else {
                        M[3][3] = 'O';
                        occupied = true;
                        return M;
                    }

                case 6:
                    if (occupied(M[3][5], "computer")) break;
                    else {
                        M[3][5] = 'O';
                        occupied = true;
                        return M;
                    }

                case 7:
                    if (occupied(M[5][1], "computer")) break;
                    else {
                        M[5][1] = 'O';
                        occupied = true;
                        return M;
                    }

                case 8:
                    if (occupied(M[5][3], "computer")) break;
                    else {
                        M[5][3] = 'O';
                        occupied = true;
                        return M;
                    }

                case 9:
                    if (occupied(M[5][5], "computer")) break;
                    else {
                        M[5][5] = 'O';
                        occupied = true;
                        return M;
                    }
            }// end computerChoice switch statement
        }// end while loop
        return M;
    }//end Computer Play

    public static boolean occupied(char m){
        //*** code to check if position is occupied ***
        if ((m == 'X') || (m == 'O')){
            System.out.print("Position occupied - select again: ");
            return true;
        }   return false;
    } //end occupied

    public static boolean occupied(char m, String computer){
        //*** code to check if position is occupied ***
        if ((m == 'X') || (m == 'O'))return true;
            else return false;
    }//end occupied

    static void checkForWinner(char[][] M){
        //check for three consecutive columns
        //check for three consecutive rows
        //check the diagonals

        //check rows (for a user win)
        if((M[1][1] == 'X') && (M[1][3] == 'X') && (M[1][5] =='X')) { System.out.println("The user won the game!"); System.exit(0); }
        if((M[3][1] == 'X') && (M[3][3] == 'X') && (M[3][5] =='X')) { System.out.println("The user won the game!"); System.exit(0); }
        if((M[5][1] == 'X') && (M[5][3] == 'X') && (M[5][5] =='X')) { System.out.println("The user won the game!"); System.exit(0); }

        //check rows (for a computer win)
        if((M[1][1] == 'O') && (M[1][3] == 'O') && (M[1][5] =='O')) { System.out.println("The computer won the game!"); System.exit(0); }
        if((M[3][1] == 'O') && (M[3][3] == 'O') && (M[3][5] =='O')) { System.out.println("The computer won the game!"); System.exit(0); }
        if((M[5][1] == 'O') && (M[5][3] == 'O') && (M[5][5] =='O')) { System.out.println("The computer won the game!"); System.exit(0); }

        //check columns (for a user win)
        if((M[1][1] == 'X') && (M[3][1] == 'X') && (M[5][1] =='X')) { System.out.println("The user won the game!"); System.exit(0); }
        if((M[1][3] == 'X') && (M[3][3] == 'X') && (M[5][3] =='X')) { System.out.println("The user won the game!"); System.exit(0); }
        if((M[1][5] == 'X') && (M[3][5] == 'X') && (M[5][5] =='X')) { System.out.println("The user won the game!"); System.exit(0); }

        //check columns (for a computer win)
        if((M[1][1] == 'O') && (M[3][1] == 'O') && (M[5][1] =='O')) { System.out.println("The computer won the game!"); System.exit(0); }
        if((M[1][3] == 'O') && (M[3][3] == 'O') && (M[5][3] =='O')) { System.out.println("The computer won the game!"); System.exit(0); }
        if((M[1][5] == 'O') && (M[3][5] == 'O') && (M[5][5] =='O')) { System.out.println("The computer won the game!"); System.exit(0); }

        //check diagonals (for a user win)
        if((M[1][1] == 'X') && (M[3][3] == 'X') && (M[5][5] =='X')) { System.out.println("The user won the game!"); System.exit(0); }
        if((M[1][5] == 'X') && (M[3][3] == 'X') && (M[5][1] =='X')) { System.out.println("The user won the game!"); System.exit(0); }

        //check diagonals (for a computer win)
        if((M[1][1] == 'O') && (M[3][3] == 'O') && (M[5][5] =='O')) { System.out.println("The computer won the game!"); System.exit(0); }
        if((M[1][5] == 'O') && (M[3][3] == 'O') && (M[5][1] =='O')) { System.out.println("The computer won the game!"); System.exit(0); }
    }//end winner
}//end class

