package chuanzhi;
import java.util.*;

public class HashSetDemo {
	public static void main(String[] args)
	{
		HashSet hs = new HashSet();
		hs.add(new Person6("a1",11));
		hs.add(new Person6("a2",12));
		hs.add(new Person6("a3",13));
		hs.add(new Person6("a2",12));
		hs.add(new Person6("a3",13));
		
		hs.add(new Person6("a1",11));
		hs.add(new Person6("a1",11));
		
		Iterator it =hs.iterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			Person6 p = (Person6)obj;
			System.out.println(p.getName()+"---"+p.getAge());
		}
		
		
		
	}



}

class Person6
{
	private String name;
	private int age;
	Person6(String name,int age)
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
	
	public int hashCode()
	{
		//System.out.println(this.name+".......hashCode");
		return name.hashCode()+age*33;
	}
	
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Person6))
			return false;
		Person6 p = (Person6) obj;
		//System.out.println(this.name+"......"+p.name);
		return (this.name.equals(p.name) && this.age == p.age);
			
	}
}