package sessionServelet;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.boot.web.servlet.ServletComponentScan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/LogoutServlet")
public class LogoutServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)  
             throws ServletException, IOException {  
response.setContentType("text/html");  
PrintWriter out=response.getWriter();  

request.getRequestDispatcher("link.html").include(request, response);  

HttpSession session=request.getSession();  
session.invalidate();  

out.print("You are successfully logged out!");  

out.close();  
} 
}
