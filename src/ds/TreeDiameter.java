package ds;

import java.util.ArrayList;


public class TreeDiameter {
	class Node
	{
		public int value;
		public Node left;
		public Node right;
		
		Node()
		{
			
		}
		Node(int i)
		{
			this.value=i;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeDiameter outerobj=new TreeDiameter();
		Node node=outerobj.new Node(1);
		node.left =outerobj.new Node(2);
		node.right = outerobj.new Node(3);
		node.left.left = outerobj.new Node(4);
		node.left.right = outerobj.new Node(5);
		node.left.right.left = outerobj.new Node(6);
		node.left.right.left.right = outerobj.new Node(7);
		node.left.left.left = outerobj.new Node(8);
		System.out.println(findDiameter(node));
		System.out.println(findDiameter2(node).get(1));
		
	}
	
	public static int findDiameter(Node node)
	{
		if(node==null)
		{
			return 0;
		}
		return Math.max(1+getHeight(node.left)+getHeight(node.right),Math.max(findDiameter(node.left),findDiameter(node.right)));
	}
	
	
	public static int getHeight(Node node)
	{
		if(node==null)
		{
			return 0;
		}
		return 1+Math.max(getHeight(node.left),getHeight(node.right));
	}

	public static ArrayList<Integer> findDiameter2(Node node)
	{
		if(node==null)
		{
			return new ArrayList<Integer>(){{add(0);add(0);}};
		}
		ArrayList<Integer> left=findDiameter2(node.left);
		ArrayList<Integer> right=findDiameter2(node.right);
		int lsubtreeht=left.get(0);
		int lsubtreedia=left.get(1);
		int rsubtreeht=right.get(0);
		int rsubtreedia=right.get(1);
		int newdia=Math.max(1+lsubtreeht+rsubtreeht,Math.max(lsubtreedia, rsubtreedia));
		int newht=1+Math.max(lsubtreeht, rsubtreeht);
		return new ArrayList<Integer>(){{add(newht);add(newdia);}};
	}

}


