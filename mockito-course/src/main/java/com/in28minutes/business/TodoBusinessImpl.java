package com.in28minutes.business;

import java.util.List;
import java.util.stream.Collectors;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImpl {
  private final TodoService todoService;

  public TodoBusinessImpl(TodoService todoService) {
    this.todoService = todoService;
  }

  public List<String> retrieveTodosRelatingToSpring(String user) {
//    final List<String> filteredTodos = new ArrayList<String>();
//    for (final String todo : todos) {
//      if (todo.contains("Spring")) {
//        filteredTodos.add(todo);
//      }
//    }
    final List<String> todos = todoService.retrieveTodos(user);
    final List<String> filteredTodos = todos.stream().filter(todo -> todo.contains("Spring"))
        .collect(Collectors.toList());
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
