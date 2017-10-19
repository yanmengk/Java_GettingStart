package chuanzhi;
import java.io.*;
import java.util.*;
public class PropertiesDemo {
	public static void main(String[] args) throws IOException
	{
		//method_1();
		method_2();
	}
	public static void method_1() throws IOException
	{
		BufferedReader bufr= new BufferedReader(new FileReader("info.txt"));
		
		Properties prop = new Properties();
		
		String line=null;
		while((line=bufr.readLine())!=null)
		{
			//System.out.println(line);
			String[] arr=line.split("=");
			prop.setProperty(arr[0], arr[1]);
		}
		bufr.close();
		System.out.println(prop);
	} 
	
	//封装的方法：load，直接将流加载进properties
	public static void method_2() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("info.txt");
		prop.load(fis);
		prop.setProperty("wangwu", "33");
		
		FileOutputStream fos = new FileOutputStream("info.txt");
		prop.store(fos, "haha");
		//System.out.println(prop);
		prop.list(System.out);
		fis.close();
		fos.close();
	}

}

