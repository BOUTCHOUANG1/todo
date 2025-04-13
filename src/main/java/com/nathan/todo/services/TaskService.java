package com.nathan.todo.services;

import com.nathan.todo.models.Task;
import com.nathan.todo.models.TaskStatus;
import com.nathan.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for Task entities. Provides business logic
 * for Task related operations.
 */
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    /**
     * Constructor.
     *
     * @param taskRepository The TaskRepository instance.
     */
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Retrieves a list of all tasks.
     *
     * @return A list of all tasks.
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Creates a new task.
     *
     * @param task The task to create.
     * @return The created task.
     */
    public Task createTask(Task task) {
        task.setId(null);
        return taskRepository.save(task);
    }

    /**
     * Retrieves a list of tasks with a given status.
     *
     * @param status The task status.
     * @return A list of tasks with the given status.
     */
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    /**
     * Updates a task.
     *
     * @param id         The ID of the task to update.
     * @param updatedTask The updated task.
     * @return The updated task or null if the task does not exist.
     */
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

    /**
     * Deletes a task.
     *
     * @param id The ID of the task to delete.
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
