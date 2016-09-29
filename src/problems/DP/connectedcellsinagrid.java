//$Id$
package problems.DP;

import java.util.Scanner;

/*
You are given a matrix with m rows and n columns of cells, each of which contains either 1 or 0. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. The connected and filled (i.e. cells that contain a 1) cells form a region. There may be several regions in the matrix.
Find the number of cells in the largest region in the matrix.
Input Format There will be three parts of the input: The first line will contain m, the number of rows in the matrix. The second line will contain n, the number of columns in the matrix. This will be followed by the matrix grid: the list of numbers that make up the matrix.
Output Format Print the length of the largest region in the given matrix.
Constraints
0 < m < 10
0 < n < 10
Sample Input:
4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0
Sample Output:
5 
 */

//solved using recursive fill algorithm
public class connectedcellsinagrid {
	public static int[][] a;
	static int rows,cols=0;
	public static void main(String[] arg)
	{
		Scanner in=new Scanner(System.in);
		 rows=in.nextInt();
		 cols=in.nextInt();
		a=new int[rows][cols];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				a[i][j]=in.nextInt();
			}
		}
		int max=0;
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				 max=Math.max(connected(i,j),max);
			}
		}
		System.out.println(max);
		
	}
	
	public static int connected(int i,int j)
	{
		if((i<0||j<0)||(i>=rows||j>=cols)||(a[i][j]==0))
		{
			return 0;
		}
		a[i][j]=0;
		return 1+connected(i-1,j-1)+connected(i-1,j)+connected(i-1,j+1)+connected(i,j-1)+connected(i,j+1)+connected(i+1,j-1)+connected(i+1,j)+connected(i+1,j+1);
	}

}
