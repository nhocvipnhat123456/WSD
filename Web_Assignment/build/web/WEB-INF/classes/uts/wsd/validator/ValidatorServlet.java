package uts.wsd.validator;
 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.wsd.User;
import uts.wsd.UserApplication;
import uts.wsd.Users;

@WebServlet("/ValidatorServlet")
public class ValidatorServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileNotFoundException {
		String dir = getServletContext().getRealPath("WEB-INF/users.xml");;
            
                UserApplication ua = new UserApplication();
            try {
                ua.setFilePath(dir);
                ua.LoadUsers();
            } catch (Exception ex) {
                Logger.getLogger(ValidatorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
                Users users = ua.getUsers();
                
		String email = request.getParameter("email");
		String password = request.getParameter("password");
                
                
		if (email.isEmpty() || password.isEmpty() )
		{
                    String error = "Email or Password are empty, Please type email and password correctly";
                    request.setAttribute("error",error);
                    RequestDispatcher view = request.getRequestDispatcher("login.jsp");
                    view.forward(request,response);
		} else {
                    User user = users.login(email, password);
                    if (user.equals((null))){
                        String error = "Incorrect email or password";
                        request.setAttribute("error",error);
                        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
                        view.forward(request,response);
                    } else {
                        response.sendRedirect("main.jsp");
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                    }
                }
	}
 
}