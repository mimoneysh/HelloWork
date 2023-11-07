package com.example.firstP;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to first STS project!";
	}
}
