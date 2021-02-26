package com.junittestingcs227;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AverageTest.class, StandardDeviationTest.class })
public class AllTests {

}
