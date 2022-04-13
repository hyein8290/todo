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
		// from절에 DB의 테이블이 아닌 entity명으로 조회해야 한다.
		return em.createQuery("select t from Todo t", Todo.class).getResultList();
	}

}
