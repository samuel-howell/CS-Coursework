
package com.company;

        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        while(true){
            System.out.println("Select Option 1: Method 1");
            System.out.println("Select Option 2: Method 2");
            System.out.println("Select Option 3: Method 3");
            System.out.println("Select Option 4: Method 4");
            System.out.println("Select Option 5: Exit Program");
            option = input.nextInt();

            switch(option){
                case 1: method1(); break;
                case 2: method2(); break;
                case 3: method3(); break;
                case 4: method4(); break;
                case 5: System.exit(1);
            } //end switch
        }//end while
    }//end main

    public static void method1(){
        int i;
        String result = "";
        for(i=1; i<=6; i++) {
            result = result + i + " ";
            System.out.println(result);
        }//end for loop
    }//end of method 1

    public static void method2(){
        int i;
        int j;
        String result = "";
        for(i=6; i>=1; i--) {
            for(j=1; j<=i; j++){
                System.out.print(j + " ");
            }//end of for loop
            System.out.println();
        }//end for loop
    }//end of method 2

    public static void method3() {

        int numberOfLines = 6;
        for (int rows = 1; rows <= numberOfLines; rows++) {         //print rows
            for (int s = numberOfLines - rows; s >= 1; s--) {
                System.out.print("  ");             //print white space
            }
            for (int col = rows; col >= 1; col--) {         //print columns and numbers
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }




        public static void method4(){

            int numberOfLines = 6;
            for (int rows = 0; rows < 6; rows++) {                  //print rows
                for (int whiteSpace = 0; whiteSpace < rows; whiteSpace++) {        //print white space
                    System.out.print("  ");
                }
                for (int col = 0; col < 6 - rows; col++) {     //print numbers
                    System.out.print((col + 1) + " ");
                }
                System.out.println();
            }
    }
}//end class