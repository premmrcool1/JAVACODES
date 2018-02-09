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

public class ColumtoColumnLineage {
	  public static void main(String args[]) throws IOException {
           
			BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_TBL1_to_TBL2_ColumntoColumn.csv"));
		  

	final Graph newGraph = TinkerGraph.open();
	try {
			newGraph.io(IoCore.graphml()).readGraph("C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_TBL1_to_TBL2.graphml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	GraphTraversalSource n = newGraph.traversal();
	List<Map<String,Object>> nodes= n.V().has("type","Transformation").as("Job").out().has("type","Transformation Step").as("SourceStage").out().has("type","Transformation Stream field").as("column").out().has("type","Transformation Stream field").as("columnout").valueMap("true","name").select("Job","SourceStage","column","columnout").by("name").by("name").by("name").by().toList() ;   	   	
	Iterator<Map<String, Object>> iterator = nodes.iterator();
	writer1.write("JobName,InputStage,InputColumnName,OutputStageName,OutputColumnName\n");
    while (iterator.hasNext()) {
    	String Str1=iterator.next().toString();
    	//System.out.println(Str1);
    	Str1=Str1.replaceAll("\\{|\\[|\\]|\\}|v\\[|Job=|SourceStage=|columnout=|column=","");
    	//System.out.println(Str1);
    	String[] vertices = Str1.split(",");
    	String Str2= n.V(vertices[3].trim()).has("type","Transformation Stream field").as("inColumn").in().has("type","Transformation Step").as("in stage").values("name").select("in stage","inColumn").by("name").toList().toString();
    	Str2=Str2.replaceAll("\\{|\\[|\\]|\\}|v\\[|in stage=|inColumn=","");
    	StringBuilder Str3 = (new StringBuilder()).append(vertices[0]).append(",").append(vertices[1]).append(",").append(vertices[2]).append(",").append(vertices[3]).append(",").append(Str2);
    	System.out.println(Str3.toString());
    	writer1.write(Str3.toString());
    	writer1.write("\n");
	}
    writer1.close();
}

}
