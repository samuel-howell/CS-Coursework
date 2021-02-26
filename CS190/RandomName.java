package com.company;

import java.util.Arrays;

//random name generator
public class RandomName {
    public static void main(String[] args) {
        String name[][] = new String[7][7];
        loadGrid(name);
        createName(name);

    }

    public static void loadGrid(String[][] name){
        //*** code to print initial grid ***
        name[0][0] = "jerry";  name[0][1] = "jerry"; name[0][2] = "jerry"; name[0][3] = "jerry"; name[0][4] = "jerry"; name[0][5] = "jerry"; name[0][6] = "jerry";
        name[1][0] = "jerry";  name[1][1] = "jerry"; name[1][2] = "jerry"; name[1][3] = "jerry"; name[1][4] = "jerry"; name[1][5] = "jerry"; name[1][6] = "jerry";
        name[2][0] = "jerry";  name[2][1] = "jerry"; name[2][2] = "jerry"; name[2][3] = "jerry"; name[2][4] = "jerry"; name[2][5] = "jerry"; name[2][6] = "jerry";
        name[3][0] = "jerry";  name[3][1] = "jerry"; name[3][2] = "jerry"; name[3][3] = "jerry"; name[3][4] = "jerry"; name[3][5] = "jerry"; name[3][6] = "jerry";
        name[4][0] = "jerry";  name[4][1] = "jerry"; name[4][2] = "jerry"; name[4][3] = "jerry"; name[4][4] = "jerry"; name[4][5] = "jerry"; name[4][6] = "jerry";
        name[5][0] = "jerry";  name[5][1] = "jerry"; name[5][2] = "jerry"; name[5][3] = "jerry"; name[5][4] = "jerry"; name[5][5] = "jerry"; name[5][6] = "jerry";
        name[6][0] = "jerry";  name[6][1] = "jerry"; name[6][2] = "jerry"; name[6][3] = "jerry"; name[6][4] = "jerry"; name[6][5] = "jerry"; name[6][6] = "jerry";

       }


    public static void createName(String[][] firstName) {
        System.out.println(Arrays.toString(firstName[(int) (Math.random() * 5 + 1)]) + " " + (Arrays.toString(firstName[(int) (Math.random() * 5 + 1)])));
    }
}



