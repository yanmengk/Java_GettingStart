package chuanzhi;

public class InnerClassDemo2 
{
	public static void main(String[] args)
	{
		new Outer2().function();
	}

}
//匿名内部类
abstract class AbsDemo
{
	abstract  void show();
	
}

class Outer2
{
	int x=3;
	public void function()
	{
		/*
		class Inner extends AbsDemo
		{
			void show()
			{
				System.out.println("show:"+x);				
			}
		}
		*/
		//new Inner().show();
		new AbsDemo()
		{
			void show()
			{
				System.out.println("show:"+x);
			}
		}.show();
	}
	
}