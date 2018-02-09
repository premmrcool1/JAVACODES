package MavenTinkerPop.TinkerPop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.io.IoCore;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

public class ColumnExtract {
	  public static void main(String args[]) throws IOException {

			BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_TBL1_to_TBL2.csv"));
		  

  	final Graph newGraph = TinkerGraph.open();
  	try {
			newGraph.io(IoCore.graphml()).readGraph("C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_TBL1_to_TBL2.graphml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	
  	GraphTraversalSource n = newGraph.traversal();
  	List<Map<String,java.lang.Object>> nodes= n.V().has("type","Transformation").as("Job").out().has("type","Transformation Step").as("SourceStage").out().has("type","Transformation Stream field").as("Column Name").values("name").select("Job","SourceStage","Column Name").by("name").toList() ;   	
  	List<Map<String,java.lang.Object>> vertices= n.V().has("type","Transformation").as("Job").out().has("type","Transformation Step").as("SourceStage").out().has("type","Transformation Stream field").as("Column Name").values("name").select("Job","SourceStage","Column Name").by().toList() ; 
  	//List<Map<String,Object>> nodes= n.V().has("type","Transformation").as("Job").out().has("type","Transformation Step").as("SourceStage").select("Job","SourceStage").by("name").toList() ;   	
  	Iterator<Map<String, java.lang.Object>> iterator = nodes.iterator();
  	Iterator<Map<String, java.lang.Object>> iterator1 = vertices.iterator();
     System.out.println(nodes);
    // IntStream.range(0, Math.min(nodes.size(), vertices.size())).map(i -> nodes.get(i)+","+vertices.get(i)).collect(Collectors.toCollection(ArrayList<Map<String,java.lang.Object>>::new));
     /*
     List<Object> objList = new ArrayList<Object>();
     for(Map<String, java.lang.Object> node : nodes){
    	 Object object = new Object();
    	 for(String key : node.keySet()){
    		 System.out.println("KEY="+key+" VALUE="+node.get(key));
    		 object.setName("X");
    		 object.se
    	 }
    	 objList.add(obj);
    	 
     }
     */
  	//nodes.forEach(System.out::println);
  	writer1.write("JobName,Stage,ColumnName,JobVertexId,StageVertexId,ColumnName,VertexId\n");
      while (iterator.hasNext() && iterator1.hasNext()) {
      	String Str1=iterator.next().toString();
      	String Str2=iterator1.next().toString();
      	//System.out.println(Str1);
      	Str1=Str1.replaceAll("\\{|\\[|\\]|\\}|Job=|SourceStage=|Column Name=","");
      	Str2=Str2.replaceAll("\\{|\\[|\\]|\\}|Job=|SourceStage=|Column Name=|v\\[","");
      	Str1=Str1.concat(",").concat(Str2);
      	System.out.println(Str1);
      	writer1.write(Str1);
      	writer1.write("\n");
  	}
      writer1.close();
  }
}
