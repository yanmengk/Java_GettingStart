package chuanzhi;

/*
 * 毕老师用电脑上课
 * 开始思考上课中出现的问题：
 * 比如问题1：电脑蓝屏
 *    问题2：电脑冒烟
 *    
 *    要对问题进行描述，封装成对象
 *    
 *    可是当冒烟发生后，出现讲课进度无法继续进行。所以讲师出现了问题：讲师异常：课时计划无法完成
 *    再定义一个 NoPlanException
 */


public class ExceptionTest {
	public static void main(String[] args)
 	{
		Teacher t=new Teacher("毕老师");
		try
		{
			t.teach();
		}
		catch(NoPlanException e)
		{
			System.out.println(e.toString());
			System.out.println("换老师或者放假");
		}

	} 

} 

class LanPingException extends Exception
{
	LanPingException(String message)
	{
		super(message);
	}
	
}

class MaoYanException extends Exception
{
	MaoYanException(String message)
	{
		super(message);
		
	}
}

class NoPlanException extends Exception
{
	NoPlanException(String message)
	{
		super(message);
	}
}

class Computer
{
	private int state=3;
	public void run() throws LanPingException,MaoYanException
	{
		if (state==2)
			throw new LanPingException("蓝屏啦");
		if (state==3)
			throw new MaoYanException("冒烟啦");
		System.out.println("电脑运行");
	}
	public void reset()
	{
		state=1;
		System.out.println("电脑重启");
	}

}

class Teacher
{
	private String name;
	private Computer c;
	Teacher(String name)
	{
		this.name=name;
		c=new Computer();
	}
	public void teach() throws NoPlanException
	{
		try
		{
			c.run();
		}
		catch(LanPingException e)
		{
			c.reset();
		}
		catch(MaoYanException e)
		{
			test();
			throw new NoPlanException("课时无法继续"+e.getMessage());
		}
		System.out.println("上课");
	}
	public void test()
	{
		System.out.println("做练习");
	}
}