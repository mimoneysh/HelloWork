package sessionDemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class Controller {
	
	
	
	@GetMapping("/")
	public String process(Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");

		if (messages == null) {
			messages = new ArrayList<>();
			System.out.println("Hello from begning!");
		}
		model.addAttribute("sessionMessages", messages);
		System.out.println("Hello from process!");
		return "index";
	}

	@PostMapping("/persistMessage")
	public String persistMessage(@RequestParam("msg") String msg, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
			System.out.println("Hello from my session messages!");
		}
		messages.add(msg);
		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		System.out.println("Hello from add sessionmessages!");
		return "redirect:/";
	}

	@PostMapping("/destroy")
	public String destroySession(HttpServletRequest request) {
		System.out.println("Hello from Destroy initiated!");
		request.getSession().invalidate();
		System.out.println("Hello from destroy completed!");
		return "redirect:/";
	}

}
