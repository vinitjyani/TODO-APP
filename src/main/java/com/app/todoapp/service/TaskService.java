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

    public Task createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
      task.setCompleted(false);
        taskrepository.save(task);

        return task;
    }

    public void deleteTask(long id) {
        taskrepository.deleteById(id);
    }

    public Task toggleTask(long id) {

        Task task =taskrepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid task id"));

        task.setCompleted(!task.isCompleted());
        taskrepository.save(task);


        return task;
    }
}
