package MavenTinkerPop.TinkerPop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Com.jaxb.xml.*;

public class XMLPass {

	public static void main(String[] args) {
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
	                System.out.println(TargetVertexType);
	                System.out.println(TargetVer);
	                System.out.println(TargetName);
	                }

	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }


		// TODO Auto-generated method stub

	}

}
