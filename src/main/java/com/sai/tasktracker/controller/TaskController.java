package com.sai.tasktracker.controller;

import com.sai.tasktracker.entity.Task;
import com.sai.tasktracker.service.TaskService;
import jakarta.validation.Valid;
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
    public void addTasks(@RequestBody @Valid Task task){
        taskService.addTasks(task);
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id){
        return taskService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public void updateTask(@RequestBody @Valid Task updatedTask, @PathVariable Long id){
        taskService.updateTask(updatedTask, id);
    }


}
