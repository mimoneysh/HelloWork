package com.Aspring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Aspring.model.User;
import com.Aspring.model.UserStatus;


@Repository
public class UserDao {
	
private JdbcTemplate jdbcTemplate;
	
	
	
	@Autowired
	public UserDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
		System.out.println("jdbc template wired in dao");
	}

	public boolean registerUser(User registeredUser) {
		// TODO Auto-generated method stub
		boolean updated=false;
		String sql ="INSERT INTO users (email, username, password) VALUES (?, ?, ?)";
		
		Object[] rarams= {registeredUser.getEmail(),registeredUser.getUsername(),registeredUser.getId()};
		int ra =jdbcTemplate.update(sql,rarams);//
		if(ra > 0)
				updated=true;
		
		return updated;

		

	}

	public UserStatus getUserDetailsFromDb(String email) {
		// TODO Auto-generated method stub
		UserStatus userStatus =new UserStatus(-1,"usernotfound",null);
		String sql ="select id, username from book1table where email=?";
		
		Object params[]= {email};
		BeanPropertyRowMapper<User> brm
		=new BeanPropertyRowMapper<User>(User.class);
		User user=null;
		try {
			user = jdbcTemplate.queryForObject(sql, params,brm);
			userStatus.setStatusCode(1);
			userStatus.setMessage("User details found");
			userStatus.setUser(user);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("when email is not found in where condition");
		}
				
		return userStatus;
	}

}
