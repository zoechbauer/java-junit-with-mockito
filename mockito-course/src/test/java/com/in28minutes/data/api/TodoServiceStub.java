package com.in28minutes.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
  // Disadvantages of Stubs when:
  // Dynamic Condition
  // Service Definition

  public List<String> retrieveTodos(String user) {
    return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Unit Test");
  }

}
