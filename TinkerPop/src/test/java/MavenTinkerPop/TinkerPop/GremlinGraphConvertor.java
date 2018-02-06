package MavenTinkerPop.TinkerPop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__;
import org.apache.tinkerpop.gremlin.process.traversal.Path;
import org.apache.tinkerpop.gremlin.process.traversal.*;
import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.io.IoCore;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class GremlinGraphConvertor {
	


	    public static void main(String[] args) throws IOException {
	    	
	    	final Graph newGraph = TinkerGraph.open();
	    	try {
				newGraph.io(IoCore.graphml()).readGraph("C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_FILE_TO_TBL.graphml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_FILE_TO_TBL_Detail.csv"));
	    	writer1.write("Source Vertex ID,Target Vertex ID,Source Vertex Name,Source Vertex Type,Target Vertex Name,Target Vertex Type,Edge\n");
	    	GraphTraversalSource n = newGraph.traversal();

	        String csvFile = "C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_FILE_TO_TBL.txt";
	        String line = "";
	        String cvsSplitBy = ",";

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	            	
	                String[] vertices = line.split(cvsSplitBy);
	                String SourceVer=vertices[0].trim();
	                String TargetVer=vertices[2].trim();
	                String Edge=vertices[1].trim();
	                String Output=SourceVer+","+TargetVer+","+n.V(SourceVer).has("name").values("name","type").toList().toString().replaceAll("\\[|\\]", "")+","+n.V(TargetVer).has("name").values("name","type").toList().toString().replaceAll("\\[|\\]", "")+","+Edge;
	                //System.out.println(n.V(vertices).has("category").outE().inV().path().by("name").by("text").by("name").by("type").toList());
	                //System.out.println("Source= " + vertices[0] + " , Target=" + vertices[2]);
	                //System.out.println(SourceVer+","+TargetVer+","+n.V(SourceVer).has("name").values("name","type").toList().toString().replaceAll("\\[|\\]", "")+","+n.V(TargetVer).has("name").values("name","type").toList().toString().replaceAll("\\[|\\]", "")+","+Edge);
	                System.out.println(Output);
	                writer1.write(Output+"\n");
	                //System.out.println(n.V(Str).has("name").values("name").toList());
	                //+ "->" + n.V(vertices[2]).has("name").values("name").toList());

	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        writer1.close();

	    }

	}

