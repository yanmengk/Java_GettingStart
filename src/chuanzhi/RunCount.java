package chuanzhi;
import java.util.*;
import java.io.*;
public class RunCount {
	public static void main(String[] args) throws IOException
	{
		Properties prop = new Properties();
		
		File f=new File("count.ini");
		if(!f.exists())
			f.createNewFile();
		FileInputStream fis = new FileInputStream(f);
		
		prop.load(fis);
		
		int count=0;
		String value=prop.getProperty("time");
		if(value!=null)
		{
			count=Integer.parseInt(value);
			if(count>=5)
				System.out.println("您的试用次数已到，请购买方能继续试用！");
		}
		count++;
		
		prop.setProperty("time", count+"");
		
		FileOutputStream fos = new FileOutputStream(f);
		
		prop.store(fos, "");
		
		fis.close();
		fos.close();
		
		
		
	}

}
