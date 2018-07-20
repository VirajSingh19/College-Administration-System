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
//		response.sendRedirect("Welcome.html");
	PrintWriter syso = response.getWriter();
	session = request.getSession();
	String user = (String)session.getAttribute(fn);
	String id = session.getId();
	long creationtime = session.getCreationTime();
	long lastacctime = session.getLastAccessedTime();
	
	RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
    rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	
	public static void closesession(HttpSession session)
	{
	session.invalidate();		
	}

}
