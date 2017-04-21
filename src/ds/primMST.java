//$Id$
package ds;

import java.util.ArrayList;
import java.util.HashMap;

public class primMST {
	
	static HashMap<String,String> ve=new HashMap<String,String>();
	//binaryminheap2 heap=new binaryminheap2();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		weightedgraph graph=new weightedgraph();
		 graph.addEdge(1, 2, 3);
	     graph.addEdge(2, 3, 1);
	        graph.addEdge(3, 1, 1);
	        graph.addEdge(1, 4, 1);
	        graph.addEdge(2, 4, 3);
	        graph.addEdge(4, 5, 6);
	        graph.addEdge(5, 6, 2);
	        graph.addEdge(3, 5, 5);
	        graph.addEdge(3, 6, 4);
	        for(String i:graph.vertices)
	        {
	        	graph.obj.insert(i,Integer.MAX_VALUE);
	        }
	        System.out.println(graph.obj.hm.keySet());
	        primMST obj=new primMST();
	        obj.findMST(1,graph);       
	}
	
	public void findMST(int value,weightedgraph graph)
	{
		binaryminheap obj=graph.obj;
		//System.out.println(graph.obj.hm.keySet());
		obj.change(String.valueOf(value),0);
		//System.out.println(graph.obj.hm.keySet());
		binaryminheap.Node node=obj.deleteMin();
		//System.out.println(graph.obj.hm.keySet());
		while(node!=null)
		{
			ArrayList<edge> adjList=graph.adjList.get(graph.getPos(node.key));
			for(edge eobj:adjList)
			{
				//System.out.println("loo"+obj.hm.toString()+" ---"+eobj.key);
				if(obj.hm.containsKey(eobj.key))
				{
					int pos=obj.hm.get(eobj.key);
					binaryminheap.Node nobj=obj.arr[pos];
					if(nobj.weight>eobj.weight)
					{
						obj.change(nobj.key, eobj.weight);
						ve.put(eobj.key,node.key+String.valueOf(eobj.key));
						System.out.println(ve.toString()+" ---"+eobj.key);
					}
				}
			}
			if(ve.get(node.key)!=null)
			{
				System.out.println(ve.get(node.key)+" ");
			}
			node=obj.deleteMin();
		}
	}

}
