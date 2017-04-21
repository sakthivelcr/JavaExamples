//$Id$
package ds;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/*
 * 4 edges-10,30,15,4
 * 6 edges
 * 15->10,10->15,10->30,30->15,15->4,4->4,
 * 
 */
public class graph {
	static int[] vertices;
	static ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>();
	static boolean visited[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number of vertices");
		Scanner in=new Scanner(System.in);
		int size=in.nextInt();
	     vertices=new int[size];
	     visited=new boolean[size];
		for(int i=0;i<size;i++)
		{
			al.add(new ArrayList<Integer>());
		}
		System.out.println("Enter the name of vertices(numbers)");
		for(int i=0;i<size;i++)
		{
			vertices[i]=in.nextInt();
		}
		System.out.println("Enter the number of edges");
		int edges=in.nextInt();
		for(int i=0;i<edges;i++)
		{
			System.out.println("Enter start node");
			int start=in.nextInt();
			int rstart=getPos(start);
			System.out.println("Enter end node");
			ArrayList tmp=al.get(rstart);
			tmp.add(in.nextInt());
		}
		graph obj=new graph();
	/*	while(true){
		System.out.println("Enter the starting node");
		obj.DFS(in.nextInt());
		visited=new boolean[size];
		}
		/*while(true)
		{
			System.out.println("Enter the starting node");
			//obj.findPath(in.nextInt());
		}*/
		obj.topologicalSort();
	}
	
	public void topologicalSort()
	{
		Stack<Integer> st=new Stack<Integer>();
		for(int i=0;i<vertices.length;i++)
		{
			if(visited[i]==false)
			{
				tsort(vertices[i],st);
			}
		}
		while(!st.isEmpty())
		{
			System.out.print(st.pop()+" ");
		}
	}
	
	public void tsort(int val,Stack st)
	{
		visited[getPos(val)]=true;
		for(Integer i:al.get(getPos(val)))
		{
			if(visited[getPos(i)]==false)
			{
				tsort(i,st);
			}
		}
		st.push(val);
	}
	
	public void DFS(int val)
	{
		int realpos=getPos(val);
		visited[realpos]=true;
		System.out.println(val);
		for(Integer i:al.get(realpos))
		{
			if(visited[getPos(i)]!=true)
			{
				DFS(i);
			}
		}
	}
	
	
	public static int getPos(int val)
	{
		for(int i=0;i<vertices.length;i++)
		{
			if(vertices[i]==val)
			{
				return i;
			}
		}
		return -1;
	}
}
