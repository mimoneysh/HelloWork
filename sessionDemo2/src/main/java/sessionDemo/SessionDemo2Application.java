package sessionDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
@EnableJdbcHttpSession
@SpringBootApplication
public class SessionDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(SessionDemo2Application.class, args);
		System.out.println("Hello from Application!");
		
	}
	
	
}
