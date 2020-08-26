package com.in28minutes.mockito;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

  @Test
  public void testHamcrestMatchers() {
    final List<Integer> scores = Arrays.asList(99, 100, 101, 105);

    // List
    assertThat(scores, hasItems(100, 101));
    assertThat(scores, hasSize(4));
    assertThat(scores, everyItem(greaterThan(90)));
    assertThat(scores, everyItem(lessThan(120)));

    // String
    assertThat("", isEmptyString());
    assertThat(null, isEmptyOrNullString());

    // Array
    final Integer[] numbers = { 1, 2, 3 };
    assertThat(numbers, arrayWithSize(3));
    assertThat(numbers, arrayContaining(1, 2, 3));
    assertThat(numbers, arrayContainingInAnyOrder(3, 1, 2));
  }

}
