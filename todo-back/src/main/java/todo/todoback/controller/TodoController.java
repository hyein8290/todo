package todo.todoback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import todo.todoback.domain.Todo;
import todo.todoback.service.TodoService;

@Controller
public class TodoController {
	
	private final TodoService todoService;
	
	@Autowired
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping("/todos")
	public String list(Model model) {
		List<Todo> todos = todoService.findTodos();
		model.addAttribute("todos", todos);
		return "todos/todoList";
	}
}
