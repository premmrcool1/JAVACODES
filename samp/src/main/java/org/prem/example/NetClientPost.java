package org.prem.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class NetClientPost {

	// http://localhost:8080/RESTfulExample/json/product/post
	public static void main(String[] args) {
		final Properties prop = new Properties();
	  try {
		  
		  InputStream input = new FileInputStream("C:\\Users\\Premkumar.Nagarajan\\Desktop\\eclipse\\config1.properties");
			//input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);

			// get the property value and print it out
			//db = prop.getProperty("server");

			String  url = prop.getProperty("server");
			HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();

		//URL url = new URL("http://localhost:8083/samp/Rest/courseService/add/4/");
		//HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "text/html");
        //conn.setRequestProperty("Accept", "text/html");
		String input1 = "{\"qty\":100,\"name\":\"iPad 4\"}";

		OutputStream os = conn.getOutputStream();
		os.write(input1.getBytes());
		os.flush();
		
		System.out.println(conn.getResponseCode());

		/*if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ conn.getResponseCode());
		}*/

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	 }

	}

}