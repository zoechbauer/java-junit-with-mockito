package com.in28minutes.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

  // Mock
  @Test
  public void creatingMockOnArrayList() {
    final List<String> listSpy = mock(ArrayList.class);
    assertEquals(0, listSpy.size());
    listSpy.add("Test");
    listSpy.add("another Test");
    assertEquals(0, listSpy.size());
  }

  // Spy
  @Test
  public void creatingSpyOnArrayList() {
    final List<String> listSpy = spy(ArrayList.class);
    assertEquals(0, listSpy.size());
    listSpy.add("Test");
    listSpy.add("another Test");
    assertEquals(2, listSpy.size());
  }

  @Test
  public void creatingSpyOnArrayList_overridingSize() {
    final List<String> listSpy = spy(ArrayList.class);
    assertEquals(0, listSpy.size());

    stub(listSpy.size()).toReturn(-1);
    listSpy.add("Test");
    listSpy.add("another Test");
    assertEquals(-1, listSpy.size());

    verify(listSpy).add("Test");

    assertEquals("Test", listSpy.get(0));
  }

}
