package com.junittestingcs227;

import java.util.ArrayList;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

/*
 * Name:	Samuel Howell
 * Date: 	11-10-20
 * Class:	CS227
 * File:	JUnitTesting.java
 */
public class JUnitTesting{

    public static void main(String[] args) {

        // initialize lists
        MyMathClass<Double> doubleList = new MyMathClass<>();
        MyMathClass<Integer> intList = new MyMathClass<>();
        MyMathClass<Long> longList = new MyMathClass<>();
        //MyMathClass<String> strList = new MyMathClass<>();

        //driver code
        doubleList.list.add(1.0);
        doubleList.list.add(2.0);
        doubleList.list.add(3.0);
        doubleList.list.add(4.0);


        System.out.println("the average for doubleList is " + MyMathClass.getAverage(doubleList.list));
        System.out.println("the standard deviation is: " + MyMathClass.standardDeviation(doubleList.list));

        intList.list.add(1);
        intList.list.add(2);
        intList.list.add(3);
        intList.list.add(4);

        System.out.println("the average for intList is " + MyMathClass.getAverage(intList.list));
        System.out.println("the standard deviation is: " + MyMathClass.standardDeviation(intList.list));

        longList.list.add(1L);
        longList.list.add(2L);
        longList.list.add(3L);
        longList.list.add(4L);

        System.out.println("the average for longList is " + MyMathClass.getAverage(longList.list));
        System.out.println("the standard deviation is: " + MyMathClass.standardDeviation(longList.list));

//		strList.list.add("1");
//		strList.list.add("2");
//		strList.list.add("3");
//		strList.list.add("4");
//
//		//generates compile time error because String is not a part of Number or any of its subclasses.
//		System.out.println(intList.getAverage(strList.list));
//		System.out.println("the standard deviation is: " + strList.standardDeviation(strList.list));
    }

}


//write a generic class named MyMathClass
class  MyMathClass<T extends Number>
{
    ArrayList<T> list = new ArrayList<>();

    //default constructor
    MyMathClass()
    {

    }

    //constructor that takes in a list
    MyMathClass(ArrayList<T> list)
    {
        this.list = list;
    }

    //  this method finds the standard deviation
    public static double standardDeviation (ArrayList<? extends Number> list)
    {
        double average = getAverage(list);
        double result = 0;
        for (Number number : list) {
            result += Math.pow(number.doubleValue() - average, 2);
        }
        return Math.sqrt(result / list.size());
    }

    //  this method finds the average and returns a double
    public static double getAverage(ArrayList<? extends Number> list)
    {
        double sum = 0;

        for (Number number : list) {
            sum += number.doubleValue();
        }

        return sum / list.size();
    }
}


