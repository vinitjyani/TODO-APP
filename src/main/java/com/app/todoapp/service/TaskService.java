package com.app.todoapp.service;

import com.app.todoapp.models.Task;
import com.app.todoapp.models.repository.Taskrepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    private final Taskrepository taskrepository;

    public TaskService(Taskrepository taskrepository) {
        this.taskrepository = taskrepository;
    }


    public List<Task> getAllTasks() {
    return taskrepository.findAll();
    }
}
