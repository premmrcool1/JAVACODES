package MavenTinkerPop.TinkerPop;


import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

import java.io.BufferedWriter;
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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class AppTest {

    public static void main(String args[]) throws IOException {
    	//Configuration configuration = new BaseConfiguration();
    	//configuration.addProperty("gremlin.neo4j.directory", "C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_TBL1_to_TBL2_mod.graphml");
    	//Graph graph = GraphFactory.open(configuration);
        //GraphTraversalSource g = graph.traversal();

			BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_TBL1_to_TBL2.txt"));
		  
  
    	final Graph newGraph = TinkerGraph.open();
    	try {
			newGraph.io(IoCore.graphml()).readGraph("C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_TBL1_to_TBL2.graphml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	GraphTraversalSource n = newGraph.traversal();
    	//List<Path> nodes=n.V().has("category").outE().inV().path().by("name").by("text").by("name").by("type").toList();
    	List<Path> nodes=n.V().has("name").outE().inV().path().toList() ;   	
    	//List<Object> nodes=n.V().has("category").outE().inV().path().id().by("text").toList();
    	Iterator<Path> iterator = nodes.iterator();
    	//System.out.println(n.toString());
    	//System.out.println(n.V("bfb36455-7a02-4f33-bc3c-f29c265d15bc").in().out().iterate());
    	//System.out.println(n.V().has("category").out().
        //        order().by("category").values("category").toList());
    	//System.out.println(n.V().has("category").out().values("category").toList());
    	//System.out.println(n.V().has("category").id().toList());
    	//System.out.println(n.V().has("name").in().out().values("name").toList());
    	//System.out.println(n.E().has("name").out().values("name").toList());
    	//System.out.println(n.V().has("name").valueMap().toList());
    	//System.out.println(n.E().path().toList());
    	//writer1.write("Source ID,PATH,Target ID\n");
    	//System.out.println(n.V("00df6bd4-2af8-46fc-be72-b3a4eb879acc").has("type").outE().inV().path().toList());
        System.out.println(nodes);
        while (iterator.hasNext()) {
        	String Str1=iterator.next().toString();
        	//System.out.println(Str1);
        	Str1=Str1.replaceAll("\\[|v\\[|e\\[|\\]","");
        	System.out.println(Str1);
        	writer1.write(Str1);
        	writer1.write("\n");
    	}
        writer1.close();
    	//assertEquals(6, g.V().count().next().intValue());
        //assertEquals(6, g.E().count().next().intValue());
    }
}