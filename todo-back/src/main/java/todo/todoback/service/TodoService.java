package todo.todoback.service;

import todo.todoback.domain.Todo;
import todo.todoback.repository.TodoRepository;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TodoService {

	private final TodoRepository todoRepository;
	
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	public List<Todo> findTodos() {
        return todoRepository.findAll();
    }
	
	public Long add(Todo todo) {
		todoRepository.save(todo);
		return todo.getId();
	}
}
