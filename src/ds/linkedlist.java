//$Id$
package ds;

import java.util.Scanner;

public class linkedlist {
	 node startnode;
	 node endnode;
	 int length=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedlist obj=new linkedlist();
		while(true)
		{
			System.out.println("\n1.Insert\n2.Insert at pos\n3.Delete from position\n4.Display\n5.Exit\n6.Insert at begining\n7.Delete at begining\n8.Search");
			Scanner in=new Scanner(System.in);
			int op=in.nextInt();
			switch(op)
			{
				case 1:
					obj.insertatend(in.nextInt());
					break;
				case 2:obj.insertatpos(in.nextInt(),in.nextInt());
					break;
				case 3:obj.delete(in.nextInt());
					break;
				case 4:obj.display();
					break;
				case 5:
					System.exit(0);
				case 6:
					obj.insertatbegin(in.nextInt());
					break;
				case 7:
					obj.deleteatbegin();
					break;
				case 8:
					obj.search(in.nextInt());
					break;
				default:
			}
			
		}
	}
	
	public void insertatbegin(int i)
	{
		node node=new node(i,null,startnode);
		startnode=node;
	}
	
	public void insertatpos(int pos,int value)
	{
		if(pos>length || pos<1)
		{
			System.out.println("out of range");
		}
		else
		{
		int i=1;
		node node=startnode;
		while(i<pos-1)
		{
			++i;
			node=node.next;
		}
		node newnode=new node(value,null,node.next);
		node.next=newnode;
		}
	}
	
	public  void insertatend(int i)
	{
		node node=new node(i,null,null);
		if(startnode==null)
		{
			startnode=node;
			endnode=node;
			++length;
			return;
		}
		endnode.next=node;
		endnode=node;
		++length;
	}
	
	public  void display()
	{
		if(startnode!=null)
		{
			node node=startnode;
			while(node!=null)
			{
				System.out.print(node.i+" ");
				node=node.next;
			}
		}
		else
		{
			System.out.println("empty");
		}
		
	}
	
	public void delete(int pos)
	{
		if(pos>length || pos<1)
		{
			System.out.println("nothing to delete");
		}
		else
		{
			int i=1;
			node node=startnode;
			while(i<pos-1)
			{
				++i;
				node=node.next;
			}
			node tmpnode=node.next;
			node.next=tmpnode.next;
			if(pos==length)
			{
				endnode=node;
			}
		}
		
	}
	
	public void search(int value)
	{
		int i=1;
		boolean b=false;
		node node=startnode;
		while(node!=null)
		{
			if(node.i==value)
			{
				System.out.println("value found at pos "+i);
				b=true;
				break;
			}
			++i;
			node=node.next;
		}
		if(!b)
		{
			System.out.println("value not found");
		}
	}
	
	public void deleteatbegin()
	{
		node tmpnode=startnode.next;
		startnode.next=null;
		startnode=tmpnode;
	}

}
class node
{
	int i;
	node prev;
	node next;
	public node(int i,node prev,node next)
	{
		this.i=i;
		this.prev=prev;
		this.next=next;
	}
	public node() {
		// TODO Auto-generated constructor stub
	}
}