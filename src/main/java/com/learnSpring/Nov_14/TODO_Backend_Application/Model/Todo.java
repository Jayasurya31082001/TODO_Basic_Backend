package com.learnSpring.Nov_14.TODO_Backend_Application.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String taskName;
    private String taskDescription;
    @Enumerated(EnumType.STRING)
    private TodoStatus taskStatus;
    private boolean isCompleted;


}
