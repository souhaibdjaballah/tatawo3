package com.example.demo;

import java.util.List;

public interface TaskService {

    Task save(Task task);
    Task fetchTask(String name);

    List<Task> fetchAll();
}
