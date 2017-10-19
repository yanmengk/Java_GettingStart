package chuanzhi;

public class ExceptionTest1 {
	public static void main(String[] args)
	{
		Rec r=new Rec(3,4);
		r.getArea();
		
		Circle c= new Circle(-5);
		c.getArea();
	
		
	}

}

class NoValueException extends RuntimeException
{
	NoValueException(String message)
	{
		super(message);
	}
	
}

interface Shape
{
	void getArea();
}

class Rec implements Shape
{
	private int len,width;
	Rec(int len,int width)
	{
		if (len<=0 || width<=0)
			throw new NoValueException("出现非法值");
		this.len=len;
		this.width=width;
	}
	public void getArea()
	{

		System.out.println(len*width);
	}
	
}

class Circle implements Shape
{
	private int r;
	public static final double PI=3.14;
	Circle(int r)
	{
		if (r<=0)
			throw new NoValueException("出现负值");
		this.r=r;
	}
	public void getArea()
	{
		System.out.println(r*r*PI);
	}
	
}

