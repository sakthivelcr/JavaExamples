//$Id$
package samples;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import java.lang.Comparable;

public class comparatorcompare {
	public static void main(String[] ar)
	{
		String h="b";
		String s="ac2";
		s.toString();
		StringBuilder sb=new StringBuilder("sakthivel");
		//out.println(h.charAt(0));
			//System.out.println(s.substring(2, 2));
			//Collections.sort(null);
			//out.println(h.compareTo(s));
			Employee e1=new Employee(1);
			Employee e2=new Employee(2);
			Employee e3=new Employee(3);
			Employee e4=new Employee(4);
			TreeSet<Employee> ts=new TreeSet<Employee>();
			ts.add(e1);
			ts.add(e2);
			ts.add(e3);
			ts.add(e4);
			for(Employee ee:ts)
			{
				out.println(ee.getId());
			}
			ArrayList<Employee> al=new ArrayList<Employee>();
			al.add(e2);
			al.add(e1);
			al.add(e3);
			al.add(e4);
			Collections.sort(al,new com());
			for(Employee e:al)
			{
				out.println(e.getId());
			}
			//out.println(e1.compareTo(e2));
	}

}

class Employee implements Comparable
{
	
	public int id;
	
	public Employee(int i)
	{
		this.id=i;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Employee e=(Employee) o;
		if(e.id>this.id)
		{
			return 1;
		}
		else if(e.id<this.id)
		{
			return -1;
		}	
		return 0;
	}
	public int getId()
	{
		return this.id;
	}	
}

class com implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Employee e=(Employee) o1;
		Employee e2=(Employee) o2;
		if(e.id>e2.id)
		{
			//return e.id-e2.id;
			return e2.id-e.id;
		}
		else if(e.id<e2.id)
		{
			//return e.id-e2.id;
			return e2.id-e.id;
		}	
		return 0;
	}
	
}
