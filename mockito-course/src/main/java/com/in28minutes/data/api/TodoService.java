package com.in28minutes.data.api;

import java.util.List;

//External Service - Lets say this comes from WunderList
public interface TodoService {
  List<String> retrieveTodos(String user);
}