package com.junittestingcs227;

import static org.junit.Assert.*;

import org.junit.Test;

public class StandardDeviationTest {

	@Test
	public void standardDeviationTest() {
		 MyMathClass<Double> doubleList = new MyMathClass<>();

	        doubleList.list.add(1.0);
	        doubleList.list.add(2.0);
	        doubleList.list.add(3.0);
	        doubleList.list.add(4.0);

	        //  the assertEquals is the (expected, actual, delta).  The delta determines the margin of error.
	        assertEquals(1.118033988749895, MyMathClass.standardDeviation(doubleList.list), 0);

	        MyMathClass<Integer> intList = new MyMathClass<>();

	        intList.list.add(1);
	        intList.list.add(2);
	        intList.list.add(3);
	        intList.list.add(4);

	        assertEquals(1.118033988749895, MyMathClass.standardDeviation(intList.list), 0);
	}

}
