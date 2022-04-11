package todo.todoback.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import todo.todoback.domain.Todo;

public class JdbcTodoRepository implements TodoRepository {
	
	private final DataSource dataSource;
	
	public JdbcTodoRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Todo> findAll() {
		String sql = "select * from tbltodo";
		
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			List<Todo> todos = new ArrayList<>();
			while(rs.next()) {
				Todo todo = new Todo();
				
				todo.setId(rs.getLong("id"));
				todo.setContent(rs.getString("content"));
				
				if(rs.getInt("completed") == 1) {
					todo.setCompleted(true);
				} else {
					todo.setCompleted(false);
				}
				
				todos.add(todo);
			}
			
			return todos;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			close(conn, pstat, rs);
		}
		
	}
	
	private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }
	
    private void close(Connection conn, PreparedStatement pstat, ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstat != null) {
                pstat.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
	
}
