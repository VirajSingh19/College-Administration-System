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

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static String fn="";   
    public static HttpSession session;
    public Welcome() {
        super();   
    }

    static void _init_(String n)
    {
       fn =n;	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter syso = response.getWriter();
	session = request.getSession();
	
	
	String u = request.getParameter("select");
	
	if(u.equals("Courses"))
		syso.println("Courses");
	else if(u.equals("Table"))
		printtable(syso);
	else if(u.equals("Fee"))
		syso.println("Fee");
	else if(u.equals("Modify"))
		syso.println("Modify");
	RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
	rd.include(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	
	public static void closesession(HttpSession session)
	{
	session.invalidate();		
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
			 for(int j=0;j<up.length;j++)
				 syso.println("<td> "+up[j]+"</td>");
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
