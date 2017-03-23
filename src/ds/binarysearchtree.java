package ds;

import java.util.Scanner;

public class binarysearchtree {
	
	 Node root;
	 class Node
	 {
	 	public int value;
	 	public Node left;
	 	public Node right;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binarysearchtree obj=new binarysearchtree();
		Scanner in=new Scanner(System.in);
		while(true)
		{
			System.out.println("0.Exit 1.Insert 2.Find 3.Delete 4.FindDepth 5.LCA 6.Inorder");
			switch(in.nextInt())
			{
			case 1: System.out.println("Enter the number to Insert");
					obj.insertNode(in.nextInt());
					break;
			case 0:System.exit(0);
			case 2:System.out.println("Enter the number to search");
				   if(obj.find(in.nextInt()))
				   {
					   System.out.println("Found"); 
				   }
				   else
				   {
					   System.out.println("Not Found");
				   }
				   break;
			case 3:System.out.println("Enter node to delete");
				   if(obj.deleteNode(in.nextInt()))
				   {
					   System.out.println("Deleted"); 
				   }
				   else
				   {
					   System.out.println("Node not Found"); 
				   }
				   break;
			case 4:System.out.println("Enter node whose depth to be found");
				   System.out.println("Depth "+obj.depth(in.nextInt()));
				   break;
			case 5:System.out.println("Enter two values for LCA");
				  System.out.println("LCA "+obj.LCA(in.nextInt(),in.nextInt()));
				   break; 
			case 6:obj.traversal();
				   break;
					
			}
		}
	}
	
	public void traversal()
	{
		inorder(root);
	}
	
	public void inorder(Node root)
	{
		if(root==null)
		{
			return;
		}
		inorder(root.left);
		System.out.print(root.value+" ");
		inorder(root.right);
	}
	public int LCA(int a,int b)
	{
		Node tmp=root;
		while(tmp!=null)
		{
			if((a<tmp.value&&b>tmp.value) ||(a>tmp.value&&b<tmp.value) )
			{
				return tmp.value;
			}
			if(a<tmp.value&&b<tmp.value)
			{
				tmp=tmp.left;
			}
			if(a>tmp.value&&b>tmp.value)
			{
				tmp=tmp.right;
			}
			if(tmp.value==a)
			{
				return a;
			}
			else if(tmp.value==b)
			{
				return b;
			}
		}
		return 0;
	}
	
	public int depth(int val)
	{
		Node current=root;
		int depth=0;
		if(root==null)
		{
			return -1;
		}
		else
		{
			while(current.value!=val && current!=null)
			{
				if(val<current.value)
				{
					current=current.left;
				}
				else
				{
					current=current.right;
				}
				++depth;
			}
			if(current!=null)
			{
			return depth;
			}
			else
			{
				return -1;
			}
		}
	}
	
	public boolean deleteNode(int val)
	{
		if(root==null)
		{
			return false;
		}
		Node current=root;
		Node parent=null;
		while(current.value!=val)
		{
			parent=current;
			if(val<current.value)
			{
				current=current.left;
			}
			else
			{
				current=current.right;
			}
			if(current==null)
			{
				return false;
			}
		}
		//No child
		if(current.left==null && current.right==null)
		{
			if(current==root)
			{
				root=null;
			}
			if(parent.left!=null && parent.left.value==val)
			{
				parent.left=null;
			}
			if(parent.right!=null && parent.right.value==val)
			{
				parent.right=null;
			}
			return true;
		}
		//one child
		if(current.right==null)
		{
			if(current==root)
			{
				root=current.left;
			}
			if(parent.left!=null && parent.left.value==val)
			{
				parent.left=current.left;
			}
			if(parent.right!=null && parent.right.value==val)
			{
				parent.right=current.left;
			}
			return true;
		}
		if(current.left==null)
		{
			if(current==root)
			{
				root=current.right;
			}
			if(parent.left!=null && parent.left.value==val)
			{
				parent.left=current.right;
			}
			if(parent.right!=null && parent.right.value==val)
			{
				parent.right=current.right;
			}
			return true;
		}
		//Two child
		Node successor=getSuccessor(current);
		if(current==root)
		{
			root=successor;
			successor.left=current.left;
		}
		//successor is in right and has no left child
		if(successor==current.right)
		{
			if(parent.left!=null && parent.left.value==val)
			{
				parent.left=successor;
			}
			if(parent.right!=null && parent.right.value==val)
			{
				parent.right=successor;
			}
			successor.left=current.left;
		}
		//successor is the left descendant of the right child of node to be deleted
		else
		{
			if(parent.left!=null && parent.left.value==val)
			{
				parent.left=successor;
			}
			if(parent.right!=null && parent.right.value==val)
			{
				parent.right=successor;
			}
			successor.left=current.left;
			successor.right=current.right;
		}
		return true;
	}
	
	public Node getSuccessor(Node current)
	{
		Node tmp=current.right;
		Node successor=tmp;
		Node successorParent=current;
		while(tmp!=null)
		{
			successorParent=successor;
			successor=tmp;
			tmp=tmp.left;
		}
		if(successor!=current.right)
		{
			successorParent.left=successor.right;
		}
		return successor;
	}
	
	
	public boolean find(int val)
	{
		Node tmp=root;
		if(tmp==null)
		{
			return false;
		}
		else
		{
		while(tmp.value!=val)
		{
			if(val<tmp.value)
			{
				tmp=tmp.left;
			}
			else
			{
				tmp=tmp.right;
			}
			if(tmp==null)
			{
				return false;
			}
		}
		return true;
		}
	}
	public  void insertNode(int value)
	{
		Node ins=new Node();
		ins.value=value;
		if(root==null)
		{
			root=ins;
		}
		else
		{
			Node current=root;
			Node parent;
			while(true)
			{
				if(value<current.value)
				{
					parent=current;
					current=current.left;
					if(current==null)
					{
						parent.left=ins;
						return;
					}
				}
				else
				{
					parent=current;
					current=current.right;
					if(current==null)
					{
						parent.right=ins;
						return;
					}
				}
			}
		}
	}
	
}

