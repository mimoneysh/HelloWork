package sessionServelet;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
response.setContentType("text/html");  
PrintWriter out=response.getWriter();  
request.getRequestDispatcher("link.html").include(request, response);  
  
String name=request.getParameter("name");  
String password=request.getParameter("password");  
  
if(password.equals("admin123")){  
out.print("Welcome, "+name);  
HttpSession session=request.getSession();  
session.setAttribute("name",name);  
}  
else{  
    out.print("Sorry, username or password error!");  
    request.getRequestDispatcher("login.html").include(request, response);  
}  
out.close();  
}  
}
