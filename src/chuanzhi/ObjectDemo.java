package chuanzhi;

public class ObjectDemo 
{
	public static void main(String[] args)
	{
		Demo d1=new Demo(4);
		Demo d2=new Demo(5);
		System.out.println(d1.equals(d2));
		
		System.out.println(d1.toString());
		
		Class c =d1.getClass();
		//System.out.println(c.getName());
		System.out.println(d1.toString());
		System.out.println(c.getName()+"@"+Integer.toHexString(d1.hashCode()));
	}

}

class Demo
{
	private int num;
	Demo(int num)
	{
		this.num=num;
	}
	
	/*
	public boolean compare(Demo d)
	{
		return (this.num==d.num);
	}
	*/
	public boolean equals(Object obj)
	{
		Demo d=(Demo)obj;
		return (this.num==d.num);
		
	}
	public String toString()
	{
		return "Demo:"+num; 
	}
	
}
