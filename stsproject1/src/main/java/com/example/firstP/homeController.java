package com.example.firstP;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


public class homeController {
	@RequestMapping("home")
	public String home() {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		return "home";
	}
}
