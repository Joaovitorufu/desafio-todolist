package br.com.joaovitorufu.todolist.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "todos")
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private boolean done;
    private int priority;

    public Todo(){}

    public Todo(String name, String description, int priority){
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.done = false;

    }

}
