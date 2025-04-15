package br.com.joaovitorufu.todolist.service;

import br.com.joaovitorufu.todolist.entity.Todo;
import br.com.joaovitorufu.todolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository repository;

    public TodoService(TodoRepository repository){
        this.repository = repository;
    }

    public List<Todo> createTodo(Todo todo){
        repository.save(todo);
        return listAllTodo();
    }

    public List<Todo> listAllTodo(){
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
        return repository.findAll(sort);

    }

    public List<Todo> updateTodo(Todo todo){
        repository.save(todo);
        return listAllTodo();
    }

    public List<Todo> deleteTodo(Long id){
        repository.deleteById(id);
        return listAllTodo();
    }
}
