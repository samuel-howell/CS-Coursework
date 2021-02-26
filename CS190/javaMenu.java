package com.company;

import java.util.Scanner;

public class javaMenu {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int option;
	while(true){
	    System.out.println("Select Option 1: Method 1");
        System.out.println("Select Option 2: Method 2");
        System.out.println("Select Option 3: Method 3");
        System.out.println("Select Option 4: Exit Program");
        option = input.nextInt();

        switch(option){
            case 1: method1(); break;
            case 2: method2(); break;
            case 3: method3(); break;
            case 4: System.exit(1);
        } //end switch
    }//end while
    }//end main

    public static void method1(){System.out.println("\nYou selected method1\n");}
    public static void method2(){System.out.println("\nYou selected method2\n");}
    public static void method3(){System.out.println("\nYou selected method3\n");}
}//end class
