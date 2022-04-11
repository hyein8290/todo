package todo.todoback;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import todo.todoback.repository.JdbcTodoRepository;
import todo.todoback.repository.JpaTodoRepository;
import todo.todoback.repository.TodoRepository;
import todo.todoback.service.TodoService;

@Configuration
public class SpringConfig {
	
	private final DataSource dataSource;
	private final EntityManager em;
	
	public SpringConfig(DataSource dataSource, EntityManager em) {
		this.dataSource = dataSource;
		this.em = em;
	}

	@Bean
	public TodoService todoService() {
		return new TodoService(todoRepository());
	}
	
	@Bean
	public TodoRepository todoRepository() {
		//return new JdbcTodoRepository(dataSource);
		return new JpaTodoRepository(em);
	}
}
