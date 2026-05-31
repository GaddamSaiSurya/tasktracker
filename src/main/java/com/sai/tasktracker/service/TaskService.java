package com.sai.tasktracker.service;

import com.sai.tasktracker.entity.Task;
import com.sai.tasktracker.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void addTasks(Task task){
        taskRepository.save(task);
    }
}
