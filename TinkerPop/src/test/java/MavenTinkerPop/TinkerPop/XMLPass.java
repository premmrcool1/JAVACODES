package MavenTinkerPop.TinkerPop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import Com.jaxb.xml.*;
import Com.jaxb.xml.Object;

public class XMLPass {
	static ArrayList<Object> arraylist = new ArrayList<Object>();
	public static void main(String[] args) throws JAXBException {
		   String csvFile = "C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_TBL1_to_TBL2_detail.csv";
	        String line = "";
	        String cvsSplitBy = ",";
	        MultipleRootElementJava x=new MultipleRootElementJava();
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
	               // System.out.println(SourceVerTexType);
	                if(SourceVerTexType.equalsIgnoreCase( "Locator"))
	                {
	                 Object b=x.ObjectCreation(TargetName, "1404", "9904", "Schem-none"+"graphml"+TargetVer, "Schem-none"+"graphml");
	                 arraylist.add(b);
	                System.out.println(TargetVertexType);
	                System.out.println(TargetVer);
	                System.out.println(TargetName);
	                }

	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        Model m=x.addtion(arraylist);
	        x.XMlCreation(m);

		// TODO Auto-generated method stub

	}

}
