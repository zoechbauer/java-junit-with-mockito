package com.in28minutes.junit.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringHelperTest {
  StringHelper stringHelper = new StringHelper();

  @Test
  public void testTruncateAInFirst2Positions_AinFirst2Positions() {
    assertEquals("CD", stringHelper.truncateAInFirst2Positions("AACD"));
  }

  @Test
  public void testTruncateAInFirst2Positions_AinFirstPosition() {
    assertEquals("CD", stringHelper.truncateAInFirst2Positions("ACD"));
  }

  @Test
  public void testTruncateAInFirst2Positions_noAinString() {
    assertEquals("CDEF", stringHelper.truncateAInFirst2Positions("CDEF"));
  }

  @Test
  public void testTruncateAInFirst2Positions_AinEndOfString() {
    assertEquals("CDAA", stringHelper.truncateAInFirst2Positions("CDAA"));
  }

  @Test
  public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
    assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD"));
  }

  @Test
  public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
    assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("ABAB"));
  }

  @Test
  public void testAreFirstAndLastTwoCharactersTheSame_2Chars() {
    assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("AB"));
  }

  @Test
  public void testAreFirstAndLastTwoCharactersTheSame_1Char() {
    assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("A"));
  }
}
