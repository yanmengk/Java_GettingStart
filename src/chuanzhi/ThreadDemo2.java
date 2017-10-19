package chuanzhi;

public class ThreadDemo2 {
	public static void main(String[] args)
	{
		Demooo d1 = new Demooo("one");
		Demooo d2 = new Demooo("two");
		
		d1.start();
		d2.start();
		
		for (int i=0;i<60;i++)
		{
			System.out.println("hello world--"+i);
		}
		
		
	}


}

class Demooo extends Thread
{
	//private String name;
	Demooo(String name)
	{
		//this.name=name;
		super(name);
	}
	public void run()
	{
		for (int i=0;i<60;i++)
		{
		    System.out.println(Thread.currentThread().getName()+" demo run--"+i);
		}
		
	}

		
	
}