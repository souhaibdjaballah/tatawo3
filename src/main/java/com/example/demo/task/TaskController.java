package com.example.demo.task;

import lombok.AllArgsConstructor;
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

    @GetMapping(path = "/task/name/{name}")
    public Task fetchTask(@PathVariable(name = "name") String name){
        return taskService.fetchTask(name);
    }

    @GetMapping(path = "tasks")
    public List<Task> fetchAll(){
        return taskService.fetchAll();
    }

    @GetMapping(path = "/task/author/{author}")
    public Task findTasksByAuthor(@PathVariable(name = "author") String author){return taskService.findTasksByAuthor(author);}

//    @GetMapping(path = "/task")
//    public Task findTasksByAuthor(@RequestParam(name = "author") String author){return taskService.findTasksByAuthor(author);}
}
