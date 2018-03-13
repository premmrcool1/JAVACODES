package org.prem.example;
 
import java.sql.Connection;
import java.sql.DriverManager;

 
public class Database
{
public Connection getConnection() throws Exception
{
try
{
String connectionURL = "jdbc:oracle:thin:@localhost:1521:CUSTCORE";
Connection connection = null;
Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
connection = DriverManager.getConnection(connectionURL, "CUSTCORE", "ashubaby");
return connection;
} catch (Exception e)
{
throw e;
}
 
}
 
}