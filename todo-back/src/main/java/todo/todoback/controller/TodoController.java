package todo.todoback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import todo.todoback.domain.Todo;
import todo.todoback.form.TodoForm;
import todo.todoback.service.TodoService;

@Controller
public class TodoController {
	
	private final TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping("/todos")
	public String list(Model model) {
		List<Todo> todos = todoService.findTodos();
		model.addAttribute("todos", todos);
		return "todos/todoList";
	}
	
	@PostMapping("/todos/new")
	public String create(TodoForm form) {
		Todo todo = new Todo();
		todo.setContent(form.getContent());
	
		todoService.add(todo);
		
		return "redirect:/";
	}
}
