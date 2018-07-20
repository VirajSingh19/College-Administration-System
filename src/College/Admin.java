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
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HttpSession session;   
    public Admin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	session = request.getSession();
		PrintWriter syso  = response.getWriter();
		String u = request.getParameter("select");
		
		if(u.equals("Courses"))
			syso.println("Courses");
		else if(u.equals("Table"))
			printtable(syso);
		else if(u.equals("Fee"))
			syso.println("Fee");
		else if(u.equals("Modify"))
			syso.println("Modify");
		RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
		rd.include(request, response);
		
	}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	static void printtable(PrintWriter syso)
	{
		
		
		try {
		Database d = new Database();
		String s = Database.admin();
	    String str[] = s.split("#");
	    syso.println("<div class='container'>");
		syso.println("<table class='table'>");
		syso.println("<thead>");
		syso.println("<tr>");
		syso.println("<th>UserName </th>");
		syso.println("<th>Password </th>");
		syso.println("<th>Rollno </th>");
		syso.println("</tr>"); 
		syso.println("</thead>");
		syso.println("<tbody>");
		 for(String i : str)
		 {
			 String up[] = i.split(":");
			 syso.println("<tr>");
			 syso.println("<td> "+up[0]+"</td>");
			 syso.println("<td> "+up[1]+"</td>");
			 syso.println("<td> "+up[2]+"</td>");
			 syso.println("</tr>");
		 }
		 syso.println("</tbody>");			
		 syso.println("</table>");			
		 syso.println("</div>");	
		}
		catch(Exception e)
		{
			syso.println("Exception occurred!"+e.getMessage());
		}
		
		
		

		
	}
}
