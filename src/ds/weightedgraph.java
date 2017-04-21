//$Id$
package ds;

import java.util.ArrayList;
import java.util.HashMap;

public class weightedgraph {

	binaryminheap obj;
	//in adjmap we are storing the postionofvertices as key and their adjlist as value
	HashMap<Integer,ArrayList<edge>> adjList=new HashMap<Integer,ArrayList<edge>>();
	ArrayList<String> vertices=new ArrayList<String>();
	public weightedgraph()
	{
		obj=new binaryminheap();
	}
	
	public void addEdge(int istart,int iend,int weight)
	{
		//obj.insert(String.valueOf(start),weight);
		String start=String.valueOf(istart);
		String end=String.valueOf(iend);
		if(!vertices.contains(start))
		{
			vertices.add(start);
		}
		if(!vertices.contains(end))
		{
			vertices.add(end);
		}
		edge tmp=new edge(start,weight);
		edge tmp2=new edge(end,weight);
		int startPos=getPos(start);
		int endPos=getPos(end);
		if(adjList.get(startPos)==null)
		{
			ArrayList<edge> tmpal=new ArrayList<edge>();
			tmpal.add(tmp2);
			adjList.put(startPos,tmpal);
		}
		else
		{
			adjList.get(startPos).add(tmp2);
		}
		if(adjList.get(endPos)==null)
		{
			ArrayList<edge> tmpal=new ArrayList<edge>();
			tmpal.add(tmp);
			adjList.put(endPos,tmpal);
		}
		else
		{
			adjList.get(endPos).add(tmp);
		}
	}
	
	public int getPos(String value)
	{
		for(int i=0;i<vertices.size();i++)
		{
			if(vertices.get(i).equals(value))
			{
			return i;
			}
		}
		return -1;
	}

}
class edge
{
	int weight;
	String key;
	public edge(String key,int weight)
	{
		this.weight=weight;
		this.key=key;
	}
}
