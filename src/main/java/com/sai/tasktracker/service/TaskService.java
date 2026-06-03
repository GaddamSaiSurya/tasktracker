package com.sai.tasktracker.service;

import com.sai.tasktracker.entity.Task;
import com.sai.tasktracker.exception.TaskNotFoundException;
import com.sai.tasktracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public Task getById(Long id){
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public void updateTask(
            Task updatedTask, Long id){

        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());
        existingTask.setDueDate(updatedTask.getDueDate());
        taskRepository.save(existingTask);
    }
}
