package todo.todoback.repository;

import java.util.List;

import todo.todoback.domain.Todo;

public interface TodoRepository {
	List<Todo> findAll();
}
