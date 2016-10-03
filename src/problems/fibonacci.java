//$Id$
package problems;

import java.util.Scanner;

public class fibonacci {
	static int fi[];
	public static void initialize(int size)
	{
		fi=new int[size];
		for(int i=0;i<size;i++)
		{
			fi[i]=-1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int num=in.nextInt();
		initialize(num+1);
		int fib[]=new int[num+1];
		fib[0]=0;
		fib[1]=1;
		for(int i=2;i<=num;i++)
		{
			fib[i]=fib[i-1]+fib[i-2];
		}
		System.out.println(fib[num]);
		System.out.println(rec(num));
		System.out.println(dp(num));
	}
	
	public static int rec(int n)
	{
		if(n==1)
		{
			return 1;
		}
		else if(n==0)
		{
			return 0;
		}
		else
		{
			return rec(n-1)+rec(n-2);
		}
	}
	public static int dp(int n)
	{
		if(fi[n]==-1)
		{
			if(n<=1)
			{
				fi[n]=n;
			}
			else
			{
				return dp(n-1)+dp(n-2);
			}
		}
		return fi[n];
	}
}
