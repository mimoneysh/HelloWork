package DemoLogin.Dao;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import DemoLogin.Model.User;
import DemoLogin.Model.UserStatus;
@Repository
public class UserDao {
	
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public UserDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate=jdbcTemplate;
		System.out.println("JDBC in DAO");
	}

	public UserStatus getUserFromDb(String email) {
		// TODO Auto-generated method stub
		
		
		UserStatus userStatus=new UserStatus(-1, "UserNotFound0", null);
		String query ="SELECT * FROM login where email = ?";
		
		Object params[]= {email};
		BeanPropertyRowMapper<User> brm
		=new BeanPropertyRowMapper<User>(User.class);
		User user=null;
		try {
			user = jdbcTemplate.queryForObject(query, params,brm);
			userStatus.setStatusCode(1);
			userStatus.setMessage("email details found!");
			userStatus.setUser(user);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("email is not found !");
		}
		return userStatus;
	}

	public boolean createUserInDB(User newUser) {
		// TODO Auto-generated method stub
		boolean created = false;
		
		// Generate a random salt
        byte[] salt = Encryption.generateSalt();

        // Hash the input password with the salt
        byte[] hashedPassword = Encryption.hashString(newUser.getPassword(), salt);

		
		String query = "INSERT INTO login (email, password, username,salt) VALUES (?, ?, ?,?)";
		
		/*
		 * Object[] param=
		 * {newUser.getEmail(),Arrays.toString(hashedPassword),newUser.getUsername(),
		 * salt}; for (Object value : param) { System.out.println(value); }
		 */		
				try {
					int ra = jdbcTemplate.update(query, newUser.getEmail(), hashedPassword, newUser.getUsername(), salt);
					if (ra > 0)
						created = true;
				} catch (DataAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		
		return created;
	}

	public boolean authenticateUser(String email, String password) {
		// TODO Auto-generated method stub
		
		String selectSQL = "SELECT salt,password FROM login WHERE email = ?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(selectSQL,email);
        
        System.out.println(result.size());

        if (result.size() == 1) {
            // Retrieve the salt and hashed password from the query result
            byte[] salt = (byte[]) result.get(0).get("salt");
            byte[] storedHashedPassword = (byte[]) result.get(0).get("password");

            // Hash the login attempt with the retrieved salt
            byte[] hashedAttempt = Encryption.hashString(password, salt);

            // Compare the hashedAttempt with the storedHashedPassword
            return Arrays.equals(hashedAttempt, storedHashedPassword);
        }

        return false;
	}

}
