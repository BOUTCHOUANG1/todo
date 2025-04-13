package com.nathan.todo.repository;

import com.nathan.todo.models.Task;
import com.nathan.todo.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * This interface extends the JpaRepository interface to provide access to the Task entity.
 * The methods included in this interface are used to query the database and perform CRUD operations.
 *
 * @author Boutchouang Nathan Elija
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * This method is used to query the database and retrieve all tasks with a given status.
     *
     * @param status The status of the tasks to be retrieved.
     * @return A list of tasks with the given status.
     */
    List<Task> findByStatus(TaskStatus status);
}
