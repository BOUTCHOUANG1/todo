package com.nathan.todo.services;

import com.nathan.todo.models.Task;
import com.nathan.todo.models.TaskStatus;
import com.nathan.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        task.setId(null);
        return taskRepository.save(task);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task existingtask = optionalTask.get();
            existingtask.setTitle(updatedTask.getTitle());
            existingtask.setDescription(updatedTask.getDescription());
            existingtask.setStatus(updatedTask.getStatus());
            return taskRepository.save(existingtask);
        }
        return null;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
