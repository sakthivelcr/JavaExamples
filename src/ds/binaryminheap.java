//$Id$
package ds;

import java.util.HashMap;

public class binaryminheap {
	 Node arr[];
	 HashMap<String,Integer> hm=new HashMap<String,Integer>();
	 int last;
	 class Node
	{
		String key;
		int weight;
	}
	
	public binaryminheap()
	{
		arr=new Node[10];
		last=-1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binaryminheap obj=new binaryminheap();
		obj.test(obj);
	}
	
	public void test(binaryminheap obj)
	{
		//obj.initialise();
		obj.insert("C",12);
		System.out.println(hm.toString());
		obj.insert("A",6);
		System.out.println(hm.toString());
		obj.insert("B",7);
		System.out.println(hm.toString());
		obj.insert("E",15);
		System.out.println(hm.toString());
		obj.insert("F",17);
		System.out.println(hm.toString());
		obj.insert("D",10);
		System.out.println(hm.toString());
		obj.change("E",5);
		System.out.println(hm.toString());
		//obj.insert("A",6);
		for(int i=0;i<6;i++)
		{
			Node tmp=obj.deleteMin();
			System.out.println("min "+tmp.weight);
			for(int j=0;j<last;j++)
			{
				System.out.print(arr[j].weight+" ");
			}
			System.out.println(hm.toString());
		}
		System.out.println(obj.deleteMin());
	}
	
	public void change(String key,int weight)
	{
		int pos=hm.get(key);
		int oldvalue=arr[pos].weight;
		arr[pos].weight=weight;
		if(weight<oldvalue)
		{
			trickleUp(pos);
		}
		if(weight>oldvalue)
		{
			trickleDown(pos);
		}
	}
	
	public void insert(String key,int weight)
	{
		Node node=new Node();
		node.key=key;
		node.weight=weight;
		last=last+1;
		arr[last]=node;
		trickleUp(last);
		
	}
	
	public void trickleUp(int pos)
	{
		Node node=arr[pos];
		int parent=(pos-1)/2;
		int current=pos;
		while(current>0 && arr[parent].weight>node.weight)
		{
			hm.put(arr[parent].key,current);
			arr[current]=arr[parent];
			current=parent;
			parent=(parent-1)/2;
		}
		arr[current]=node;
		hm.put(node.key,current);
	}
	
	public Node deleteMin()
	{
		if(last<0)
		{
			return null;
		}
		Node result=arr[0];
		hm.remove(result.key);
		arr[0]=arr[last];
		Node ins=arr[last];
		arr[last]=null;
		--last;
		if(last>0)
		{
			trickleDown(0);
		}
		else
		{
			hm.put(ins.key,0);
		}
		return result;
	}
	
	public void trickleDown(int current)
	{
		Node ins=arr[current];
		int lchild=(current*2)+1;
		int rchild=(current*2)+2;
		//other way loop check see the ds and algo book-check whether the current node has any child
		while(arr[lchild]!=null || arr[rchild]!=null)
		{
			int smallerchild=0;
			if(arr[lchild]==null)
			{
				smallerchild=rchild;
			}
			if(arr[rchild]==null)
			{
				smallerchild=lchild;
			}
			if(arr[lchild]!=null && arr[rchild]!=null)
			{
			if(arr[lchild].weight<arr[rchild].weight)
			{
				smallerchild=lchild;
			}
			else
			{
				smallerchild=rchild;
			}
			}
			if(ins.weight>arr[smallerchild].weight)
			{
				hm.put(arr[smallerchild].key,current);
				arr[current]=arr[smallerchild];
				current=smallerchild;
			}
			else
			{
				break;
			}	
			lchild=(current*2)+1;
			rchild=(current*2)+2;
		}
		//if(current!=0)//root deletion with no child handling
		{
		arr[current]=ins;
		hm.put(ins.key,current);
		}
	}

}
