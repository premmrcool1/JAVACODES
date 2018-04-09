package com.salesforce.object;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.log4j.PropertyConfigurator.*;
import javax.xml.bind.JAXBException;

import com.xml.gen.Object;
import com.xml.gen.Relation;

import com.xml.gen.ObjectFactory;
import com.xml.gen.XMLGEN;

import com.xml.gen.Model;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class MMXLCreation {
	 

	private static final Class<?> thisClass = new Object() {
	}.getClass().getEnclosingClass();
	private static final Logger logger = Logger.getLogger("MMXLCreation.class");
	
	private static Options options = null;
	private CommandLine cmd = null; // Command Line arguments
	private static final String SERVER_NAME =  "s";
	private static final String SCHEMA_NAME = "c";
	private static final String Graph_path = "g";
	private static final String MMXML_PATH = "m";
	
	static{
	options = new Options();
	options.addOption(SERVER_NAME, true,"SERVER_NAME").hasOption(SERVER_NAME);
	options.addOption(SCHEMA_NAME, true, "Schema_name").hasOption(SCHEMA_NAME);
	options.addOption(Graph_path, true, "Graph_path").hasOption(Graph_path);
	options.addOption(MMXML_PATH, true, "MMXML_PATH").hasOption(MMXML_PATH);
	}
	
	static ArrayList<Object> objectList = new ArrayList<>();
    static ArrayList<Relation> relationList = new ArrayList<>();
    static XMLGEN x=new XMLGEN();
   	static ObjectFactory oF=new ObjectFactory();
    static RestClientCall call_new=new RestClientCall();
    com.xml.gen.Model m =oF.createModel();
    
	 public static void main(String args[]) throws IOException, JAXBException, InterruptedException {
		   
		 MMXLCreation cliProg = new MMXLCreation();

		 cliProg.loadArgs(args);
		 
		
	  
	        // objectList.add(x.ObjectCreation(objectName, "RA Dataset", "RA Server", "schema-Force.com://"+ "Force.com" + "/" +Schemaname+"/"+ objectName,  "schema-Force.com://"+ "Force.com" + "/"+Schemaname));
	   }
	         
	
public static void Filecre(String graphPath,String Schemaname,String Schemaref,String name) throws JAXBException, MalformedURLException, IOException, InterruptedException
{
	  try (BufferedReader br = new BufferedReader(new FileReader(graphPath))) {
          
      	
      	int lastindex=graphPath.toString().lastIndexOf("\\");
      	int filenamelastindex=graphPath.toString().substring(lastindex+1).lastIndexOf(".");
      	String objectName = graphPath.toString().substring(lastindex+1,lastindex+1+filenamelastindex);
      	String line = "";

	        String cvsSplitBy = ",";
      	System.out.println(objectName);
      	  objectList.add(x.ObjectCreation(objectName, "RA Dataset", "RA Server", Schemaref + name  + "/" +Schemaname+"/"+ objectName,  Schemaref + name + "/"+Schemaname));
         
      	  while ((line = br.readLine()) != null) {

              // use comma as separator

              String[] vertices = line.split(cvsSplitBy);
              String SourceVer=vertices[0].trim();
              String SourceVer1=vertices[1].trim();
              String TargetVer=vertices[2].trim();
            
              System.out.println(SourceVer1+","+SourceVer1+","+TargetVer);
              
             objectList.add(x.ObjectCreation(SourceVer, "RA Field", "RA Dataset", Schemaref + name + "/" +  Schemaname+"/"+objectName+"/"+SourceVer,  Schemaref + name + "/"+ Schemaname+"/"+objectName));
             relationList.add(x.RelationCreation("10",(short) 1707, (short)1706, Schemaref + name + "/" +  Schemaname+"/"+objectName+"/"+SourceVer,Schemaref + name + "/"+ Schemaname+"/"+objectName))  ;        
      	  }
         
      } catch (IOException e) {
          e.printStackTrace();
      }
	  
      
  
}
private static Map<Integer, String> unzip(String zipFilePath, String destDir) {
	int num = 0;
	Map<Integer, String> paths = new LinkedHashMap<>();
    File dir = new File(destDir);
    // create output directory if it doesn't exist
    if(!dir.exists()) dir.mkdirs();
    FileInputStream fis;
    //buffer for read and write data to file
    byte[] buffer = new byte[1024];
    try {
        fis = new FileInputStream(zipFilePath);
        ZipInputStream zis = new ZipInputStream(fis);
        ZipEntry ze = zis.getNextEntry();
        while(ze != null){
        	num++;
            String fileName = ze.getName();
            File newFile = new File(destDir + File.separator + fileName);
            paths.put(num, newFile.getAbsolutePath());
            System.out.println("Unzipping to "+newFile.getAbsolutePath());
            //create directories for sub directories in zip
            new File(newFile.getParent()).mkdirs();
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
            }
            fos.close();
            //close this ZipEntry
            zis.closeEntry();
            ze = zis.getNextEntry();
        }
        //close last ZipEntry
        zis.closeEntry();
        zis.close();
        fis.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return paths;
}
public void loadArgs(String[] args) throws MalformedURLException, JAXBException, IOException, InterruptedException{
	CommandLineParser parser = new DefaultParser();
	try {
		cmd = parser.parse(options, args);
	} catch (ParseException e) {
		System.err.println("Error parsing arguments");
		e.printStackTrace();
		System.exit(1);
	}
	
	// Check for mandatory args
	
	if (! cmd.hasOption(SERVER_NAME)){
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("java -jar this_jar.jar", options);
		System.exit(1);
	}
	if (! cmd.hasOption(SCHEMA_NAME)){
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("java -jar this_jar.jar", options);
		System.exit(1);
	}
	if (! cmd.hasOption(MMXML_PATH)){
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("java -jar this_jar.jar", options);
		System.exit(1);
	}
	
	if (! cmd.hasOption(Graph_path)){
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("java -jar this_jar.jar", options);
		System.exit(1);
	}
	
	String name =  cmd.getOptionValue(SERVER_NAME);
	String Schemaname = cmd.getOptionValue(SCHEMA_NAME);
	String graphPath = cmd.getOptionValue(Graph_path);
	String mmxmlpath= cmd.getOptionValue(MMXML_PATH);
				
	String extension = "";
				
			logger.info("Path for file "  + graphPath);
				//System.out.println(graphPath);
				int i = graphPath.lastIndexOf('.');
		        String line = "";
		        String cvsSplitBy = ",";
		        String Schemaref="schema-"+name+"://";
		        logger.info(Schemaref);
		    	objectList.add(x.ObjectCreation(name, "RA Server", "", Schemaref+ name + "/" +Schemaname,  ""));      
		    	if (i > 0) {
				    extension = graphPath.substring(i+1);
				    if(extension.equalsIgnoreCase("csv")) {
				    	Filecre(graphPath,Schemaname,Schemaref,name);
						//makeRequest(name, schema, graphPath);
					}
				    else if(extension.equalsIgnoreCase("zip")) {
						String zipFilePath = graphPath;
						int dir = graphPath.lastIndexOf(File.separator);
						String desDir = graphPath.substring(0, dir-1) + File.separator + "target";
						Map<Integer, String> paths = unzip(zipFilePath, desDir);
						for(int j=1; j<=paths.size();j++) {
							System.out.println("path for each " + paths.get(j));
							Filecre(paths.get(j),Schemaname,Schemaref,name);
						}
					
				    }
				    else
				    {
				     logger.warning("Import Csv Files Only");	
				    }
				    
				}

		        x.addtion(objectList);
		        x.Reladdtion(relationList);
		        x.XMlCreation(mmxmlpath,"ReportingAnalysis","0.0.0","yes",Schemaref+ name);
		       // call_new.makeRequest("common_new.xml",servername,Authkey);

		        

	

}

}
	 




