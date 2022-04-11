package todo.todoback.repository;

import java.util.List;
import javax.persistence.EntityManager;
import todo.todoback.domain.Todo;

public class JpaTodoRepository implements TodoRepository {
	
	private final EntityManager em;
	
	public JpaTodoRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Todo> findAll() {
		return em.createQuery("select t from Todo t", Todo.class).getResultList();
	}

}
