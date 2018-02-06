package org.prem.InheritancePack;

import java.util.Scanner;
import java.io.*;


public class AllCapitals {
	   public static void main(String[] args) throws Exception {
	 
	      InputStream in = new FileInputStream(new File("C:\\Users\\Premkumar.Nagarajan\\Desktop\\samp.txt"));
	      OutputStream out = new FileOutputStream(new File("C:\\Users\\Premkumar.Nagarajan\\Desktop\\samp_test.txt"));
	      byte[] buf = new byte[1024];
	      int len;
	      
	      while ((len = in.read(buf)) > 0) {
	         out.write(buf, 0, len);
	      }
	      in.close();
	      out.close();
	      BufferedReader in1 = new BufferedReader(new FileReader("C:\\Users\\Premkumar.Nagarajan\\Desktop\\samp_test.txt"));
	      String str;
	      
	      while ((str = in1.readLine()) != null) {
	         System.out.println(str);
	      }
	      in.close();
	   }
	}