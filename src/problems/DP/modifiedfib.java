//$Id$
package problems.DP;

import java.math.BigInteger;
import java.util.Scanner;

public class modifiedfib {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		BigInteger i1=in.nextBigInteger();
		BigInteger j=in.nextBigInteger();
		int n=in.nextInt();
		BigInteger[] lookup=new BigInteger[n];
		lookup[0]=i1;
		lookup[1]=j;
		for(int i=2;i<n;i++)
		{
			
			BigInteger k=lookup[i-1];
			lookup[i]=lookup[i-2].add(k.multiply(k));
		}
		System.out.println(lookup[n-1]);
	}

}
