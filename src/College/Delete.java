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

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Delete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String user =request.getAttribute("user").toString();
  		String pssd = request.getParameter("pssd");
  		RequestDispatcher rd = request.getRequestDispatcher("Seetings.jsp");
  		PrintWriter syso = response.getWriter();
  		
  		try {
			Database d = new Database();
			int i = Database.delete(user, pssd);
			if(i==1)
			{
				syso.println("<h3 align='center'> Account successfuly deleted </h3>");
				rd.include(request, response);
			}
			else
			{
				syso.println("<h3 align='center'> Can't delete </h3>");
				rd.include(request, response);			
			}
		} catch (Exception e) {
			syso.println("<h3 align='center'> Exception "+e.getMessage()+"</h3>");
			rd.include(request, response);					
		}
		
	}

}
