package MavenTinkerPop.TinkerPop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import Com.jaxb.xml.*;
import jaxb.xml.graph.Model;
import jaxb.xml.graph.MultipleRootElementJava;
import jaxb.xml.graph.Object;
import jaxb.xml.graph.ObjectFactory;
import jaxb.xml.graph.Relation;

public class XMLPass {
	static ArrayList<Object> arraylist = new ArrayList<Object>();
	static ArrayList<Relation> arraylist1 = new ArrayList<Relation>();
	public static void main(String[] args) throws JAXBException {
		   String csvFile = "C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_TBL1_to_TBL2_detail.csv";
	        String line = "";
	        String cvsSplitBy = ",";
	        MultipleRootElementJava x=new MultipleRootElementJava();
	        ObjectFactory oF=new ObjectFactory();
	        Object b1=oF.createObject();
	        Relation R=oF.createRelation();
	        b1=x.ObjectCreation("PENTGRAPH1","Namespace", "UnstructuredData", "schema-none://"+"PENTGRAPH1", "schema-none://"+"PENTGRAPH1");
	        arraylist.add(b1);
	        b1=x.ObjectCreation("HKEX","9904","Namespace", "schema-none://"+"PENTGRAPH1/orionods", "schema-none://"+"PENTGRAPH1");
	        arraylist.add(b1);
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	            	
	                String[] vertices = line.split(cvsSplitBy);
	                String SourceVer=vertices[0].trim();
	                String TargetVer=vertices[1].trim();
	                String SourceName=vertices[2].trim();
	                String SourceVerTexType=vertices[3].trim();
	                String TargetName=vertices[4].trim();
	                String TargetVertexType=vertices[5].trim();
	                String Edge=vertices[6].trim();
	                String SourceStepType=vertices[7].trim();
	                String TargetStepType=vertices[9].trim();
	                /************Job Object Creator *************************/
	                if(SourceVerTexType.equalsIgnoreCase( "Locator"))
	                {
	                  Object b=x.ObjectCreation(TargetName, "1404", "9904", "schema-none://"+"PENTGRAPH1//orionods/"+TargetVer, "schema-none://"+"PENTGRAPH1/orionods");
	                  arraylist.add(b);
	                  //System.out.println(TargetVertexType);
	                  //System.out.println(TargetVer);
	                  //System.out.println(TargetName);
	                }
	                /************Stage Object Creator *************************/
	                if(SourceVerTexType.equalsIgnoreCase("Transformation") && TargetVertexType.equalsIgnoreCase("Transformation Step"))
	                {
	                  Object b=x.ObjectCreation(TargetName, "151", "1404", "schema-none://"+"PENTGRAPH1//orionods/"+TargetVer, "schema-none://"+"PENTGRAPH1//orionods/"+SourceVer);
	                  arraylist.add(b);
	                  //System.out.println(TargetVertexType);
	                  //System.out.println(TargetVer);
	                  //System.out.println(TargetName);
	                }
	                /************Fields Object Creator *************************/
	                if(SourceVerTexType.equalsIgnoreCase("Transformation Step") && TargetVertexType.equalsIgnoreCase("Transformation Stream field") && (Edge.indexOf("outputs") > 0))
	                {
	                  Object b=x.ObjectCreation(TargetName, "152", "151", "schema-none://"+"PENTGRAPH1//orionods/"+TargetVer, "schema-none://"+"PENTGRAPH1//orionods/"+SourceVer);
	                  arraylist.add(b);
	                  //System.out.println(TargetVertexType);
	                  //System.out.println(TargetVer);
	                 // System.out.println(SourceName+"-"+TargetName+"|"+SourceVer+"-"+TargetVer);
	                  //System.out.println(TargetName);
	                }
	                /************DI Source Object fields Creator && DI Source fields  to Mapping fields Relation Creator *************************/
	                if(SourceVerTexType.equalsIgnoreCase("Transformation Step") && TargetVertexType.equalsIgnoreCase("Transformation Stream field") && SourceStepType.equalsIgnoreCase("Table output"))
	                {
	                  Object b=x.ObjectCreation(TargetName, "1413", "1412", "schema-none://"+"PENTGRAPH1//orionods/"+TargetVer, "schema-none://"+"PENTGRAPH1//orionods/"+SourceVer);
	                  arraylist.add(b);
	                  R=x.RelationCreation("10", (short) 152, (short) 1413,"schema-none://"+"PENTGRAPH1//orionods/"+TargetVer ,"schema-none://"+"PENTGRAPH1//orionods/"+TargetVer);
	                   arraylist1.add(R);
	                  //System.out.println(TargetVertexType);
	                  //System.out.println(TargetVer);
	                 // System.out.println(SourceName+"-"+TargetName+"|"+SourceVer+"-"+TargetVer);
	                  //System.out.println(TargetName);
	                }
	                /************DI Target Fields Object Creator && DI Target  fields to Mapping fields Relation Creator *************************/
	                if(SourceVerTexType.equalsIgnoreCase("Transformation Step") && TargetVertexType.equalsIgnoreCase("Transformation Stream field") && SourceStepType.equalsIgnoreCase("Table input"))
	                {
	                  Object b=x.ObjectCreation(TargetName, "1413", "1411", "schema-none://"+"PENTGRAPH1//orionods/"+TargetVer, "schema-none://"+"PENTGRAPH1//orionods/"+SourceVer);
	                  arraylist.add(b);
	                  R=x.RelationCreation("10", (short) 1413, (short) 152,"schema-none://"+"PENTGRAPH1//orionods/"+TargetVer ,"schema-none://"+"PENTGRAPH1//orionods/"+TargetVer);
	                   arraylist1.add(R);
	           
	    
	                  System.out.println(TargetVertexType);
	                  //System.out.println(TargetVer);
	                 // System.out.println(SourceName+"-"+TargetName+"|"+SourceVer+"-"+TargetVer);
	                  //System.out.println(TargetName);
	                }
	                /*************DI Target creation && DI Target to Mapping*************/
	                if(SourceVerTexType.equalsIgnoreCase("Transformation") && TargetVertexType.equalsIgnoreCase("Transformation Step") && TargetStepType.equalsIgnoreCase("Table output"))
	                {
	                  Object b=x.ObjectCreation(TargetName, "1412", "1404", "schema-none://"+"PENTGRAPH1//orionods/"+TargetVer, "schema-none://"+"PENTGRAPH1//orionods/"+SourceVer);
	                  arraylist.add(b);
	                  R=x.RelationCreation("10", (short) 151, (short) 1412,"schema-none://"+"PENTGRAPH1//orionods/"+TargetVer ,"schema-none://"+"PENTGRAPH1//orionods/"+TargetVer);
	                   arraylist1.add(R);
	                  System.out.println("iN TRAN");
	                  //System.out.println(TargetVer);
	                  System.out.println(SourceName+"-"+TargetName+"|"+SourceVer+"-"+TargetVer);
	                  //System.out.println(TargetName);
	                }
	                /*************DI Source creation && DI Source to Mapping*************/
	                if(SourceVerTexType.equalsIgnoreCase("Transformation") && TargetVertexType.equalsIgnoreCase("Transformation Step") && TargetStepType.equalsIgnoreCase("Table input"))
	                {
	                  Object b=x.ObjectCreation(TargetName, "1411", "1404", "schema-none://"+"PENTGRAPH1//orionods/"+TargetVer, "schema-none://"+"PENTGRAPH1//orionods/"+SourceVer);
	                  arraylist.add(b);
	                  R=x.RelationCreation("10", (short) 1411, (short) 151,"schema-none://"+"PENTGRAPH1//orionods/"+TargetVer ,"schema-none://"+"PENTGRAPH1//orionods/"+TargetVer);
	                   arraylist1.add(R);
	                  //System.out.println(TargetVertexType);
	                  //System.out.println(TargetVer);
	                  System.out.println(SourceName+"-"+TargetName+"|"+SourceVer+"-"+TargetVer);
	                  //System.out.println(TargetName);
	                }
	               /* if(SourceVerTexType.equalsIgnoreCase("Transformation Step") && SourceStepType.equalsIgnoreCase("Table input"))
	                {
	                  Object b=x.ObjectCreation(SourceName, "1411", "1404", "schema-none://"+"PENTGRAPH1//orionods/"+TargetVer, "schema-none://"+"PENTGRAPH1//orionods/"+SourceVer);
	                  arraylist.add(b);
	                  //System.out.println(TargetVertexType);
	                  //System.out.println(TargetVer);
	                  System.out.println(SourceName+"-"+TargetName+"|"+SourceVer+"-"+TargetVer);
	                  //System.out.println(TargetName);
	                }*/
	                /************Mapping to Mapping Relation creator *************************/
	                if(SourceVerTexType.equalsIgnoreCase("Transformation Step") && TargetVertexType.equalsIgnoreCase("Transformation Step"))
	                {
	                    R=x.RelationCreation("10", (short) 151, (short) 151,"schema-none://"+"PENTGRAPH1//orionods/"+SourceVer ,"schema-none://"+"PENTGRAPH1//orionods/"+TargetVer);
	                   arraylist1.add(R);
	                   //System.out.println(TargetVertexType);
	                  //System.out.println(TargetVer);
	                  //System.out.println(SourceName+"-"+TargetName+"|"+SourceVer+"-"+TargetVer);
	                  //System.out.println(TargetName);
	                }
	                /************Mapping Fields Relation Creator *************************/
	                if(SourceVerTexType.equalsIgnoreCase("Transformation Stream field") && TargetVertexType.equalsIgnoreCase("Transformation Stream field"))
	                {
	                    R=x.RelationCreation("10", (short) 152, (short) 152,"schema-none://"+"PENTGRAPH1//orionods/"+SourceVer ,"schema-none://"+"PENTGRAPH1//orionods/"+TargetVer);
	                   arraylist1.add(R);
	                   //System.out.println(TargetVertexType);
	                  //System.out.println(TargetVer);
	                  //System.out.println(SourceName+"-"+TargetName+"|"+SourceVer+"-"+TargetVer);
	                  //System.out.println(TargetName);
	                }
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       /* Model m=oF.createModel();	        
	        m.setImplicitTypes("yes");
	        m.setName("PENTGRAPH1");
	        m.setSchemaref("schema-none://PENTGRAPH1");
	        m.setXsltVersion("0.0.0");*/
	        x.addtion(arraylist);
	        x.Reladdtion(arraylist1);
	        x.XMlCreation();

		// TODO Auto-generated method stub

	}

}
			