package chuanzhi;

public class InnerClassDemo {
	public static void main(String[] args)
	{
		//Outer ot=new Outer();
		//ot.method();
		//Outer.Inner in=new Outer().new Inner();
		//in.function();
		
		new Outer.Inner().function();
		
	}

}

class Outer
{
	private static int num=3;
	
	static class Inner
	{
		//int num=4;
		void function()
		{
			//int num=5;
			System.out.println("inner num: "+num);//num; this.num即Inner.this.num; Outer.this.num;
		}
	}
	
	public void method()
	{
		System.out.println("outer num: "+num);
		
	}
	
}