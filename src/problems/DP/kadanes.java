//$Id$
package problems.DP;

import java.util.ArrayList;
import java.util.Scanner;

public class kadanes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int tc=in.nextInt();
		ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<tc;i++)
		{
			int size=in.nextInt();
			ArrayList<Integer> tmp=new ArrayList<Integer>(size);
			for(int j=0;j<size;j++)
			{
				tmp.add(in.nextInt());
			}
			al.add(tmp);
		}
		for(int j=0;j<al.size();j++)
		{
			ArrayList<Integer> altmp=al.get(j);
			int max=0;
			int currentsum=0;
			int negativecount=0;
			int negativemax=altmp.get(0);
			int tmpsize=altmp.size();
			for(int k=0;k<tmpsize;k++)
			{
				int tmp=altmp.get(k);
				currentsum=currentsum+tmp;
				if(currentsum <0)
				{
					negativemax=Math.max(negativemax,currentsum);
					currentsum=0;
					++negativecount;
				}
				else
				{
					max=Math.max(max,currentsum);
				}
			}
			if(negativecount==tmpsize)
			{
				System.out.println("maxsum: "+negativemax);
			}
			else
			{
				System.out.println("maxsum: "+max);
			}
		}
	}
}
