package com.example.demo.task;

import java.util.List;

public interface TaskService {

    Task save(Task task);
    Task fetchTask(String name);

    List<Task> fetchAll();
    Task findTasksByAuthor(String author);
}
