package org.prem.example;
 
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
 
import org.prem.example.Access;
import org.prem.example.Database;
import org.prem.example.Course;
 
public class AccessManager
{
public ArrayList<Course> getCourses() throws Exception
{
ArrayList<Course> courseList = new ArrayList<Course>();
Database db = new Database();
Connection con = db.getConnection();
Access access = new Access();
courseList = access.getCourses(con);
return courseList;
}
}