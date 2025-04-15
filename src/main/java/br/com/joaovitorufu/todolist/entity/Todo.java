package br.com.joaovitorufu.todolist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "todos")
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean done;
    private int priority;

    public Todo(){}

    public Todo(String name, String description, int priority){
        this.name = name;
        this.description = description;
        this.priority = priority;
        done = false;

    }

}
