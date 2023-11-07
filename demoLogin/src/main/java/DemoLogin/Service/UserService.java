package DemoLogin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DemoLogin.Dao.UserDao;
import DemoLogin.Model.User;
import DemoLogin.Model.UserStatus;
@Service
public class UserService {
	
	private UserDao userDao;
	@Autowired
	public UserService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public UserStatus getUser(String email) {
		// TODO Auto-generated method stub
		return userDao.getUserFromDb(email);
	}

	public boolean createUser(User newUser) {
		// TODO Auto-generated method stub
		return userDao.createUserInDB(newUser);
	}

	public boolean loginUser(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.authenticateUser(email,password);
	}

	

	

}
