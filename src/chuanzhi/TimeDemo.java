package chuanzhi;

public class TimeDemo 
{
	public static void main(String[] args)
	{
		GetTime st=new SubTime();
		st.getTime();
	}

}

abstract class GetTime
{
	public final void getTime()
	{
		long start = System.currentTimeMillis();
		
        runcode();
			
		long end = System.currentTimeMillis();
		
		System.out.print("\n毫秒： "+(end-start));
	}
	
	public abstract void runcode();

} 

class SubTime extends GetTime
{
	public void runcode()
	{
		for (int x=0;x<5000;x++)
		{
			System.out.print(x);
		}
	}
	
}