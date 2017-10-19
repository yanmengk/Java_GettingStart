package chuanzhi;

public class ThreadDemo {
	public static void main(String[] args)
	{
		Demoo d = new Demoo();
		d.start();
		
		for (int i=0;i<60;i++)
		{
			System.out.println("hello world--"+i);
		}
		
		
	}


}

class Demoo extends Thread
{
	public void run()
	{
		for (int i=0;i<60;i++)
		{
		    System.out.println("demo run--"+i);
		}
	}

		
	
}