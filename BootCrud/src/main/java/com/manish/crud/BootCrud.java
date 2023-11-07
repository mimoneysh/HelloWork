package com.manish.crud;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BootCrud {
	
	@Bean
	public DataSource dataSource() {
	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	 dataSource.setUrl("jdbc:mysql://localhost:3306/manish");
	 dataSource.setUsername("root"); dataSource.setPassword("");
	 System.out.println("Connection Success!");
	 return dataSource;
	}
	
	@GetMapping("/welcome")
	public String welcome(){
		return "Hello From controller";
	}

}
