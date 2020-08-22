package com.in28minutes.junit.helper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArraysCompareTest.class, QuickBeforeAfterTest.class, StringHelperParamized2Test.class,
    StringHelperParamizedTest.class, StringHelperTest.class })
public class AllTests {

}
