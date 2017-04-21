//$Id$
package ds;

import java.util.HashMap;


public class binaryminheap2 {
	static HashMap hm=new HashMap();
	static int[] arr=new int[10];
	static int last=-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binaryminheap2 obj=new binaryminheap2();
		obj.insert(12);
		System.out.println(hm.toString());
		obj.insert(6);
		System.out.println(hm.toString());
		obj.insert(7);
		System.out.println(hm.toString());
		obj.insert(15);
		System.out.println(hm.toString());
		obj.insert(17);
		System.out.println(hm.toString());
		obj.insert(10);
		System.out.println(hm.toString());
		for(int i=0;i<6;i++)
		{
			System.out.println("min "+obj.deleteMin());
			for(int j=0;j<=last;j++)
			{
				System.out.print(arr[j]+" ");
			}
			//System.out.println(hm.toString());
		}
	}
	
	public void insert(int value)
	{
		++last;
		arr[last]=value;
		int current=last;
		int parentPos=(current-1)/2;
		while(parentPos >=0 && arr[parentPos]>arr[current])
		{
			arr[current]=arr[parentPos];
			current=parentPos;
			parentPos=(current-1)/2;
		}
		arr[current]=value;
	}
	
	public int deleteMin()
	{
		int result=arr[0];
		if(last==0)
		{
			arr[0]=0;
			return result;
		}
		arr[0]=arr[last];
		int lastval=arr[last];
		arr[last]=0;
		--last;
		int current=0;
		int lchild=current*2+1;
		int rchild=current*2+2;
		int smallerchild=0;
		//other way loop check see the ds and algo book-check whether the current node has any child
		while(lchild<=last || rchild<=last)
		{
			if(arr[lchild]<arr[rchild] || rchild>last)
			//rchild>last this condition is to ensure that when we move past last all values will be 0 but it shouldn't become min
			{
				smallerchild=lchild;
			}
			else
			{
				smallerchild=rchild;
			}
			if(arr[current]>arr[smallerchild])
			{
			arr[current]=arr[smallerchild];
			current=smallerchild;
			}
			else
			{
				break;
			}
			lchild=current*2+1;
			rchild=current*2+2;
		}
		arr[current]=lastval;
		return result;
	}
}
