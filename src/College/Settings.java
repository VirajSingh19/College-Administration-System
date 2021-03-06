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

@WebServlet("/Settings")
public class Settings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Settings() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String oldpssd = request.getParameter("oldpssd");
		String newpssd = request.getParameter("newpssd");
		String delpssd = request.getParameter("delpssd");
		PrintWriter syso = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("Settings.jsp");
		
		try {
			
		Database d = new Database();
		if(oldpssd.length()>0 && newpssd.length()>0)
		{
			int i = Database.update(user, oldpssd, newpssd);
			if(i==1)
			syso.println("<h3 align='center'> Successfully Updated </h3>");
			else
			syso.println("<h3 align='center'> Can't Update </h3>");
			rd.include(request, response);
		}
		else if(delpssd.length()>0)
		{
			int i = Database.delete(user, delpssd);
			if(i==1)
			syso.println("<h3 align='center'> Account Deleted </h3>");
			else
			syso.println("<h3 align='center'> Wrong Password </h3>");
			rd.include(request, response);				
		}
		}
		catch (Exception e) {
			syso.println("Exception occurred "+e.getMessage());
			rd.include(request, response);
		}
		
		
	}

}
