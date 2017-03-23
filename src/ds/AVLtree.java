//$Id$
package ds;

public class AVLtree {
	Node root;
	class Node
	{
		int ht;
		int value;
		Node left;
		Node right;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLtree obj=new AVLtree();
		obj.root=obj.insert(obj.root,3);
		obj.root=obj.insert(obj.root,2);
		obj.root=obj.insert(obj.root,4);
		obj.root=obj.insert(obj.root,5);
		obj.root=obj.insert(obj.root,6);
		//obj.root=obj.insert(obj.root,25);
		preorder(obj.root);

	}
	
	public static void preorder(Node root)
	{
		if(root==null)
		{
			return;
		}
		System.out.print(root.value+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public Node insert(Node node,int val)
	{
		if(node==null)
		{
			Node tmp=new Node();
			tmp.value=val;
			//if leaf node height is treated as 1 then height of null node should be zero
			//if leaf node height is treated as 0 then height of null node should be -1
			//the above contract should hold since when you calculate ht(left)-ht(right) you left out the height of the
			//node from node.left or node.right
			tmp.ht=setHeight(tmp);
			return tmp;
		}
		if(val<node.value)
		{
			node.left=insert(node.left,val);
		}
		else
		{
			node.right=insert(node.right,val);
		}
		node.ht=setHeight(node);
		int balance=getBalance(node);
		if(balance>1 && val<node.left.value)
		{
			return rightRotate(node);
		}
		if(balance>1 && val>node.left.value)
		{
			node.left=leftRotate(node.left);
			return rightRotate(node);
		}
		if(balance<-1 && val>node.right.value)
		{
			return leftRotate(node);
		}
		if(balance<-1 && val<node.right.value)
		{
			node.right=rightRotate(node.right);
			return leftRotate(node);
			//return node;
		}
		return node;
		
	}
	
	public Node rightRotate(Node y)
	{
		Node x=y.left;
		Node t2=x.right;
		
		y.left=t2;
		x.right=y;
		
		y.ht=setHeight(y);
		x.ht=setHeight(x);
		
		return x;
	}
	
	public Node leftRotate(Node y)
	{
		Node x=y.right;
		Node t2=x.left;
		
		y.right=t2;
		x.left=y;
		
		y.ht=setHeight(y);
		x.ht=setHeight(x);
		
		return x;
		
	}
	
	public int setHeight(Node node)
	{
		if(node ==null)
		{
			return -1;
		}
		return 1+Math.max(getHeight(node.left),getHeight(node.right));
	}
	
	public int getHeight(Node node)
	{
		if(node==null)
		{
			return -1;
		}
		else
		{
			return node.ht;
		}
		
	}
	
	public int getBalance(Node node)
	{
		return getHeight(node.left)-getHeight(node.right);
	}

}
