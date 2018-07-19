package College;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter syso = response.getWriter();
		String user = request.getParameter("user");
		String pssd = request.getParameter("pssd");
		
		
		try {
			Database d = new Database();     
			int i = Database.register(user, pssd); 
			syso.println("<h3 align='center'> Successfuly Registered </h3>");	
			RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
            rd.include(request, response);
		}
	    catch(Exception e)
		{
			syso.println("<h3 align='center'> Exception Occured "+e.getMessage()+"+</h3>");	
			RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
            rd.include(request, response);
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
