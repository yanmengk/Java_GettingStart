package chuanzhi;
import java.util.*;


public class GenericDemo {
	public static void main(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>();
		al.add("abc01");
		al.add("abc02");
		al.add("abc03");
		
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(2);
		al2.add(3);
		al2.add(4);
		
		//printColl(al);
		//printColl(al2);
		ArrayList<Person9> al3 = new ArrayList<Person9>();
		al3.add(new Person9("java01"));
		al3.add(new Person9("java02"));
		al3.add(new Person9("java03"));
		//printColl(al3);
		ArrayList<Student9> al4 = new ArrayList<Student9>();
		al4.add(new Student9("java--01"));
		al4.add(new Student9("java--02"));
		al4.add(new Student9("java--03"));
		printColl(al4);
		
	}
	/*
	public static void printColl(ArrayList<?> a)
	{
		Iterator<?> it =a.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		} 
	}
	*/
	public static void printColl(ArrayList<? extends Person9> a)
	{
		Iterator<? extends Person9> it =a.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().getName());
		} 
	}

}
class Person9
{
	private String name;
	Person9(String name) 
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
}
class Student9 extends Person9
{
	private String name;
	Student9(String name)
	{
		super(name);
	}
}


