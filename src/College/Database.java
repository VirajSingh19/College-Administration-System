package College;
import java.lang.Thread.State;
import java.sql.*;

public class Database {

	static Connection c;
	static Statement st;
	public Database()throws Exception
	{
    	Class.forName("org.sqlite.JDBC");
		this.c =  DriverManager.getConnection("jdbc:sqlite:D:\\new.sqlite"); 
		starter();
	}
	
public static void starter()throws Exception
{
	 st = c.createStatement();
	 boolean a = st.execute("PRAGMA foreign_keys = ON");
	  
}
	

public static void main(String args[])throws Exception
{
	Database d = new Database();
	
	//System.out.println(generic("select * from student",7 ));
	
	System.out.println(adminlogin("Viraj", "admin"));
 
}











static void pwd()
{
	 System.out.println("Working Directory = " +System.getProperty("user.dir"));
}

static String login(String user,String pssd)throws Exception
{
	
	ResultSet rs = st.executeQuery("Select * from student");
	while(rs.next())
	{
		if(rs.getString(1).equals(pssd) && rs.getString(5).equals(user))
		{
			rs.close();
			st.close();
			c.close();
			return user+"~"+pssd;}
		
	}
	rs.close();
	st.close();
	c.close();
	return "not found";
}


static String adminlogin(String user,String pssd)throws Exception
{
	
	ResultSet rs = st.executeQuery("Select * from admin");
	while(rs.next())
	{
		if(rs.getString(1).equals(user) && rs.getString(3).equals(pssd))
		{
			rs.close();
			st.close();
			c.close();
			return user+"~"+pssd;}
		
	}
	rs.close();
	st.close();
	c.close();
	return "not found";
}


static int register(String user,String pssd,String rollno) throws SQLException
{
	PreparedStatement pst=c.prepareStatement("insert into student(username,password,rollno) values(?,?,?)");
	pst.setString(1,user);
	pst.setString(2,pssd);
	pst.setString(3,rollno);
	int i=pst.executeUpdate();
	st.close();
	c.close();
	return i;
}

static String admin()throws Exception
{

	ResultSet rs = st.executeQuery("Select * from Student");
	String s="";
	while(rs.next())
	{
		s+= rs.getString(1)+":"+ rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4)+":"+rs.getString(5)+":"+rs.getString(6)+":"+rs.getString(7)+"#";
	}
	rs.close();
	st.close();
	c.close();
	return s;
}



static int addmissionno(String user)throws Exception
{

	ResultSet rs = st.executeQuery("select addmissionno from student where name='"+user+"'");

	while(rs.next())
	{
		return Integer.parseInt(rs.getString(1));
	}
	rs.close();
	st.close();
	c.close();
	return 404;
}


static String generic(String query,int rsN)throws Exception
{
	ResultSet rs = st.executeQuery(query);
	String s ="";
	while(rs.next())
	{
		for(int i=1;i<=rsN;i++)
		{
			s=s+rs.getString(i);
			if(i==rsN)
				s+="#";
			else
				s+=":";
		}
		
	}	
	rs.close();
	st.close();
	c.close();
	return s;
}


static int update(String user,String oldpssd, String newpssd)throws Exception
{
	int i= st.executeUpdate("update student set password = '"+newpssd+"' where name = '"+user+"' and password = '"+oldpssd+"'");
	st.close();
	c.close();
	return i;
}


static int delete(String user,String pssd)throws Exception
{
	String q = "delete from student where password = '"+pssd+"' and user = '"+user+"'";
    int i =st.executeUpdate(q);
	st.close();
	c.close();
	return i;
}


}
