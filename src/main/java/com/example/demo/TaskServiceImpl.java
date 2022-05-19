package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepo taskRepo;

    @Override
    public Task save(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public Task fetchTask(String name) {
        return taskRepo.findByName(name);
    }

    @Override
    public List<Task> fetchAll() {
        return taskRepo.findAll();
    }

    @Override
    public Task findTasksByAuthor(String author) {
        return taskRepo.findByAuthor(author);
    }
}
