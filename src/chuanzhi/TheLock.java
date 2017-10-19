package chuanzhi;

public class TheLock {
	public static void main(String [] args)
	{
		
		Ticket1 t=new Ticket1();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		
		t1.start();
		t.flag=false;
		try{Thread.sleep(10);}catch(Exception e){}
		t2.start();

		
	}

}


class Ticket1 implements Runnable
{
	private static int ticket=100;
	Object obj = new Object();
    boolean flag=true;
	public void run()
	{
		if(flag)
		{		
			while(true)
			{
				synchronized(Ticket1.class)
				{
					
					if(ticket>0)
						try{Thread.sleep(10);}catch(Exception e){}
						System.out.println(Thread.currentThread().getName()+" 出售第"+ ticket-- +"张票");
				}
			
			}
		}
		else
		{
			while(true)
				func();
				
		}
			
		
	}
	
	
	public static synchronized void func()
	{

		if(ticket>0)
		{
			try{Thread.sleep(10);}
			catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+" 出售第"+ ticket-- +"张票");
		}
	
	}
	
	
	
}