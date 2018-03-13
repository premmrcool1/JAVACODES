package com.force.objectCre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import com.jaxb.xml.Object;
import com.jaxb.xml.Relation;

import com.jaxb.xml.ObjectFactory;
import com.jaxb.xml.XMLGEN;

import com.jaxb.xml.Model;

public class ObjectRelationShipCreation {
	 //static ArrayList<Object> objectList = new ArrayList<>();
     //static ArrayList<Relation> relationList = new ArrayList<>();
	 public static void main(String args[]) throws IOException, JAXBException, InterruptedException {
		    
		    String name = args[0];
			String schema = args[1];
			String graphPath = args[2];
			String Servername=args[3];
			String Authkey=args[4];
			String extension = "";
			
		
			System.out.println(graphPath);
			int i = graphPath.lastIndexOf('.');
		 
		    String csvFile = "C:\\Users\\Premkumar.Nagarajan\\Desktop\\Salesforce\\Files\\Account.csv";
	        String line = "";
	        String cvsSplitBy = ",";
	        XMLGEN x=new XMLGEN();
	        RestClientCall call_new=new RestClientCall();
	        ArrayList<Object> objectList = new ArrayList<>();
	        ArrayList<Relation> relationList = new ArrayList<>();
	        String FilePath = "C:\\Users\\Premkumar.Nagarajan\\Desktop\\Salesforce\\ObjectXML\\";
	        String SourcePath = "C:\\Users\\Premkumar.Nagarajan\\Desktop\\Salesforce\\Files_Test\\";
	        
	    	if (i > 0) {
			    extension = graphPath.substring(i+1);
			    if(extension.equalsIgnoreCase("graphml")) {
					//makeRequest(name, schema, graphPath);
				}
			}

	        File dir = new File(SourcePath);
	        File[] directoryListing = dir.listFiles();
	        
	    	ObjectFactory oF=new ObjectFactory();
	    	objectList = new ArrayList<>();
	    	relationList = new ArrayList<>();
	        String Schemaname="Salesforce";
	        String objectName="Account";
	    	objectList.add(x.ObjectCreation("Force.com_NEW1", "RA Server", "", "schema-Force.com://"+ "Force.com" + "/" +Schemaname,  ""));
	        // objectList.add(x.ObjectCreation(objectName, "RA Dataset", "RA Server", "schema-Force.com://"+ "Force.com" + "/" +Schemaname+"/"+ objectName,  "schema-Force.com://"+ "Force.com" + "/"+Schemaname));
	         if (directoryListing != null) {
	        	    for (File child : directoryListing) {
	        try (BufferedReader br = new BufferedReader(new FileReader(child))) {
                
	        	
	        	int lastindex=child.toString().lastIndexOf("\\");
	        	int filenamelastindex=child.toString().substring(lastindex+1).lastIndexOf(".");
	        	objectName = child.toString().substring(lastindex+1,lastindex+1+filenamelastindex);
	        	System.out.println(objectName);
	        	  objectList.add(x.ObjectCreation(objectName, "RA Dataset", "RA Server", "schema-Force.com://"+ "Force.com" + "/" +Schemaname+"/"+ objectName,  "schema-Force.com://"+ "Force.com" + "/"+Schemaname));
	            while ((line = br.readLine()) != null) {

	                // use comma as separator

	                String[] vertices = line.split(cvsSplitBy);
	                String SourceVer=vertices[0].trim();
	                String SourceVer1=vertices[1].trim();
	                String TargetVer=vertices[2].trim();
	              
	                System.out.println(SourceVer1+","+SourceVer1+","+TargetVer);
	                objectList.add(x.ObjectCreation(SourceVer, "RA Field", "RA Dataset", "schema-Force.com://"+ "Force.com" + "/" +  Schemaname+"/"+objectName+"/"+SourceVer,  "schema-Force.com://"+ "Force.com" + "/"+ Schemaname+"/"+objectName));
	            }
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        	    }
	         }
	         com.jaxb.xml.Model m =oF.createModel();
	            
	            x.addtion(objectList);
	            x.Reladdtion(relationList);
	            x.XMlCreation(FilePath+"common_new.xml","ReportingAnalysis","0.0.0","yes","schema-Force.com://Force.com");
	           call_new.makeRequest(FilePath+"common_new.xml",Servername,Authkey);
	 }

}
