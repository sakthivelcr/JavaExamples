//$Id$
package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/*
 * https://www.hackerrank.com/challenges/string-construction
 */
public class stringconstruction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int input=in.nextInt();
		ArrayList<String> al=new ArrayList<String>();
		for(int i=0;i<input;i++)
		{
			al.add(in.next());
		}
		for(String s:al)
		{
			char c[]=s.toCharArray();
			HashSet<Character> hs=new HashSet<Character>();
	        for(char tmp:c)
	        {
	        	hs.add(tmp);
	        }
	        System.out.println(hs.size());
		}
	}

}
