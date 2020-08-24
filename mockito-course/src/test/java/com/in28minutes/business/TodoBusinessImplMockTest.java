package com.in28minutes.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImplMockTest {

  private TodoService todoServiceMock;
  private TodoBusinessImpl todoBusinessImpl;

  @Before
  public void setup() {
    todoServiceMock = mock(TodoService.class);
    todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
  }

  @Test
  public void testRetrieveTodosRelatingToSpring_usingAMock() {
    final List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Unit Test");
    when(todoServiceMock.retrieveTodos("DummyUser")).thenReturn(allTodos);

    final List<String> springTodos = todoBusinessImpl.retrieveTodosRelatingToSpring("DummyUser");
    assertEquals(2, springTodos.size());
  }

  @Test
  public void testRetrieveTodosRelatingToSpring_emptyArray() {
    final List<String> allTodos = new ArrayList<String>();
    when(todoServiceMock.retrieveTodos("DummyUser")).thenReturn(allTodos);

    final List<String> springTodos = todoBusinessImpl.retrieveTodosRelatingToSpring("DummyUser");
    assertEquals(0, springTodos.size());
  }

}
