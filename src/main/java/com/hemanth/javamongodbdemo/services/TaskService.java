package com.hemanth.javamongodbdemo.services;

import com.hemanth.javamongodbdemo.model.Task;
import com.hemanth.javamongodbdemo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    }

    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskByTaskId(String taskId){
        return taskRepository.findById(taskId).get();
    }

    public List<Task> getTaskByPriority(int priority){
        return taskRepository.findByPriority(priority);
    }

    public List<Task> getTaskByAssignee(String assignee){
        return taskRepository.getTaskByAssignee(assignee);
    }

    public Task updateTask(Task task){
        Task existingTask = taskRepository.findById(task.getTaskId()).get();
        existingTask.setDescription(task.getDescription());
        existingTask.setAssignee(task.getAssignee());
        existingTask.setPriority(task.getPriority());
        existingTask.setStoryPoint(task.getStoryPoint());
        return taskRepository.save(existingTask);
    }

    public String deleteTask(String taskId){
        taskRepository.deleteById(taskId);
        return "Task deleted from dashboard "+taskId;
    }
}
