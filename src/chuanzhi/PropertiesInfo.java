package chuanzhi;
import java.util.*;
import java.io.*;
public class PropertiesInfo {
	public static void main(String[] args) throws IOException
	{
		//Properties prop =System.getProperties();
		//System.out.println(prop);
		//prop.list(System.out);
		//prop.list(new PrintStream("sysinfo.txt"));
		consMethod();
	}
	
	public static void consMethod() throws IOException
	{
		File f1 = new File("1.txt");
		File f2 = new File("/Users/yanmk/Downloads","2.txt");
		
		//File d = new File("/Users/yanmk/Downloads");
		File d = new File(File.separator+"Users"+File.separator+"yanmk"+File.separator+"Downloads");
		File f3 = new File(d,"3.txt");
		System.out.println("create:"+f1.createNewFile());
		System.out.println(f2);
		System.out.println(f3);
	}

}
