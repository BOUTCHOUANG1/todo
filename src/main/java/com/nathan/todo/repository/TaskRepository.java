package com.nathan.todo.repository;

import com.nathan.todo.models.Task;
import com.nathan.todo.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
