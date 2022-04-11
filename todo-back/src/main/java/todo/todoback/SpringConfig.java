package todo.todoback;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import todo.todoback.repository.JdbcTodoRepository;
import todo.todoback.repository.TodoRepository;
import todo.todoback.service.TodoService;

@Configuration
public class SpringConfig {
	
	private final DataSource dataSource;
	
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public TodoService todoService() {
		return new TodoService(todoRepository());
	}
	
	@Bean
	public TodoRepository todoRepository() {
		return new JdbcTodoRepository(dataSource);
	}
}
