package com.Aspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aspring.service.UserService;

import ch.qos.logback.core.model.Model;

//@RestController
public class ControllerDemo {
	
//	@Controller
	public class HomeController {
	    @GetMapping("/home")
	    public String home() {
	        return "home";
	    }
	}
//
//	@Controller
	public class LoginController {
	    @GetMapping("/login")
	    public String login() {
	        return "login";
	    }
	}

//	@Controller
//	public class SignupController {
//	    
//	    
//		@Autowired
//	    private UserService userService;
//
//	    @PostMapping("/signup")
//	    public ResponseEntity<String> signupUser(@RequestBody UserRegistrationRequest request) {
//	        userService.signupUser(request.getUsername(), request.getEmail(), request.getPassword());
//	        return ResponseEntity.ok("User registered successfully.");
//	    }
//	}

	//@Controller
	public class LogoutController {
	    @GetMapping("/logout")
	    public String logout() {
	        // Handle logout logic here
	        return "redirect:/login";
	    }
	}

	
	
	
	/*
	 * // display login form
	 * 
	 * @RequestMapping("/login") public String loginForm() { return "login-form"; }
	 * 
	 * // signup
	 * 
	 * @RequestMapping("/signup") public String signupForm() { return "SignUp"; }
	 * 
	 * //go to home page
	 * 
	 * @RequestMapping("/home") public String home() { return "Home-loggedIn"; }
	 * 
	 * //loout return to login
	 * 
	 * @RequestMapping("/logout") public String logout() { return "log-out"; }
	 */

}
