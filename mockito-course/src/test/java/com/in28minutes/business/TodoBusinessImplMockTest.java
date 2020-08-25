package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

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

  @Test
  public void testRetrieveTodosRelatingToSpring_usingBDD() {
    final List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Unit Test");

    // given
    given(todoServiceMock.retrieveTodos("DummyUser")).willReturn(allTodos);

    // when
    final List<String> springTodos = todoBusinessImpl.retrieveTodosRelatingToSpring("DummyUser");

    // then
    assertThat(springTodos.size(), is(2));
  }

  @Test
  public void testRetrieveTodosRelatingToSpring_emptyArray_usingBDD() {
    final List<String> allTodos = new ArrayList<String>();

    // given
    given(todoServiceMock.retrieveTodos("DummyUser")).willReturn(allTodos);

    // when
    final List<String> springTodos = todoBusinessImpl.retrieveTodosRelatingToSpring("DummyUser");

    // then
    assertThat(springTodos.size(), is(0));
  }

  @Test
  public void testDeleteTodosNotRelatingToSpring_usingBDD() {
    final List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Unit Test");

    // given
    given(todoServiceMock.retrieveTodos("DummyUser")).willReturn(allTodos);

    // when
    todoBusinessImpl.deleteTodosNotRelatingToSpring("DummyUser");

    // then
    verify(todoServiceMock).deleteTodo("Learn Unit Test");
//    verify(todoServiceMock, Mockito.times(1)).deleteTodo("Learn Unit Test");
//    verify(todoServiceMock, Mockito.atLeastOnce()).deleteTodo("Learn Unit Test");
    verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring MVC");

  }

  @Test
  public void testDeleteTodosNotRelatingToSpring_usingBDD_then_insteadOf_verify() {
    final List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Unit Test");

    // given
    given(todoServiceMock.retrieveTodos("DummyUser")).willReturn(allTodos);

    // when
    todoBusinessImpl.deleteTodosNotRelatingToSpring("DummyUser");

    // then
    then(todoServiceMock).should().deleteTodo("Learn Unit Test");
//    then(todoServiceMock).should(times(1)).deleteTodo("Learn Unit Test");
//    then(todoServiceMock).should(atLeast(5)).deleteTodo("Learn Unit Test");
    then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
  }

  @Test
  public void testDeleteTodosNotRelatingToSpring_usingBDD_argumentCapture() {
    final ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

    final List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Unit Test");

    // given
    given(todoServiceMock.retrieveTodos("DummyUser")).willReturn(allTodos);

    // when
    todoBusinessImpl.deleteTodosNotRelatingToSpring("DummyUser");

    // then
    then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());

    assertThat(stringArgumentCaptor.getValue(), is("Learn Unit Test"));
  }

}
