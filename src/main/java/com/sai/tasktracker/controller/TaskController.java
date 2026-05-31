package com.sai.tasktracker.controller;

import com.sai.tasktracker.entity.Task;
import com.sai.tasktracker.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public void addTasks(@RequestBody Task task){
        taskService.addTasks(task);
    }
}
