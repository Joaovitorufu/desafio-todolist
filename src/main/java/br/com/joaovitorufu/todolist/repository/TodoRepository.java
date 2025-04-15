package br.com.joaovitorufu.todolist.repository;

import br.com.joaovitorufu.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
