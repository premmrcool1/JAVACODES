package MavenTinkerPop.TinkerPop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.tinkerpop.gremlin.process.traversal.Path;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.io.IoCore;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

public class StageHierarchyExtract {
	

	  public static void main(String args[]) throws IOException {

				BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_TBL1_to_TBL2.txt"));
			  
	  
	    	final Graph newGraph = TinkerGraph.open();
	    	try {
				newGraph.io(IoCore.graphml()).readGraph("C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_TBL1_to_TBL2.graphml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	GraphTraversalSource n = newGraph.traversal();
	    	List<Map<String,Object>> nodes= n.V().has("type","Transformation").as("Job").out().has("type","Transformation Step").as("SourceStage").out().has("type","Transformation Step").as("Target Stage").values("name").select("Job","SourceStage","Target Stage").by("name").toList() ;   	
	    	List<Map<String,Object>> vertices= n.V().has("type","Transformation").as("Job").out().has("type","Transformation Step").as("SourceStage").out().has("type","Transformation Step").as("Target Stage").values("name").select("Job","SourceStage","Target Stage").by().toList() ; 
	    	//List<Map<String,Object>> nodes= n.V().has("type","Transformation").as("Job").out().has("type","Transformation Step").as("SourceStage").select("Job","SourceStage").by("name").toList() ;   	
	    	//nodes.addAll(vertices);
	    	Iterator<Map<String, Object>> iterator = nodes.iterator();
	    	Iterator<Map<String, Object>> iterator1 = vertices.iterator();
	        //System.out.println(nodes);
	    	vertices.forEach(System.out::println);
	    	
	    	writer1.write("JobName,SourceStage,TargetStage,JobNameVertexId,SourceStageVertexId,TargetNameVertexId\n");
	        while (iterator.hasNext() && iterator1.hasNext()) {
	        	String Str1=iterator.next().toString();
	        	String Str2=iterator1.next().toString();
	        	//System.out.println(Str1);
	        	Str1=Str1.replaceAll("\\{|\\[|\\]|\\}|Job=|SourceStage=|Target Stage=","");
	        	Str2=Str2.replaceAll("\\{|\\[|\\]|\\}|Job=|SourceStage=|Target Stage=|v\\[","");
	        	Str1=Str1.concat(",").concat(Str2);
	        	System.out.println(Str1);
	        	writer1.write(Str1);
	        	writer1.write("\n");
	    	}
	        writer1.close();
	    }

}
