package com.example1.firstSpring;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to first spring project!";
	}

}
