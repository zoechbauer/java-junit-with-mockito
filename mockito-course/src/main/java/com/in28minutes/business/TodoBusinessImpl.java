package com.in28minutes.business;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImpl {
  private final TodoService todoService;

  public TodoBusinessImpl(TodoService todoService) {
    this.todoService = todoService;
  }

  public List<String> retrieveTodosRelatingToSpring(String user) {
    final List<String> filteredTodos = new ArrayList<String>();
    final List<String> todos = todoService.retrieveTodos(user);

    for (final String todo : todos) {
      if (todo.contains("Spring")) {
        filteredTodos.add(todo);
      }
    }
    return filteredTodos;
  }

  public void deleteTodosNotRelatingToSpring(String user) {
    final List<String> todos = todoService.retrieveTodos(user);

    for (final String todo : todos) {
      if (!todo.contains("Spring")) {
        todoService.deleteTodo(todo);
      }
    }
  }

}
