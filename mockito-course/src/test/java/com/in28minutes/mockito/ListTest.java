package com.in28minutes.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListTest {

  private List mockList;

  @Before
  public void setup() {
    mockList = mock(List.class);
  }

  @Test
  public void LetsMockListSize() {
    when(mockList.size()).thenReturn(2);

    assertEquals(2, mockList.size());
    assertEquals(2, mockList.size()); // size does not change
  }

  @Test
  public void LetsMockListSize_returnMultipleValues() {
    when(mockList.size()).thenReturn(2).thenReturn(3);

    assertEquals(2, mockList.size());
    assertEquals(3, mockList.size());
  }

  @Test
  public void LetsMockListGet() {
    when(mockList.get(0)).thenReturn("Hello");

    assertEquals("Hello", mockList.get(0));
    assertNull(mockList.get(1));
  }

  @Test
  public void LetsMockListGet_anyInt() {
    when(mockList.get(anyInt())).thenReturn("Same value for all integers");

    assertEquals("Same value for all integers", mockList.get(0));
    assertEquals("Same value for all integers", mockList.get(1));
  }

  @Test(expected = RuntimeException.class)
  public void LetsMockListGet_throwException() {
    when(mockList.get(0)).thenThrow(new RuntimeException("Some Message"));

    mockList.get(0);
  }

}
