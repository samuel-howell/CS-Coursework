package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ComplexNumberCodingAssignment {

    public static void main(String[] args) {
        System.out.print("Enter the first complex number: ");
        Complex number1 = newComplexNum();
        System.out.print("Enter the second complex number: ");
        Complex number2 = newComplexNum();

        //call the different method calculations
        System.out.println("///////////////////////////////////////////////////////////////");
        System.out.println();
        System.out.println("Addition: ");
        System.out.print(number1 + " + " + number2 + " = ");
        print(number1.add(number2));
        System.out.println();

        System.out.println("Subtraction: ");
        System.out.print(number1 + " - " + number2 + " = ");
        print(number1.subtract(number2));
        System.out.println();

        System.out.println("Multiplication: ");
        System.out.print(number1 + " * " + number2 + " = ");
        print(number1.multiply(number2));
        System.out.println();

        System.out.println("Division: ");
        System.out.print(number1 + " / " + number2 + " = ");
        print(number1.divide(number2));
        System.out.println();

        System.out.println("Absolute Value: ");
        System.out.print("|" + number1 + "| = ");
        System.out.println(number1.abs());
        System.out.println();
    }

    //format the print out on the console
    public static void print(Complex userNumber){
        DecimalFormat df = new DecimalFormat("##.####"); //formatting for decimal places
        if (userNumber.getImaginary() == 0) {
            System.out.println(df.format(userNumber.getReal()));
        } else {
            System.out.println(df.format(userNumber.getReal()) + " + " + df.format(userNumber.getImaginary()) + "i");
        }
    }

    //turn the user input into a complex number format
    public static Complex newComplexNum() {
        Scanner sc = new Scanner(System.in);
        double[] userInputArray = new double [2];
        for (int i = 0; i < userInputArray.length; i++) {
            userInputArray[i] = sc.nextDouble();
        }
        return new Complex(userInputArray[0], userInputArray[1]);
    }

    static class Complex implements Comparable<Complex>{
        private double a;
        private double b;

        //constructors
        public Complex(){
            this(0,0);
        }
        public Complex(double a){
            this (a, 0);
        }
        public Complex(double a, double b){
            this.a = a;
            this.b = b;

        }
        //get a and b values separately for calculation purposes
        public double getReal() {
            return a;
        }
        public double getImaginary(){
            return b;
        }

        //calculations
        //(a + c) + (b + d)i
        public Complex add(Complex secondComplexNum){
            return new Complex(a + secondComplexNum.a, b + secondComplexNum.b);
       }
        //(a + c) + (b + d)i
        public Complex subtract(Complex secondComplexNum){
            return new Complex(a - secondComplexNum.a, b - secondComplexNum.b);
       }
        //(ac - bd) + (bc + ad)i
       public Complex multiply(Complex secondComplexNum){
            return new Complex(((a * secondComplexNum.a) - (b * secondComplexNum.b)) , ((b * secondComplexNum.a) + a * secondComplexNum.b));
       }
        //(ac + bd)/(c2 + d2) + (bc - ad)i/(c2 + d2)
       public Complex divide(Complex secondComplexNum){
            return new Complex(
                    (a * secondComplexNum.a + b * secondComplexNum.b) /
                    (Math.pow(secondComplexNum.a, 2) + Math.pow(secondComplexNum.b, 2)) ,
                    (b * secondComplexNum.a - a * secondComplexNum.b) /
                            (Math.pow(secondComplexNum.a, 2) + Math.pow(secondComplexNum.b, 2)));
       }
         //|a + bi| = √(a^2 + b^2)
        public double abs(){
            return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        }

        //string override.  If b is 0 then just print out a as a string, if b isn't equal to 0, then print out a + bi as a string.
        @Override
        public String toString() {
            return b == 0 ? a + "" : "(" + a + " " + b + "i)" ;
        }


        @Override
        public int compareTo(Complex o) {
            if (abs() > o.abs()) return 1;
            else if (abs() < o.abs()) return -1;
            else return 0;
        }
    }
}
