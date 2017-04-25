//$Id$
package ds;

import java.util.HashMap;

import ds.binaryminheap.Node;

public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		weightedgraph graph=new weightedgraph();
		graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(3, 4, 3);
        Dijkstra obj=new Dijkstra();
        obj.findShortestPath(graph,String.valueOf(1));
	}
	
	public void findShortestPath(weightedgraph graph,String start)
	{
		HashMap<String,Integer> distanceMap=new HashMap<String,Integer>();
		HashMap<String,String> vertexVSParent=new HashMap<String,String>();
		binaryminheap heap=new binaryminheap();
        for(String vertex:graph.vertices)
        {
        	heap.insert(vertex,Integer.MAX_VALUE);
        }
        heap.change(start, 0);
        distanceMap.put(start,0);
       ds.binaryminheap.Node tmp=heap.deleteMin();
       vertexVSParent.put(tmp.key,null);
       while(tmp!=null)
       {
    	   distanceMap.put(tmp.key,tmp.weight);
    	   int pos=graph.getPos(tmp.key);
    	   for(edge edge:graph.adjList.get(pos))
    	   {
    		  int currweight= edge.weight+tmp.weight;
    		  if(heap.hm.containsKey(edge.key))
    		  {
    			 int edgepos=heap.hm.get(edge.key);
    			 if(currweight < heap.arr[edgepos].weight)
    			 {
    				 heap.change(edge.key, currweight);
    				 vertexVSParent.put(edge.key,tmp.key);
    			 }
    		  }
    	   }
    	   tmp=heap.deleteMin();
       }
       System.out.println(distanceMap.toString());
       System.out.println(vertexVSParent.toString());
	}

}
