//$Id$
package problems.DP;

import java.util.Scanner;
/*
 * O(n2) solution
 * Will time out on large inputs but the solution is correct
 * Based on the algorithm at https://www.youtube.com/watch?v=4fQJGoeW5VE
 * Example:{3,2,6,4,5,1}
 * L[0]=3
 * L[1]=2
 * L[2]=2,6
 * L[3]=2,4    
 * L[4]=2,4,5
 * L[5]=1
 * 
 * L[4] can be found by taking all the L[i] last element which is less than a[4] 
 * and then finding the longest among them and then adding a[4] to it
 */
public class longestIncreasingSubSequenceLength {

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
	/*
	 * LISsize is an array which stores the LIS size for each element in the input array
	 * maxtillnow indicates the longest LIS till that particular i
	 */
	public static void lis(int[] a)
	{
		int ans=0;
		int[] LISsize=new int[a.length];
		LISsize[0]=1;
		for(int i=1;i<a.length;i++)
		{
			int maxtillnow = 0;
			for(int j=0;j<i;j++)
			{
				/*We are just comparing the input array elements because the 
				 * last element of LIS at any point a[i] is the same as a[i]
				 */
				if(a[j]<a[i])
				{
					maxtillnow=Math.max(maxtillnow,LISsize[j]);
				}
			}
			LISsize[i]=maxtillnow+1;
			ans=Math.max(ans, LISsize[i]);
			//System.out.println(ans);
		}
		System.out.println(ans);
	}

}
