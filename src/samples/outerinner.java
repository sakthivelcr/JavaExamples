//$Id$
package samples;

public class outerinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out outobj=new out();
		outobj.outmethod();
		out.in inobj=outobj.new in();
		inobj.hello();
		out.nest obj=new out.nest();
		obj.hello();
		
		out ob=new out(){
			//must be an overrided method
			 public void sum()
			{
				System.out.println("I'm anon");
			}
		};
		ob.sum();
		
	}
}

class out{
	int b=0;
	static class nest{
		public void hello()
		{
			System.out.println("helloworld-nested");
		}
	}
	class in{
		public void hello()
		{
			System.out.println("helloworld-innerclass");
		}
	}
	public void outmethod()
	{
		int a=0;
		class local
		{
			public void imlocal()
			{
				System.out.println("imlocal "+a+b);
				out ob=new out();
				ob.sum();
			}
		}
		local l=new local();
		l.imlocal();
		System.out.println("outmethod");
	}
	public void sum(){}
}