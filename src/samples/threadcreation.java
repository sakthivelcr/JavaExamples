//$Id$
package samples;

public class threadcreation {
	
	public static void main(String[] arg)
	{
		aa obj=new aa();
		obj.start();
		
		bb bobj=new bb();
		Thread t=new Thread(bobj);
		t.start();
		String a="immutable";
		Thread tt=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("anon start");
			}
		};
		tt.start();
		
	}

}
class aa extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("start-thread" );
	}
	
}

class bb implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("start");
	}
	
}
