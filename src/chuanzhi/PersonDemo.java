package chuanzhi;

public class PersonDemo 
{
	public static void main(String[] args)
	{
		Person p1=new Person(20);
		Person p2=new Person(35);
		boolean b=p1.compare(p2);
		System.out.println(b);
	}

	
}

class Person
{
	private String name;
	private int age;
	Person(int age)
	{
		this.age=age;
	}
	Person(String name)
	{
		this.name=name;
	}
	Person(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public boolean compare(Person p)
	{
		return this.age==p.age;
	}

}