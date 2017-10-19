package chuanzhi;
import java.util.*;

/*用LinkedList实现一个队列和堆栈。
 * 
 * 
*/

public class LinkedListDemo {
	public static void main(String [] args)
	{
		Queue q = new Queue();
		q.myAdd("java01");
		q.myAdd("java02");
		q.myAdd("java03");
		q.myAdd("java04");
		while (!q.isNull())
		{
			System.out.println(q.myGet());
		}
		
		
	}

}

class Queue
{
	private LinkedList link;
	Queue()
	{
		link=new LinkedList();
	}
	public void myAdd(Object obj)
	{
		link.addFirst(obj);
	}
	public Object myGet()
	{
		return link.removeLast(); //将removeLast换成removeFirst即可为堆栈。
	}
	public boolean isNull()
	{
		return link.isEmpty();
	}
	
}
