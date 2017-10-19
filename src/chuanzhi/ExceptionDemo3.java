package chuanzhi;

public class ExceptionDemo3 {
	public static void main(String[] args)
	{
		Demo4 d = new Demo4();
		try
		{
			int x= d.div(4, -9);
			System.out.println("x="+x);
		}
		catch(FushuException e)
		{
			System.out.println(e.toString());
			//System.out.println("除数出现了负数");
			System.out.println(e.getValue());
		}
		System.out.println("over");
	
	}

}
class Demo4
{
	int div(int a,int b) throws FushuException
	{
		if (b<0)
			throw new FushuException("除数中出现了负数--- / by fushu",b);
		return a/b;
	}
	
}

//自定义异常
//例子：如果除数出现负数，则视为异常
class FushuException extends Exception
{
	private int value;
	FushuException(String message,int value)
	{
		super(message);
		this.value=value;
	}
	public int getValue()
	{
		return value;
	}
}