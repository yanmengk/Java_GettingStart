package chuanzhi;

/**
 * 
 * @author yanmk
 * @time 2017-09-13
 */

/*
 * 需求：创建一个简单的售票程序
 * 多个窗口同时售票
 */
class ThreadDemo3 {
	public static void main(String [] args)
	{
		/*
		Ticket t1=new Ticket();
		Ticket t2=new Ticket();
		Ticket t3=new Ticket();
		Ticket t4=new Ticket();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		*/
		
		Ticket t=new Ticket();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);
		Thread t4=new Thread(t);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
/*
class Ticket extends Thread
{
	private static int ticket=100;
	public void run()
	{
		while(true)
		{
			if(ticket>0)
				System.out.println(currentThread().getName()+" 出售第"+ ticket-- +"张票");
		}
	}
	
}
*/
class Ticket implements Runnable
{
	private int ticket=100;
	//Object obj = new Object();
	public void run()
	{
		while(true)
		{
			func();
		}
	}
	public synchronized void func()
	{
		try{Thread.sleep(10);}
		catch(Exception e){}
		if(ticket>0)
			System.out.println(Thread.currentThread().getName()+" 出售第"+ ticket-- +"张票");
	}
	
}


