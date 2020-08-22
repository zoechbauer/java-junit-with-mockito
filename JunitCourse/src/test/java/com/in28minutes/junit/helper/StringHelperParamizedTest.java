package com.in28minutes.junit.helper;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParamizedTest {

  private final String input;
  private final String expectedOutput;

  public StringHelperParamizedTest(String input, String expectedOutput) {
    this.input = input;
    this.expectedOutput = expectedOutput;
  }

  @Parameters
  public static Collection<String[]> testConditions() {
    // AACD => CD, ACD => CD, CDEF => CDEF, CDAA => CDAA
    final String[][] expectedOutputs = { { "AACD", "CD" }, { "ACD", "CD" }, { "CDEF", "CDEF" }, { "CDAA", "CDAA" } };
    return Arrays.asList(expectedOutputs);
  }

  @Test
  public void testTruncateAInFirst2Positions() {
    final StringHelper stringHelper = new StringHelper();
    assertEquals(expectedOutput, stringHelper.truncateAInFirst2Positions(input));
  }

}
