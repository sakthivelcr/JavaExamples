//$Id$
package problems;

import java.util.ArrayList;
import java.util.Scanner;

public class jumpingonclouds {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
        	a[i]=in.nextInt();
        }
        int count=0;
        for(int i=0;i<n-1;)
        {
        	if(a[i+1]==0)
        	{
        		if(i+2<n && a[i+2]==0)
        		{
        			i=i+2;
        			++count;
        			continue;
        		}
        		else
        		{
        			++i;
        			++count;
        			continue;
        		}
        	}
        	i=i+2;
        	++count;
        }
        System.out.println(count);
	}
}
