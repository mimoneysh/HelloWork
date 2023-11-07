package sessionLogin;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.util.StreamUtils; 
//import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;


import jakarta.servlet.http.HttpServletRequest;

@Controller
public class loginController {
	 @GetMapping("/login")
	    public String login() {
	        return "login";
	    }
	 
	 
	 
	 @GetMapping("/generateQRCode")
	 public ResponseEntity<byte[]> getImage(@RequestParam String text) {
	        try {
	            // Load the image from a file or any other source
	            String imageResource = "https://chart.googleapis.com/chart?chs=200x200&cht=qr&chl" + text;

	            // Read the image bytes
	          
	            byte[] imageBytes = restTemplate.getForObject(imageResource, byte[].class);
	            

	            // Set the appropriate content type for the response
	            HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.IMAGE_JPEG);
	            	
	            // Return the image bytes and content type as a response entity
	           return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
	        } catch (Exception e) {
	            // Handle exceptions if the image cannot be loaded
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 
	 @Autowired
	 private RestTemplate restTemplate;

	 @GetMapping("/generateQRCode1")
	 public byte[] generateQRCode(@RequestParam String text) throws Exception {
	     String apiUrl = "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=" + text;

	     byte[] qrCodeImage = restTemplate.getForObject(apiUrl, byte[].class);
		return qrCodeImage;
		
	  
	 }
	

	    @PostMapping("/login")
	    public String doLogin(HttpServletRequest request, String username, String password) {
	        if ("user".equals(username) && "password".equals(password)) {
	            // Successful login, set a session attribute to mark the user as authenticated
	            request.getSession().setAttribute("user", username);
	            return "redirect:/home";
	        } else {
	            // Invalid credentials, redirect back to the login page with an error message
	            return "redirect:/login?error=true";
	        }
	    }

	    @GetMapping("/home")
	    public String home(HttpServletRequest request, Model model) {
	        // Check if the user is authenticated by inspecting the session attribute
	        String user = (String) request.getSession().getAttribute("user");
	        if (user != null) {
	            model.addAttribute("user", user);
	            return "home";
	        } else {
	            return "redirect:/login";
	        }
	    }

	    @GetMapping("/logout")
	    public String logout(HttpServletRequest request) {
	        // Invalidate the session to log the user out
	        request.getSession().invalidate();
	        return "redirect:/login";
	    }
}
