package org.prem.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import com.google.gson.JsonObject;

/**
 * 
 */

/**
 * @author rhassidi
 *
 */
public class CustomerServiceClient {
    /**
     * Store record in the remote datastore when the air quality
     * level has exceeded the allowed threshold of safety
     */
	
	
	public static void main(String[] args) {

		final Properties prop = new Properties();
		//final InputStream input = null;
		
	    System.out.println("Air quality alert");
	     Thread thread = new Thread(new Runnable() {

	    @Override
	    public void run() {
		try {
			
			InputStream input = new FileInputStream("C:\\Users\\Premkumar.Nagarajan\\Desktop\\eclipse\\config1.properties");
			//input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);

			// get the property value and print it out
			//db = prop.getProperty("server");

			String  url = prop.getProperty("server");
			HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "text/html; charset=utf-8");

		   // String url = config.getProperty("SERVER");
		    //HttpURLConnection httpConnection = (HttpURLConnection) (new URL(url)).openConnection();
		    //httpConnection.setRequestMethod("PUT");
		    //httpConnection.setDoOutput(true);
		    //httpConnection.setDoInput(true);
		    //httpConnection.setRequestProperty("Content-Type", "application/json");
		    //httpConnection.setRequestProperty("Accept", "application/json");
		    //httpConnection.setRequestProperty("X-Auth-Token", config.getProperty("AUTH_TOKEN"));
		    //JsonObject jsonObject = new JsonObject();
		    //jsonObject.addProperty("value", "Datastore notified of air quality alert on " + new Date().toString());

		    //System.out.println(jsonObject.toString());

		    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		   // wr.write(jsonObject.toString());
		    wr.flush();
		    int HttpResult = conn.getResponseCode(); 
		    //System.out.println("status of call: " + HttpResult);
		    if(HttpResult != HttpURLConnection.HTTP_CREATED){
			StringBuilder sb = new StringBuilder();  
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));  
			String line = null;  
			while ((line = br.readLine()) != null) {  
			    sb.append(line + "\n");  
			}  
			br.close();  
			System.out.println(""+sb.toString());  
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    System.out.println("problem sending data to Database");

		}
	    }
	});
	thread.run();

    }

}