package com.example.firstP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class Stsproject1Application {

	public static void main(String[] args) {
		SpringApplication.run(Stsproject1Application.class, args);
		System.out.println("Springboot started from sts tool!");
	}

}
