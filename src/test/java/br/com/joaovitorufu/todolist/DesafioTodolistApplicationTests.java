package br.com.joaovitorufu.todolist;

import br.com.joaovitorufu.todolist.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioTodolistApplicationTests {

	@Autowired
	private WebTestClient webClient;

	@Test
	void testCreateTodoSuccess() {

		var todo = new Todo("todo 1", "desc todo 1",1);

		webClient.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(Optional.of(1))
				.jsonPath("$[0].name").isEqualTo(todo.getName())
				.jsonPath("$[0].description").isEqualTo(todo.getDescription())
				.jsonPath("$[0].done").isEqualTo(Boolean.valueOf(todo.isDone()))
				.jsonPath("$[0].priority").isEqualTo(Integer.valueOf(todo.getPriority()));

	}

	@Test
	void testCreateTodoFailure(){
		webClient
				.post()
				.uri("/todos")
				.bodyValue(
						new Todo("","",0)
				).exchange()
				.expectStatus().isBadRequest();

	}





}
