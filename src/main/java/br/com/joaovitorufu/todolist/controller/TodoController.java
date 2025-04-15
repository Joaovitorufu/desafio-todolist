package br.com.joaovitorufu.todolist.controller;

import br.com.joaovitorufu.todolist.entity.Todo;
import br.com.joaovitorufu.todolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service){
        this.service = service;
    }

    @PostMapping
    List<Todo> create(@RequestBody Todo todo){
       return service.createTodo(todo);
    }

    @GetMapping
    List<Todo> list(){
        return service.listAllTodo();
    }

    @PutMapping
    List<Todo> updateTodo(@RequestBody Todo todo){
        return service.updateTodo(todo);
    }

    @DeleteMapping("{id}")
    List <Todo> deleteTodo(@PathVariable Long id){
        return service.deleteTodo(id);
    }
}
