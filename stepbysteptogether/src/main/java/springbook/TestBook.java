package springbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


	
	@SpringBootApplication
	public class TestBook {

		public static void main(String[] args) {
			SpringApplication.run(TestBook.class, args);
			System.out.println("Test Book");
		}

	}


