package pleaeswork.todayalso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.Driver;



@SpringBootApplication
public class TodayalsoApplication implements CommandLineRunner{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TodayalsoApplication.class, args);
		System.out.println("dedicated to the kid");
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(jdbcTemplate != null  ? " further code can be written" : "think why it is null");
		
	}

}
