package College;
import java.lang.Thread.State;
import java.sql.*;

public class Database {

	static Connection c;
	public Database()throws Exception
	{
    	Class.forName("org.sqlite.JDBC");
		this.c =  DriverManager.getConnection("jdbc:sqlite:D:\\new.sqlite");  
	}
	//jdbc:sqlite:C:\\Users\\admin.labpc-67\\eclipse-workspace\\Servlet1\\WebContent\\servlet.sqlite
	
public static void main(String args[])throws Exception
{
	Database d = new Database();
	
	System.out.println( update("Rishabh","Rajput" ,"Rahputana") );
	
//	delete("nick","nick");	

	//System.out.println(delete("Rishabh", "dealer"));
}

static String login(String user,String pssd)throws Exception
{
	
	Statement st = c.createStatement();
	ResultSet rs = st.executeQuery("Select * from Persons");
	while(rs.next())
	{
		if(rs.getString(1).equals(user) && rs.getString(2).equals(pssd))
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

static int register(String user,String pssd) throws SQLException
{
	PreparedStatement s=c.prepareStatement("insert into persons(username,password) values(?,?)");
	s.setString(1,user);
	s.setString(2,pssd);
	int i=s.executeUpdate();
	s.close();
	c.close();
	return i;
}

static String admin()throws Exception
{

	Statement st = c.createStatement();
	ResultSet rs = st.executeQuery("Select * from Persons");
	String s="";
	while(rs.next())
	{
		s+= rs.getString(1)+":"+ rs.getString(2)+"#";
	}
	rs.close();
	st.close();
	c.close();
	return s;
	
}

static int update(String user,String oldpssd, String newpssd)throws Exception
{
	Statement st = c.createStatement();
	int i= st.executeUpdate("update persons set password = '"+newpssd+"' where username = '"+user+"' and password = '"+oldpssd+"'");
	st.close();
	c.close();
	return i;
}


static int delete(String user,String pssd)throws Exception
{
	Statement st = c.createStatement();
	String q = "delete from persons where password = '"+pssd+"' and username = '"+user+"'";
    int i =st.executeUpdate(q);
	st.close();
	c.close();
	return i;
}


}
