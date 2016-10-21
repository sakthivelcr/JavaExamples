//$Id$
package problems;

/*
 Print a single integer denoting the number of letter a's in the 
 first  letters of the infinite string created by repeating  infinitely many times.
Sample Input 
aba
10
Sample Output 
7
 */
import java.util.Scanner;

public class repeatedstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        int len=s.length();
        int count=len-s.replace("a","").length();
        long ans=(n/len);
        int rem=(int) (n%len);
        if(rem==0)
        {
        	System.out.println(ans*count);
        }
        else
        {
        	String tmp=s.substring(0,rem);
        	int le=tmp.length()-tmp.replace("a","").length();
        	System.out.println((ans*count)+le);
        }
	}

}
