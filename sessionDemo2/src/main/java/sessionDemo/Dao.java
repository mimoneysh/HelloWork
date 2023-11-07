package sessionDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Dao {
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void Dao(JdbcTemplate jdbcTemplate) {
		//super();
		this.jdbcTemplate= jdbcTemplate;
		System.out.println("JDBC DAO connected successfully!");
	}

}
