package com.tasks.manager.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue
    private Long taskId;
    private String title;
    private String description;
    private String status;

    @Column(nullable = false)
    private Long projectId;

}
