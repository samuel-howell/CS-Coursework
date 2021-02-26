package com.company;

/*
Samuel Howell 3-4-20
define a class named ComparableCircle that extends circle and implements Comparable. Implement the compareTo method to compare the circles on the area.
Write a test class to find the larger of the two instances of ComparableCircle objects.
 */
public class ComparableCircleProject {

    public static void main(String[] args) {
	comparableCircle circle1 = new comparableCircle(3);
	comparableCircle circle2 = new comparableCircle(4);
        System.out.println("Circle 1... " + circle1.toString());
        System.out.println();
        System.out.println("Circle 2... " + circle2.toString());
        System.out.println();

        //find the largest circle. If compareTo() = 1, print Circle 1 + "is the largest", otherwise
        if(circle1.compareTo(circle2) == 0){
            System.out.println("The circles are equal.");
        }
        else
            //if compareTo() = 1, add "Circle 1" to the sysout, otherwise add "Circle 2"
            System.out.println((circle1.compareTo(circle2) == 1 ? "Circle 1 " : "Circle 2 ") + "is the largest.") ;
    }
}

class Circle {
    //instance variables
    private double radius;

    //make the circle constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
    public String toString(){
        return "\nradius: " + radius + "\narea: " + getArea();
    }
}

class comparableCircle extends Circle implements Comparable<comparableCircle> {

    public comparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(comparableCircle o) {
        if (getArea() > o.getArea()) return 1;
        if (getArea() < o.getArea()) return -1;
        else return 0;
    }
}

