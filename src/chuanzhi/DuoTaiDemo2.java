package chuanzhi;

public class DuoTaiDemo2 
{
	public static void main(String[] args)
	{
		DoStudent ds=new DoStudent();
		ds.doSome(new BaseStudent());
		ds.doSome(new AdvStudent());
	}

}

abstract class Student
{

	public abstract void study();
	public void sleep()
	{
		System.out.println("躺着睡");
	}
}

class DoStudent
{
	public void doSome(Student s)
	{
		s.study();
		s.sleep();
	}

}

class BaseStudent extends Student
{
	public void study()
	{
		System.out.println("base study");
	}
}
class AdvStudent extends Student
{
	public void study()
	{
		System.out.println("adv study");
	}
	
}
