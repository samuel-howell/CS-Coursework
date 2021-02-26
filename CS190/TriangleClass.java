package com.company;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

//Samuel Howell 3-2-20
public class TriangleClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter side 1 (or base if applicable) of triangle: ");
        double base = sc.nextDouble();

        System.out.println("Enter side 2 (or height if applicable) of triangle: ");
        double height = sc.nextDouble();

        System.out.println("Enter side 3 (or hypotenuse if applicable) of triangle: ");
        double hypotenuse = sc.nextDouble();

        //check to make sure the user input creates a real triangle
        if(hypotenuse < base){
            System.out.println("A triangle's hypotenuse cannot be less than its base.");
            System.exit(1);
        }
        if(hypotenuse < height){
            System.out.println("A triangle's hypotenuse cannot be less than its height.");
            System.exit(2);
        }

        System.out.println("Is triangle filled? (true/false)");
        boolean fill = sc.nextBoolean();

        System.out.println("What is the triangle's color?");
        String color = sc.next();

        System.out.println();

        //load all these values from scanner into the triangle constructor
        Triangle triangle = new Triangle(base, height, hypotenuse, color, fill);

        System.out.println(triangle);
    }
}
abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    /** Construct a default geometric object */
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    /** Construct a geometric object with color and filled value */
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    /** Return color */
    public String getColor() {
        return color;
    }

    /** Set a new color */
    public void setColor(String color) {
        this.color = color;
    }

    /** Return filled. Since filled is boolean,
     *  the get method is named isFilled */
    public boolean isFilled() {
        return filled;
    }

    /** Set a new filled */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /** Get dateCreated */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "color: " + color +
                "\nfilled: " + filled + "\ncreated on " + dateCreated;
    }

    /** Abstract method getArea */
    public abstract double getArea();

    /** Abstract method getPerimeter */
    public abstract double getPerimeter();
}

class Triangle extends GeometricObject {
    private double base;
    private double height;
    private double hypotenuse;

    //create a constructor to hold initial values
    Triangle(double base, double height, double hypotenuse, String color, boolean fill){
       this.base = base;
       this.height = height;
       this. hypotenuse = hypotenuse;
       setColor(color);
       setFilled(fill);
    }

    //setters and getters
    public double getBase(){
        return this.base;
    }
    public double getHeight(){
        return this.height;
    }
    public double getHypotenuse(){
        return this.hypotenuse;
    }
    public void setBase(double base){
        this.base = base;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setHypotenuse(double hypotenuse){
        this.hypotenuse = hypotenuse;
    }

    //use pythagorean theorem to check and see if the user input creates a right triangle
    public boolean isRightTriangle(){
        return (Math.pow(base, 2) + Math.pow(height, 2)) == hypotenuse;
    }

    //override methods
    @Override
    public double getArea() {
        //using Heron's formula
        double area = (base + height + hypotenuse) / 2.0;
        return Math.pow(area*(area-base)*(area-height)*(area-hypotenuse), 1.0/2.0);
    }

    @Override
    public double getPerimeter() {
        double perimeter = base + height + hypotenuse;
        return perimeter;
    }

    //print final output
    public String toString(){
        return "The final output is:" +
                "\narea: " + getArea() +
                "\nperimeter: " + getPerimeter() +
                "\nIs it a right triangle? " + isRightTriangle() +
                "\n" + super.toString();
    }
}
