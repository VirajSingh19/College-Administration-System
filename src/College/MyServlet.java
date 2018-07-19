package College;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter syso = response.getWriter();
		String fn = request.getParameter("firstname");
		String pssd = request.getParameter("lastname");
		
		try {
		Database d = new Database();
		String l = Database.login(fn, pssd);
		
		if(l.equals("not found"))
		{
			syso.println("<h3 align='center'> Wrong password </h3>");
			RequestDispatcher rd = request.getRequestDispatcher("Form.jsp");
            rd.include(request, response);
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", fn);
			Welcome._init_(fn);
			RequestDispatcher r = request.getRequestDispatcher("Welcome");
            r.forward(request, response);
		}
		
		}catch(Exception e)
		{
			syso.println("<h3 align='center'> Exception Occurred "+e.getMessage()+"</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("Form.jsp");
            rd.include(request, response);
		}
		
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

