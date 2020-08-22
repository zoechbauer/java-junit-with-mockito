package com.in28minutes.junit.helper;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParamized2Test {

  private final String input;
  private final boolean expectedOutput;

  public StringHelperParamized2Test(String input, boolean expectedOutput) {
    this.input = input;
    this.expectedOutput = expectedOutput;
  }

  @Parameters
  public static Collection<Object[]> testConditions() {
    // ABCD => false, ABAB => true, AB => true, A => false
    final Object[][] expectedOutputs = { { "ABCD", false }, { "ABAB", true }, { "AB", true }, { "A", false } };
    return Arrays.asList(expectedOutputs);
  }

  @Test
  public void testAreFirstAndLastTwoCharactersTheSame() {
    final StringHelper helper = new StringHelper();
    assertEquals(expectedOutput, helper.areFirstAndLastTwoCharactersTheSame(input));
  }

}
