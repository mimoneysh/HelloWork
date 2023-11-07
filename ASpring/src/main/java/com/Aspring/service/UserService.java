package com.Aspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.Aspring.service.*;



import com.Aspring.dao.*;


import com.Aspring.model.User;
import com.Aspring.model.UserStatus;

@Service
public class UserService {
	private UserDao userDao ;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	  
	

	
	@Autowired
	public UserService(UserDao userDao) {
		super();
		this.userDao = userDao;
		System.out.println("dao wired in service");
	}

	public boolean registerUser(User registeredUser) {
		// TODO Auto-generated method stub
		
		return userDao.registerUser(registeredUser);
	}

	public UserStatus getUserDetails(String email) {
		// TODO Auto-generated method stub
		return userDao.getUserDetailsFromDb(email);
	}

	}

	
	
	
	
	
	
	
	
	
//	@Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    public User registerUser(String username, String email, String password) {
//        User newUser = new User();
//        newUser.setUsername(username);
//        newUser.setEmail(email);
//        newUser.setPassword(passwordEncoder.encode(password)); // Hash the password
//        return userRepository.save(newUser);
//    }
    
    
    
    

	/*
	 * public boolean authenticateUser(String username, String password) { User user
	 * = userRepository.findByUsername(username); if (user != null) { return
	 * passwordEncoder.matches(password, user.getPassword()); } return false; }
	 */
    


