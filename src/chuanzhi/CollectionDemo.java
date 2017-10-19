package chuanzhi;

import java.util.*;
public class CollectionDemo {
	public static void main(String[] args)
	{
		ArrayList a1 = new ArrayList();
		ArrayList a2 = new ArrayList();
		a1.add("java01");
		a1.add("java02");
		a1.add("java03");
		
		a2.add("java02");
		a2.add("java03");
		a2.add("java04");
		
		//System.out.println(a1);
		//System.out.println(a1.isEmpty());
		//System.out.println(a1.size());
		//System.out.println(a1.get(2));
		//System.out.println(a1.remove(2));
		//System.out.println(a1.contains("java02"));
		//System.out.println(a1.set(2, 5));
		//System.out.println(a1);
		a1.addAll(0,a2);
		//a1.remove(3);
		//System.out.println(a1);
		//a1.set(3, 5); 
		//System.out.println(a1);
		
		//System.out.println(a1.subList(1, 3));
		
		for(Iterator it = a1.iterator();it.hasNext();)
		{
			System.out.println(it.next());
		}
		System.out.println(a1.indexOf("java04"));
	}
	

}
