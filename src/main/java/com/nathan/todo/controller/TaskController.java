package com.nathan.todo.controller;


import com.nathan.todo.models.Task;
import com.nathan.todo.models.TaskStatus;
import com.nathan.todo.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Task Management", description = "CRUD operations for managing tasks in the To-Do List application")
@RestController
@RequestMapping("/api/tasks")
/**
 * REST Controller for managing tasks in the To-Do List application.
 *
 * Each endpoint is well-documented with OpenAPI annotations.
 */
public class TaskController {

    private final TaskService taskService;

    /**
     * Constructor to initialize the Task Service
     *
     * @param taskService the service to interact with the Tasks
     */
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Create a new task
     *
     * @param task the task object that needs to be created
     * @return the created task
     */
    @Operation(
            summary = "Create a new task",
            description = "Creates a task with a title, description, and status. The status can be TODO, IN_PROGRESS, or DONE."
    )
    @PostMapping
    public ResponseEntity<Task> createTask(@Parameter(description = "The task object that needs to be created", required = true) @RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    /**
     * Retrieve all tasks
     *
     * @param status the status to filter tasks by. If null, all tasks are retrieved.
     * @return the list of tasks
     */
    @Operation(
            summary = "Get tasks",
            description = "Retrieve all tasks. Optionally filter tasks by status if a valid status is provided as query parameter."
    )
    @GetMapping
    public ResponseEntity<List<Task>> getTasks(@Parameter(description = "Task status to filter tasks by (TODO, IN_PROGRESS, DONE)", required = false) @RequestParam(value = "status", required = false) TaskStatus status) {
        if(status != null) {
            return ResponseEntity.ok(taskService.getTasksByStatus(status));
        } else {
            return ResponseEntity.ok(taskService.getAllTasks());
        }
    }

    /**
     * Update an existing task
     *
     * @param id the ID of the task to update
     * @param task the updated task object
     * @return the updated task
     */
    @Operation(
            summary = "Update an existing task",
            description = "Updates an existing task based on the provided ID. You may update the title, description, or status."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@Parameter(description = "ID of the task to update", required = true) @PathVariable Long id, @Parameter(description = "Updated task object with new details", required = true) @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        if(updatedTask ==  null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTask);
    }

    /**
     * Delete a task
     *
     * @param id the ID of the task to be deleted
     * @return a response with a 204 status code indicating deletion success
     */
    @Operation(
            summary = "Delete a task",
            description = "Deletes the task specified by the provided ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@Parameter(description = "ID of the task to be deleted", required = true) @PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
