//$Id$
package problems;

import java.util.HashMap;


public class equalshashcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		selectquery sq=new selectquery("aaauser");
		HashMap<selectquery,String> hm2=new HashMap<selectquery,String>();
		selectquery sq1=new selectquery("aaauser");
		hm2.put(sq,"hello");
		System.out.println(hm2.get(sq1));
	}

}

class selectquery
{
	String tablename;
	public selectquery(String tablename)
	{
		this.tablename=tablename;
	}
	  @Override
	public boolean equals(Object e1)
	{
		  selectquery sq1=(selectquery)e1;
		return this.tablename==sq1.tablename;
	}
	public String tablename()
	{
		return this.tablename;
	}
	  @Override
	public int hashCode()
	{
		  int hcode=0;
		  for(char c:tablename.toCharArray())
		  {
			  hcode=hcode+(int)c;
		  }
		  System.out.println(hcode);
		return hcode;
	}
}


