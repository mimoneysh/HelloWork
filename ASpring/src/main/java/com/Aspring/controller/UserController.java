package com.Aspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aspring.model.User;
import com.Aspring.model.UserRepository;
import com.Aspring.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("")
	public String viewHomePage() {
		return "login";
	}
	
	
	@Autowired
	private UserRepository userRepo;
	@Controller
	public class RegisterController{
	
	@PostMapping("/signup")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "login";
	}
	
	}
	
	@Controller
	public class LoginController {
	    @GetMapping("/login")
	    public String login() {
	        return "login";
	    }
	}
	
//	@Controller
//	public class RegisterController{
//	@RequestMapping("/signup") 
//	public String signupForm() { 
//		return "signup"; 
//		}
//	}
//	
	
	 
	
	
	@Controller
	public class LogoutController {
	    @GetMapping("/logout")
	    public String logout() {
	        // Handle logout logic here
	        return "redirect:/login";
	    }
	}

}
