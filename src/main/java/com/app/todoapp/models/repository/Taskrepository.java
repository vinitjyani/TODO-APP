package com.app.todoapp.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.todoapp.models.Task;

public interface Taskrepository extends JpaRepository<Task,Long>{
	
}
