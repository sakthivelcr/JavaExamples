//$Id$
package problems.DP;

import java.util.Scanner;
/*
 * O(n log n) solution based on
 * https://www.youtube.com/watch?v=S9oUiVYEq7E
 * http://stackoverflow.com/questions/2631726/how-to-determine-the-longest-increasing-subsequence-using-dynamic-programming
 * 
 * Input:11 3 4 -1 5 8 2 3 12 7 9 10
 * Output:6
 */
public class longestincreasingsubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int size=in.nextInt();
		int[] a=new int[size]; 
		for(int i=0;i<size;i++)
		{
			a[i]=in.nextInt();
		}
		lis(a);
	}
	
	public static void lis(int[] a)
	{
		int pos=0;
		int t[] =new int[a.length];
		t[0]=0;
		for(int i=1;i<a.length;i++)
		{
			int tmp=a[i];
			int index=t[pos];
			int valatindex=a[index];
			if(tmp>valatindex)
			{
				++pos;
				t[pos]=i;
			}
			else
			{
				//binary search on sorted array
				int start=0;
				int end=pos;
				while(start<=end)
				{
					int mid=(start+end)/2;
					if(a[t[mid]]==tmp)
					{
						t[mid]=i;
						break;
					}
					if(a[t[mid]] < tmp)
					{
						start=mid+1;
					}
					else
					{
						end=mid-1;
					}
				}
				//if the value is not found then start is the smallest element which is greater than tmp
				if(end<start)
				{
					t[start]=i;
				}
			}
		}
		System.out.println("length "+(pos+1));
		for(int i=0;i<=pos;i++)
		{
			System.out.print(a[t[i]]+" ");
		}
			
	}
}
