package com.in28minutes.junit.helper;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

  @Test
  public void testArraySort_RandomArray() {
    final int[] numbers = { 13, 3, 4, 11 };
    final int[] expected = { 3, 4, 11, 13 };
    Arrays.sort(numbers);
    assertArrayEquals(expected, numbers);
  }

}
