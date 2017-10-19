package chuanzhi;
import java.io.*;
import java.text.*;
import java.util.*;

public class ExceptionInfo {
	public static void main(String[] args)
	{
		try
		{
			int[] arr=new int[2];
			System.out.println(arr[3]);
			
		}
		catch(Exception e)
		{
			try
			{
				Date d = new Date();
				SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				PrintStream ps=new PrintStream("exception.log");
				ps.println(sdf.format(d).toString());     //打印时间
				e.printStackTrace(ps);   //打印出错日志信息
				
				
			}
			catch(Exception ee)
			{
				throw new RuntimeException("日志导出失败");
			}
			
		}

		
	}

}
