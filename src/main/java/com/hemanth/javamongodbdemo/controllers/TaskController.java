package com.hemanth.javamongodbdemo.controllers;

import com.hemanth.javamongodbdemo.model.Task;
import com.hemanth.javamongodbdemo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @PutMapping("/update")
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @GetMapping("/all")
    public List<Task> findAll(){
        return taskService.findAllTasks();
    }

    @GetMapping("/get-task-by-id/{taskId}")
    public Task getTaskById(@PathVariable String taskId){
        return taskService.getTaskByTaskId(taskId);
    }

    @GetMapping("/get-task-by-priority/{priority}")
    public List<Task> getTaskByPriority(@PathVariable int priority){
        return taskService.getTaskByPriority(priority);
    }

    @GetMapping("/get-task-by-assignee/{assignee}")
    public List<Task> getTaskByAssignee(@PathVariable String assignee){
        return taskService.getTaskByAssignee(assignee);
    }

    @DeleteMapping("/delete-task-by-id/{taskId}")
    public String deleteTask(@PathVariable String taskId){
        return taskService.deleteTask(taskId);
    }

}
