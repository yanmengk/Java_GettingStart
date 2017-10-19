package chuanzhi;

/*
 * 需求：
 * 银行有一个金库
 * 两个储户分别往里面存300元钱，每次存100，存3次。
 */

public class BankDemo {
	public static void main(String[] args)
	{
		Customer c=new Customer();
		Thread t1=new Thread(c);
		Thread t2=new Thread(c);
		
		t1.start();
		t2.start();
	}

}
class Customer implements Runnable
{
	Bank b = new Bank();
	public void run()
	{
		for (int i=0;i<3;i++)
		{
			b.add(100);
		}

	}

	
}

class Bank
{
	private int sum;
	public synchronized void add(int n)
	{
		
		sum=sum+n;
		try{Thread.sleep(10);} catch(Exception e){}
		System.out.println("sum="+sum);
	}
}