package com.in28minutes.junit.helper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {

  @BeforeClass
  public static void setUpBeforeClass() {
    System.out.println("Setup Before Class");
  }

  @AfterClass
  public static void tearDownAfterClass() {
    System.out.println("TearDown After Class");
  }

  @Before
  public void setUp() {
    System.out.println("Setup Before Test");
  }

  @After
  public void tearDown() {
    System.out.println("TearDown After Test");
  }

  @Test
  public void test1() {
    System.out.println("Test 1 executed");
  }

  @Test
  public void test2() {
    System.out.println("Test 2 executed");
  }

}

// Console Output
//Setup Before Class
//Setup Before Test
//Test 1 executed
//TearDown After Test
//Setup Before Test
//Test 2 executed
//TearDown After Test
//TearDown After Class
