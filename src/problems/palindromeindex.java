//$Id$
package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/palindrome-index
 */
public class palindromeindex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * This solution is O(n)
		 * There are two kinds of strings you will get in this problem.
1) One that is already palindrome.
2) One that is not palindrome, and will require you to remove one and only one character to make it palindrome.
We'll use the same method we use to check if a string is palindrome or not (i.e., check the first with the last character, check 2nd with 2nd last character, and so on).
 Except here, we note where we get an inequal condition.
 And after that we check if removing either of the two makes palindrome or not.
-
To understand, consider the following example.
aabcdcba
Clearly we need to remove the second 'a' to make it palindrome. But how will you make a program know that?
-
Lets now follow the method we described. First we check the first character with the last.
 Since both are a's, we move on. Second character 'a' and 2nd last 'b' dont match, so the string is not palindrome.
  Since removing only one character makes the string palindrome(as given in question), the character to be removed is one of these two characters.
 This is guaranteed to work for all strings, due to the constraints given in the question.
  Now you can remove the characters individually to check if string becomes palindrome, or simply observe that the characters after 'a' match with the corresponding characters starting back from 'b' on the other side, i.e.,
bcdcb
is palindrome. Both ways yield the same result.
-
If you don't get an inequality condition, the string is palindrome then. This problem is hence solved in linear time.
		 */
		Scanner in = new Scanner(System.in);
		int input=in.nextInt();
		ArrayList<String> al=new ArrayList<String>();
		for(int i=0;i<input;i++)
		{
			al.add(in.next());
		}
		for(String s:al)
		{
			boolean b=false;int ans=0;
			StringBuilder sb=new StringBuilder(s);
			sb.reverse();
			if(s.equals(sb.toString()))
			{
				System.out.println("-1");
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
					if(check(i,c))
					{
						b=true;
						ans=i;
						break;
					}
					if(check(j,c))
					{
						b=true;
						ans=j;
						break;
					}
				}
				++i;
				--j;
			}
			if(b)
			{
				System.out.println(ans);
			}
			else
			{
				System.out.println("-1");
			}
		}

	}
	
	public static boolean check(int val,char c[])
	{
		String left="",right="",finall="";
		if(val>0)
		{
			int llength=val;
			char l[]=new char[llength];
			System.arraycopy(c,0,l,0,llength);
			left=String.valueOf(l);
		}
		//right
		if(val!=c.length-1)
		{
			int rlength=c.length-(val+1);
			char r[]=new char[rlength];
			System.arraycopy(c,val+1,r,0,rlength);
			right=String.valueOf(r);
		}
		finall=left+right;
		StringBuilder sb1=new StringBuilder(finall);
		sb1.reverse();
		if(finall.equals(sb1.toString()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//time-out optimized still time out
	public void version2()
	{
		Scanner in = new Scanner(System.in);
		int input=in.nextInt();
		ArrayList<String> al=new ArrayList<String>();
		for(int i=0;i<input;i++)
		{
			al.add(in.next());
		}
		for(String s:al)
		{
			boolean b=false;int ans=0;
			StringBuilder sb=new StringBuilder(s);
			sb.reverse();
			if(s.equals(sb.toString()))
			{
				System.out.println("-1");
				continue;
			}
			StringBuilder sbl=new StringBuilder();
			StringBuilder sbr=new StringBuilder(s);
			int len=s.length();
			for(int i=0;i<len;i++)
			{
				String left="",right="",finall="";
				if(i>0)
				{
				left=sbl.append(s.charAt(i-1)).toString();
				}
				right=sbr.deleteCharAt(0).toString();
				finall=left+right;
				StringBuilder sb1=new StringBuilder(finall);
				sb1.reverse();
				if(finall.equals(sb1.toString()))
				{
					b=true;
					ans=i;
					//System.out.println(c[i]+" "+c[i+1]);
					break;
				}
			}
			if(b)
			{
				System.out.println(ans);
			}
			else
			{
				System.out.println("-1");
			}
		}
	}
	//time-out
	public void version1()
	{
		Scanner in = new Scanner(System.in);
		int input=in.nextInt();
		ArrayList<String> al=new ArrayList<String>();
		for(int i=0;i<input;i++)
		{
			al.add(in.next());
		}
		for(String s:al)
		{
			boolean b=false;int ans=0;
			StringBuilder sb=new StringBuilder(s);
			sb.reverse();
			if(s.equals(sb.toString()))
			{
				System.out.println("-1");
				continue;
			}
			char c[]=s.toCharArray();
			for(int i=0;i<c.length;i++)
			{
				String left="",right="",finall="";
				//left
				if(i>0)
				{
					int llength=i;
					char l[]=new char[llength];
					System.arraycopy(c,0,l,0,llength);
					left=String.valueOf(l);
				}
				//right
				if(i!=c.length-1)
				{
					int rlength=c.length-(i+1);
					char r[]=new char[rlength];
					System.arraycopy(c,i+1,r,0,rlength);
					right=String.valueOf(r);
				}
				finall=(left+right).trim();
				StringBuilder sb1=new StringBuilder(finall);
				sb1.reverse();
				if(finall.equals(sb1.toString()))
				{
					b=true;
					ans=i;
					System.out.println(c[i]+" "+c[i+1]);
					break;
				}
			}
			if(b)
			{
				System.out.println(ans);
			}
			else
			{
				System.out.println("-1");
			}
		}
	}

}
/*
24988
28693
12907
9197
35287
*/