package org.prem.example;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesClass {
  public static void main(String[] args) {

	Properties prop = new Properties();
	InputStream input = null;
	String db;
	String user;
	String password;

	try {

		input = new FileInputStream("config.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
		db = prop.getProperty("database");
		user = prop.getProperty("dbuser");
		password = prop.getProperty("dbpassword");
		
		System.out.println(db);
		System.out.println(user);
		System.out.println(password);

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

  }
}
