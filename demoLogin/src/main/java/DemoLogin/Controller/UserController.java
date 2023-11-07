package DemoLogin.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DemoLogin.Model.User;
import DemoLogin.Model.UserStatus;
import DemoLogin.Service.UserService;
//@RestController
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	private static final Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/")
    public String loginPage() {
        return "login";
    }
	
	@GetMapping("/getUser/{email}")
	public UserStatus getUser(@PathVariable String email) {
		return userService.getUser(email);
		
	}
	
	@PostMapping("/signup")
	public boolean createUser(@RequestBody User newUser) {
		System.out.println("New User is: "+ newUser);
		return userService.createUser(newUser);
		
	}
	
	@GetMapping("/login")
	public String loginUser(@RequestParam String email,@RequestParam String password) {
		System.out.println("credentials are:"+email+" "+password);
		if (userService.loginUser(email, password)) {
			return "home";
		}
		else return "login";
	}
	
	
	
	
	
	
}
