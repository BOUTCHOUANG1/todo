package com.nathan.todo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * This class represents a task in the To-Do List. A task is something that must be done. It has a title, a description,
 * and a status. The title is the name of the task, the description is a brief statement about what the task is about,
 * and the status is the state of the task: either TODO, IN_PROGRESS or DONE.
 */
public class Task {
    /**
     * The id of the task. This is a unique identifier for the task.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The title of the task. This is the name of the task.
     */
    @Column(nullable = false)
    private String title;

    /**
     * The description of the task. This is a brief statement about what the task is about.
     */
    @Column(length = 2000)
    private String description;

    /**
     * The status of the task. This can be TODO, IN_PROGRESS or DONE.
     */
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    /**
     * The version of the task. This is used to track the changes made to the task.
     */
    @Version
    private Integer version;
}
