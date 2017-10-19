package chuanzhi;
import java.text.*;
import java.util.*;

/* 获取系统的属性信息
 * 方法：System.getProperties()
 * 
 */

public class SystemDemo {
	public static void main(String[] args)
	{
		
		Properties pro =System.getProperties();
		for(Object obj: pro.keySet())
		{
			String value =(String)pro.get(obj);
			System.out.println(obj+":::"+value);
		}
		
		//String s = System.getProperty("os.name");
		//System.out.println(s);
		Date d = new Date();
		//System.out.println(d);
		
		//将模式封装到SimpleDateFormat对象中。
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日E hh:mm:ss");
		String s=sdf.format(d);
		System.out.println(s);
		
	}

}
