package org.prem.example;

 
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
 
import org.prem.example.AccessManager;
 
import org.prem.example.Course;
 
@Path("/courseService")
public class CourseService
{
Properties prop = new Properties();
InputStream input = null;
String db;
String user;
String password;
private TreeMap<Integer, Book> bookMap = new TreeMap<Integer, Book>();
@GET
@Path("/courses")
@Produces("application/json")
public String courses()
{
String courses = null;
ArrayList<Course> courseList = new ArrayList<Course>();
try
{
courseList = new AccessManager().getCourses();
Gson gson = new Gson();
courses = gson.toJson(courseList);
} catch (Exception e)
{
e.printStackTrace();
}
return courses;
}
@POST
@Path("/add/{id}")
@Produces(MediaType.TEXT_HTML)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public Response addUser(@PathParam("id") int bookId,String chapterName) {

	try{  
		
		input = new FileInputStream("C:\\Users\\Premkumar.Nagarajan\\Desktop\\eclipse\\config.properties");
		//input = new FileInputStream("config.properties");
		// load a properties file
		prop.load(input);

		// get the property value and print it out
		db = prop.getProperty("database");
		user = prop.getProperty("dbuser");
		password = prop.getProperty("dbpassword");
		
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:"+db,user,password);  
		  
		//step3 create the statement object  
		Statement stmt=con.createStatement(); 
		Statement InsStmt=con.createStatement();
		  
		//step4 execute query  
		ResultSet rs=stmt.executeQuery("select CUSTOMER_TABLE1_FIELD1,CUSTOMER_NAME,CITY from CUSTCORE.CUSTOMER_TABLE4");  
		/*while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  */
		  
		//step5 close the connection object  
		while(rs.next())
		{
		 int CUSTOMER_TABLE1_FIELD2= bookId;
		 String CUSTOMER_NAME2= rs.getString("CUSTOMER_NAME");
		 String City2=rs.getString("CITY");
		 System.out.println(City2);
		 String output="Insert into CUSTCORE.CUSTOMER_TABLE2 " + "values("+CUSTOMER_TABLE1_FIELD2+",'"+CUSTOMER_NAME2+"','"+City2+"')";
		 InsStmt.executeQuery(output);	
		}
		System.out.println("Before close");
		//stmt.executeQuery("Insert into CUSTOMER_TABLE2 " + "values(101,'prem','S')");
		  
		  
		}catch(Exception e){ System.out.println(e);}  
		  
	return Response.status(200)
		.entity("Record Inserted"+ bookId)
		.build();

}
}
