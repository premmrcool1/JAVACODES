package MavenTinkerPop.TinkerPop;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__;
import org.apache.tinkerpop.gremlin.process.traversal.Path;
import org.apache.tinkerpop.gremlin.process.traversal.*;
import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.io.IoCore;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class sampleGraph {

	public static void main(String[] args)
	  {
	    TinkerGraph tg = TinkerGraph.open() ;
	    List<Map<Object,Object>> vm = new ArrayList<Map<Object,Object>>() ;

	    try
	    {
	      tg.io(IoCore.graphml()).readGraph("C:\\Users\\Premkumar.Nagarajan\\Desktop\\HKEX\\ETL_TBL1_to_TBL2.graphml");
	    }
	    catch( IOException e )
	    {
	      System.out.println("File not found");
	      System.exit(1);
	    }
	    GraphTraversalSource g = tg.traversal();
	    Map<String,?> aus = (Map<String, ?>) g.V().has("category","field").valueMap("true","type","name");
	   // vm = g.V().valueMap(true).toList();
	    System.out.println(aus);
	    //System.out.println(vm);
	  }

}
