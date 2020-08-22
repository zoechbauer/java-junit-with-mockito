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

  @Test(expected = NullPointerException.class)
  public void testArraySort_NullPointerException() {
    final int[] numbers = null;
    Arrays.sort(numbers);
  }

  @Test(timeout = 100)
  public void testArraySort_Performance() {
    final int[] array = { 13, 7, 20, 5 };
    for (int i = 0; i < 1000000; i++) {
      array[0] = i;
      Arrays.sort(array);
    }
  }

}
