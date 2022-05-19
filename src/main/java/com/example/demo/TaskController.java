package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
@AllArgsConstructor
public class TaskController {

    private final TaskServiceImpl taskService;

    @PostMapping(path = "/addTask")
    public Task addTask(@RequestBody Task task){

        return taskService.save(task);
    }

    @GetMapping(path = "/task/{name}")
    public Task fetchTask(@PathVariable(name = "name") String name){
        return taskService.fetchTask(name);
    }

    @GetMapping(path = "tasks")
    public List<Task> fetchAll(){
        return taskService.fetchAll();
    }
}
