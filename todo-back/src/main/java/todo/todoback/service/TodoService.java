package todo.todoback.service;

import todo.todoback.domain.Todo;
import todo.todoback.repository.TodoRepository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
public class TodoService {

	private final TodoRepository todoRepository;
	
	@Autowired
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	public List<Todo> findTodos() {
        return todoRepository.findAll();
    }
}
