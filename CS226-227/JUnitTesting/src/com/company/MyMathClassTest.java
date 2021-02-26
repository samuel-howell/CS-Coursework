package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathClassTest
{

    @Test
    void standardDeviation()
    {
        MyMathClass<Double> doubleList = new MyMathClass<>();

        doubleList.list.add(1.0);
        doubleList.list.add(2.0);
        doubleList.list.add(3.0);
        doubleList.list.add(4.0);

        assertEquals(1.118033988749895, MyMathClass.standardDeviation(doubleList.list));

        MyMathClass<Integer> intList = new MyMathClass<>();

        intList.list.add(1);
        intList.list.add(2);
        intList.list.add(3);
        intList.list.add(4);

        assertEquals(1.118033988749895, MyMathClass.standardDeviation(intList.list));
    }

    @Test
    void getAverage()
    {

        MyMathClass<Double> doubleList = new MyMathClass<>();

        doubleList.list.add(1.0);
        doubleList.list.add(2.0);
        doubleList.list.add(3.0);
        doubleList.list.add(4.0);

        assertEquals(2.5, MyMathClass.getAverage(doubleList.list));

        MyMathClass<Integer> intList = new MyMathClass<>();

        intList.list.add(1);
        intList.list.add(2);
        intList.list.add(3);
        intList.list.add(4);

        assertEquals(2.5, MyMathClass.getAverage(intList.list));
    }
}