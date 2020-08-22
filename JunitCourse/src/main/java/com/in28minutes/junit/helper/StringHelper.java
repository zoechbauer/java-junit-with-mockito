package com.in28minutes.junit.helper;

public class StringHelper {

  // AACD => CD, ACD => CD, CDEF => CDEF, CDAA => CDAA
  public String truncateAInFirst2Positions(String str) {
    if (str.length() <= 2) {
      return str.replaceAll("A", "");
    }

    final String first2Chars = str.substring(0, 2);
    final String stringMinusFirst2Chars = str.substring(2);

    return first2Chars.replaceAll("A", "") + stringMinusFirst2Chars;
  }

  // ABCD => false, ABAB => true, AB => true, A => false
  public boolean areFirstAndLastTwoCharactersTheSame(String str) {

    if (str.length() <= 1) {
      return false;
    }
    if (str.length() == 2) {
      return true;
    }

    final String first2Chars = str.substring(0, 2);

    final String last2Chars = str.substring(str.length() - 2);

    return first2Chars.equals(last2Chars);
  }

}
