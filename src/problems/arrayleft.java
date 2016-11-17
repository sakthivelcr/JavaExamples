//$Id$
package problems;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation
 */

public class arrayleft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int a[] = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	        int rem=k%n;
	        for(int i=rem;i<n;i++)
	        {
	        	System.out.print(a[i]+" ");
	        }
	        for(int i=0;i<rem;i++)
	        {
	        	System.out.print(a[i]+" ");
	        }
	}
}
