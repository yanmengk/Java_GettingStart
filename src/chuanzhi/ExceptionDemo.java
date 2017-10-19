package chuanzhi;

public class ExceptionDemo 
{
	public static void main(String[] args)
	{
		Demo2 d=new Demo2();
		
		try
		{
			int x=d.div(4,0);
			System.out.println("x="+x);
		}
		catch(Exception e)
		{
			System.out.println("出错啦");
			System.out.println(e.toString());
			//e.printStackTrace();
			
		}
		System.out.println("over");
	}

}
class Demo2
{
	int div(int a,int b) throws Exception 
	{ 
		return a/b;
	}
	
}

