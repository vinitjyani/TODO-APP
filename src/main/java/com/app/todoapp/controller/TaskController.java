package com.app.todoapp.controller;

import org.springframework.web.bind.annotation.*;
import com.app.todoapp.models.Task;
import com.app.todoapp.service.TaskService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Create a new task
    @PostMapping
    public Task createTask(@RequestBody Map<String, String> payload) {
        String title = payload.get("title");
        return taskService.createTask(title);
    }
    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Map<String, String> payload, @PathVariable long id) {
        // Extract the title from the request payload
        String title = payload.get("title");

        // Call the service to update the task
        return taskService.updatetask(id,title);
    }



    // Delete a task by ID
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully";
    }

    // Toggle a task's completion status
    @PutMapping("/{id}/toggle")
    public Task toggleTask(@PathVariable long id) {
        return taskService.toggleTask(id);
    }
}
