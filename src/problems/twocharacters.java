//$Id$
package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/two-characters
*/
public class twocharacters {

	public static void main(String[] ar)
	{
		version1();
		version2();
	}
	
	public static void version1()
	{
		Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String s = in.next();
        int max=0;
        char c[]=s.toCharArray();
        HashSet<Character> hs=new HashSet<Character>();
        for(char tmp:c)
        {
        	hs.add(tmp);
        }
        int len=hs.size();
        ArrayList<Character> all=new ArrayList(hs);
        for(int i=0;i<len-1;i++)
        {
        	for(int j=i+1;j<len;j++)
        	{
        		ArrayList<Character> al=(ArrayList<Character>) all.clone();
        		al.remove(all.get(i));
        		al.remove(all.get(j));
        		String tmp=s.toString();
        		for(int k=0;k<al.size();k++)
        		{
        			tmp=tmp.replace(al.get(k).toString(),"");
        		}
        		char c1[]=tmp.toCharArray();
        		boolean b=false;
        		for(int i1=0;i1<c1.length-1;i1++)
        		{
        			if(c1[i1]==c1[i1+1])
        			{
        				b=true;
        				break;
        			}
        		}
        		if(!b)
        		{
        			max=Math.max(max,c1.length);
        		}
        	}
        }
        System.out.println(max);
	}
	
	public static void version2()
	{
	
	}
	
}
