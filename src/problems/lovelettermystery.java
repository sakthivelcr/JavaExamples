//$Id$
package problems;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * https://www.hackerrank.com/challenges/the-love-letter-mystery
 */
public class lovelettermystery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int input=in.nextInt();
		ArrayList<String> al=new ArrayList<String>();
		for(int i=0;i<input;i++)
		{
			al.add(in.next());
		}
		for(String s:al)
		{
			int ans=0;
			StringBuilder sb=new StringBuilder(s);
			sb.reverse();
			if(s.equals(sb.toString()))
			{
				System.out.println("0");
				continue;
			}
			int j=s.length()-1;
			int i=0;
			char c[]=s.toCharArray();
			while(i<j)
			{
				if(s.charAt(i)==s.charAt(j))
				{
				}
				else
				{
					if(c[i]>c[j])
					{
						int tmp=c[i]-c[j];
						ans=ans+tmp;
					}
					else
					{
						int tmp=c[j]-c[i];
						ans=ans+tmp;
					}
				}
				++i;--j;
			}
			System.out.println(ans);
		}
	}

}
