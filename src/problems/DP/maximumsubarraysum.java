//$Id$
package problems.DP;

import java.util.ArrayList;
import java.util.Scanner;
/*
 he Maximum Subarray
Given an array A of N elements, find the maximum possible sum of a

 1. Contiguous subarray
 2. Non-contiguous (not necessarily contiguous) subarray.
Empty subarrays/subsequences should not be considered.

Input Format

First line of the input has an integer T. T cases follow. Each test case begins with an integer N. In the next line, N integers follow representing the elements of array A.

Constraints:

    1 <= T <= 10
    1 <= N <= 10^5
    -10^4 <= a_i <= 10^4
The subarray and subsequences you consider should have at least one element.
Output Format

Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. At least one integer should be selected and put into the subarrays (this may be required in cases where all elements are negative).

Sample Input

2 
4 
1 2 3 4
6
2 -1 2 3 4 -5
Sample Output

10 10
10 11
 
Solution
					contiguous     		non-contiguous
positive			addallpositivenos	addallpositivenos
positive+negative	kadanes				addallpositivenos
negative			Math.max -1			Math.max -1
 
 
 
 */



public class maximumsubarraysum {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in=new Scanner(System.in);
			int tc=in.nextInt();
			ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>();
			ArrayList<Boolean> al2=new ArrayList<Boolean>();
			for(int i=0;i<tc;i++)
			{
				int size=in.nextInt();
				ArrayList<Integer> tmp=new ArrayList<Integer>(size);
				boolean b=false;
				for(int j=0;j<size;j++)
				{
					int tmp1=in.nextInt();
					tmp.add(tmp1);
					if(tmp1>>31!=0)
					{
						b=true;
					}
				}
				if(b)
				{
					al2.add(Boolean.FALSE);
				}
				else
				{
					al2.add(Boolean.TRUE);
				}
				al.add(tmp);
			}
			for(int i=0;i<tc;i++)
			{
				ArrayList<Integer> a=al.get(i);
				Boolean b=al2.get(i);
				long max=a.get(0);
				long count=0;
				if(b)//all positive
				{
					for(int j=0;j<a.size();j++)
					{
						count=count+a.get(j);
					}
					System.out.println(count+" "+count);
				}
				else
				{
					boolean bb=false;
					int maxhere=0;
				for(int j=0;j<a.size();j++)
				{
					int no=a.get(j);
					if(no>>31==0)
					{
						count=count+no;
						bb=true;
					}
					//kadanes algorithm
					maxhere=maxhere+a.get(j);
					if(maxhere<0)
					{
						maxhere=0;
					}
					else
					{
					max=Math.max(max,maxhere);
					}
				}
				if(!bb)//all negative
				{
					int tmp=a.get(0);
					for(int j=0;j<a.size();j++)
					{
						tmp=Math.max(a.get(j),tmp);
					}
					System.out.println(tmp+" "+tmp);
				}
				else//both negative and positive
				{
				System.out.println(max+" "+count);
				}
				}
			}
	}
}
