package chuanzhi;

import java.util.concurrent.locks.*;


/**
 * 
 * @author yanmk
 *
 */
/*
 * 多生产者-多消费者模式
 * 
 */

/*
public class ProducerConsumer {
	public static void main(String[] args)
	{
		Resource res=new Resource();
		Producer p= new Producer(res);
		Consumer c= new Consumer(res);
	    Thread t1=new Thread(p);
	    Thread t2=new Thread(p);
	    Thread t3=new Thread(c);
	    Thread t4=new Thread(c);
	    t1.start();
	    t2.start();
	    t3.start();
	    t4.start();
	}

}
class Resource
{
	private String name;
	private int count=1;
	private boolean flag=false;
	public synchronized void set(String name)
	{
		while(flag)
		{
			try
			{
				this.wait();
			}
			catch(Exception e)
			{				
			}	
		}
		this.name=name+"---"+count++;
		System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
		flag=true;
		this.notifyAll();
	}
	public synchronized void out()
	{
		while(!flag)
		{
			try
			{
				this.wait();
			}
			catch(Exception e)
			{				
			}	
		}
		System.out.println(Thread.currentThread().getName()+"++++++消费者++++++"+this.name);
		flag=false;
		this.notifyAll();
	}
	
}

class Producer implements Runnable
{
	private Resource res;	
	Producer(Resource res)
	{
		this.res=res;
	}
	public void run()
	{
		while(true)
		{
			res.set("商品");
		}
		
		
	}
}
class Consumer implements Runnable
{
	private Resource res;	
	Consumer(Resource res)
	{
		this.res=res;
	}
	public void run()
	{
		while(true)
		{
			res.out();
		}
		
	}
	
}
*/

public class ProducerConsumer {
	public static void main(String[] args)
	{
		Resource res=new Resource();
		Producer p= new Producer(res);
		Consumer c= new Consumer(res);
	    Thread t1=new Thread(p);
	    Thread t2=new Thread(p);
	    Thread t3=new Thread(c);
	    Thread t4=new Thread(c);
	    t1.start();
	    t2.start();
	    t3.start();
	    t4.start();
	}

}
class Resource
{
	private String name;
	private int count=1;
	private boolean flag=false;
	private Lock lock=new ReentrantLock();
	private Condition pro=lock.newCondition();
	private Condition con=lock.newCondition();
	
	public  void set(String name) throws InterruptedException
	{
		lock.lock();
		try
		{
			while(flag)
				pro.await();
			this.name=name+"---"+count++;
			System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
			flag=true;
			//this.notifyAll();
			con.signal();
		}
		
		finally
		{
			lock.unlock();
		}

	}
	public  void out() throws InterruptedException
	{
		lock.lock();
		try
		{
			while(!flag)
				con.wait();
			System.out.println(Thread.currentThread().getName()+"++++++消费者++++++"+this.name);
			flag=false;
			pro.signal();
			
		}
		finally
		{
			lock.unlock();
		}
		
	}
	
}

class Producer implements Runnable
{
	private Resource res;	
	Producer(Resource res)
	{
		this.res=res;
	}
	public void run()
	{
		while(true)
		{
			try {
				res.set("商品");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
class Consumer implements Runnable
{
	private Resource res;	
	Consumer(Resource res)
	{
		this.res=res;
	}
	public void run()
	{
		while(true)
		{
			try {
				res.out();
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
		
	}
	
}