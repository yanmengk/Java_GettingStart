package chuanzhi;

public class ExceptionDemo2 
{
	public static void main(String[] args)
	{
		Demo3 d=new Demo3();
		int[] arr=new int[4];
		
		try
		{
			int x=d.div(5,1);
			
			System.out.println(arr[4]);
			System.out.println("x="+x);
		}
		catch(ArithmeticException e)
		{
			System.out.println("被零除啦");
			System.out.println(e.toString());
			
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("角标越界啦");
			System.out.println(e.toString());
		}
			
		System.out.println("over");
	}

}
class Demo3
{
	int div(int a,int b) throws ArithmeticException,ArrayIndexOutOfBoundsException
	
	{
		return a/b;
	}
	
}
