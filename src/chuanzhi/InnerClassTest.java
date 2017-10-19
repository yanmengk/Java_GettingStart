package chuanzhi;

public class InnerClassTest {
	public static void main(String[] args)
	{
		Test.function().method();
	}

}


interface Inter
{
	void method();
}

class Test
{
	public static Inter function()
	{
		//return new Inner();
		//通过匿名内部类实现
		return new Inter()
				{
			        public void method()
			        {
				       System.out.println("method run");
			        }  	
				};
	}
	
	/*
	static class Inner implements Inter
	{
		public void method()
		{
			System.out.println("method run");
		}
	}
	*/
	

}
