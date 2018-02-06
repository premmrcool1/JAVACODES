package org.prem.InheritancePack;

import java.util.Iterator;
import java.util.LinkedList;

import org.prem.InheritancePack.GFG.Graph;

public class GraphEx {

	 LinkedList<Integer> arr[];
	 void init(int len)
	 {
		 arr =  new LinkedList[len];
		 for(int i = 0; i < len ; i++){
	            arr[i] = new LinkedList<>();
	        } 
	 }
	void addEdge(int src,int dest)
	{
		arr[src].addFirst(dest);
		System.out.println("Edge1 Added");
		
	}
	 void printGraph(int len)
	    {       
	        for(int v = 0; v < len; v++)
	        {
	            System.out.println("Adjacency list of vertex "+ v);
	            System.out.print("head");
	            for(Integer pCrawl: arr[v]){
	                System.out.print(pCrawl);
	            }
	            System.out.println("\n");
	        }
	    }
	 void BFS(int s)
	    {
	        // Mark all the vertices as not visited(By default
	        // set as false)
	        boolean visited[] = new boolean[5];
	 
	        // Create a queue for BFS
	        LinkedList<Integer> queue = new LinkedList<Integer>();
	 
	        // Mark the current node as visited and enqueue it
	        visited[s]=true;
	        queue.add(s);
	 
	        while (queue.size() != 0)
	        {
	            // Dequeue a vertex from queue and print it
	            s = queue.poll();
	            System.out.print(s+"queue "+queue.size()+"\n");
	 
	            // Get all adjacent vertices of the dequeued vertex s
	            // If a adjacent has not been visited, then mark it
	            // visited and enqueue it
	            Iterator<Integer> i = arr[s].listIterator();
	            while (i.hasNext())
	            {
	                int n = i.next();
	                System.out.println(n+"in");
	                if (!visited[n])
	                {
	                    visited[n] = true;
	                    System.out.println("i am in");
	                    queue.add(n);
	                }
	            }
	        }
	    }
	public static void main(String args[])
	{
		GraphEx G=new GraphEx();
		G.init(5);
		G.addEdge(0,1);
		G.addEdge(0,2);
		//G.init(5);
		//G.addEdge(0,2);
		G.addEdge(1, 3);
		G.addEdge(1, 4);
		//G.printGraph(5);
		G.BFS(0);
	}
}
