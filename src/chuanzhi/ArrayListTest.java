package chuanzhi;

import java.util.*;


/*
 * 去除ArrayList中重复的元素
 */


public class ArrayListTest {
	public static void main(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>();
		al.add("java01");
		al.add("java02");
		al.add("java01");
		al.add("java03");
		//al.add(4);
		
		//al=singleElement(al);
		
		//System.out.println(al);
		Iterator<String> it = al.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
			
			
		}
		
	}
	
	public static ArrayList singleElement(ArrayList al)
	{
		ArrayList temp = new ArrayList();
		
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			if (!temp.contains(obj))
			{
				temp.add(obj);
			}
		}
		
		return temp;
	
		
	}
}
/*

//
// 将自定义对象作为元素存入到ArrayList集合中，并去除重复元素。
// 比如：存人对象。同姓名同年龄视为同一个人。
//

public class ArrayListTest {
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add(new Person5("lisi01",32));
		al.add(new Person5("lisi02",32));
		al.add(new Person5("lisi03",32));
		al.add(new Person5("lisi03",32));
		al.add(new Person5("lisi04",32));
		al.add(new Person5("lisi05",32));

		
		al=singleElement(al);
		
		Iterator it =al.iterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			Person5 p = (Person5)obj;
			System.out.println(p.getName()+"---"+p.getAge());
		}
		
		
		
	}
	public static ArrayList singleElement(ArrayList al)
	{
		ArrayList temp = new ArrayList();
		
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			if (!temp.contains(obj))
			{
				temp.add(obj);
			}
		}
		
		return temp;
	
		
	}
}

class Person5
{
	private String name;
	private int age;
	Person5(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Person5))
			return false;
		Person5 p = (Person5) obj;
		//System.out.println(this.name+"......"+p.name);
		return (this.name.equals(p.name) && this.age == p.age);
			
	}

}
*/