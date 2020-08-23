package com.in28minutes.business;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.in28minutes.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

  private TodoServiceStub todoServiceStub;
  private TodoBusinessImpl todoBusinessImpl;
  private List<String> springTodos;

  @Before
  public void setUp() {
    todoServiceStub = new TodoServiceStub();
    todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
    springTodos = todoBusinessImpl.retrieveTodosRelatingToSpring("DummyUser");
  }

  @Test
  public void testRetrieveTodosRelatingToSpring_ArraySize() {
    assertEquals(2, springTodos.size());
  }

  @Test
  public void testRetrieveTodosRelatingToSpring_ArrayElements() {
    final List<String> expected = Arrays.asList("Learn Spring MVC", "Learn Spring");
    assertEquals(expected, springTodos);
  }

}
