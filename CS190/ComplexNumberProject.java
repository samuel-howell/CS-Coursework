package com.company;

//Samuel Howell 3-9-20
import java.util.Scanner;

public class ComplexNumberProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the first complex number: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        Complex complexNum1 = new Complex(a, b);
        System.out.print("Enter the second complex number: ");
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        Complex complexNum2 = new Complex(c, d);

        //print out addition
        System.out.println(complexNum1.toString() + " + " + complexNum2.toString() + " = " + complexNum1.add(complexNum2));
        //print out subtraction
        System.out.println(complexNum1.toString() + " - " + complexNum2.toString() + " = " + complexNum1.subtract(complexNum2));
        //print out multiplication
        System.out.println(complexNum1.toString() + " * " + complexNum2.toString() + " = " + complexNum1.multiply(complexNum2));
        //print out division
        System.out.println(complexNum1.toString() + " / " + complexNum2.toString() + " = " + complexNum1.divide(complexNum2));
        //print out absolute value
        System.out.println("|" + complexNum1 + "|" + " = " + complexNum1.abs());
        //print out comparison
        System.out.println("compareTo output: " + complexNum1.compareTo(complexNum2));
    }

    static class Complex implements Comparable<Complex>{
        private double a; //real
        private double b; //imaginary

        //three constructors
        public Complex(){
        }
        public Complex (double a, double b){
            this.a = a;
            this.b = b;
        }
        public Complex (double a){
            this.a = a;
            b = 0;
        }

        //getters
        public double getA(){
            return a;
        }
        public double getB(){
            return b;
        }

        /*
        Calculations:
        a = a
        b = b
        c = num2.a
        d = num2.b
         */
        //addition -> (a + c) + (b + d)i
        public Complex add(Complex num2){
            return new Complex(a + num2.a, b + num2.b);
        }
        //subtraction -> (a - c) + (b - d)i
        public Complex subtract(Complex num2){
            return new Complex(a - num2.a, b - num2.b);
        }
        //multiplication -> (ac - bd) + (bc + ad)i
        public Complex multiply(Complex num2){
            return new Complex(a*num2.a - b*num2.b, b*num2.a + a*num2.b);
        }
        //division -> (ac + bd)/(c^2 + d^2) + (bc - ad)i/(c^2 + d^2)
        public Complex divide(Complex num2){
            return new Complex((a*num2.a + b*num2.b)/(Math.pow(num2.a, 2) + Math.pow(num2.b, 2)) , (b*num2.a - a*num2.b)/(Math.pow(num2.a, 2) + Math.pow(num2.b, 2)));
        }
        //absolute value -> √(a^2 + b^2)
        public double abs(){
            return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        }

        @Override //  If b is 0 then just print out a as a string, if b isn't equal to 0, then print out a + bi as a string.
        public String toString() {
            return b == 0 ? a + "" : "(" + a + " + " + b + "i)";
        }

        @Override
        public int compareTo(Complex o) {
            if (abs() > o.abs()) return 1;
            else if (abs() < o.abs()) return 0;
            else return 0;
        }
    }
}