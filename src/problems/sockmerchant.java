//$Id$
package problems;

import java.util.HashSet;
import java.util.Scanner;
/*
 * 
Print the total number of matching pairs of socks that John can sell.

Sample Input
9
10 20 20 10 10 30 50 10 20

Sample Output
3

 */
public class sockmerchant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int i=in.nextInt();
		int[] arr=new int[i];
		HashSet<Integer> hs=new HashSet<Integer>();
		int count=0;
		for(int k=0;k<i;++k)
		{
			arr[k]=in.nextInt();
			boolean b=hs.add(arr[k]);
			if(b==false)
			{
				hs.remove(arr[k]);
				++count;
			}
		}
		System.out.println(count);
	}
}
