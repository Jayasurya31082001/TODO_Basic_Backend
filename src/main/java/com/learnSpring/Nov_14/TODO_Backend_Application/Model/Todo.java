package com.learnSpring.Nov_14.TODO_Backend_Application.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Data

public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @NotBlank
    @Schema(name = "taskName",example = "Learn Springboot")
    private String taskName;
    private String taskDescription;
    @Enumerated(EnumType.STRING)
    private TodoStatus taskStatus;
    private boolean isCompleted;


}
