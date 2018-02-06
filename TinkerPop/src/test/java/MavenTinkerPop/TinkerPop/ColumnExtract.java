package MavenTinkerPop.TinkerPop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.io.IoCore;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

public class ColumnExtract {
	  public static void main(String args[]) throws IOException {

			BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\XML_ColumnExtract.csv"));
		  

  	final Graph newGraph = TinkerGraph.open();
  	try {
			newGraph.io(IoCore.graphml()).readGraph("C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\XML Add - creating multi level XML files.graphml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	
  	GraphTraversalSource n = newGraph.traversal();
  	List<Map<String,Object>> nodes= n.V().has("type","Transformation").as("Job").out().has("type","Transformation Step").as("SourceStage").out().has("type","Transformation Stream field").as("Column Name").values("name").select("Job","SourceStage","Column Name").by("name").toList() ;   	
  	//List<Map<String,Object>> nodes= n.V().has("type","Transformation").as("Job").out().has("type","Transformation Step").as("SourceStage").select("Job","SourceStage").by("name").toList() ;   	
  	Iterator<Map<String, Object>> iterator = nodes.iterator();
      //System.out.println(nodes);
  	nodes.forEach(System.out::println);
  	writer1.write("JobName,Stage,ColumnName\n");
      while (iterator.hasNext()) {
      	String Str1=iterator.next().toString();
      	//System.out.println(Str1);
      	Str1=Str1.replaceAll("\\{|\\[|\\]|\\}|Job=|SourceStage=|Column Name=","");
      	System.out.println(Str1);
      	writer1.write(Str1);
      	writer1.write("\n");
  	}
      writer1.close();
  }
}
