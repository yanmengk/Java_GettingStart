package chuanzhi;
import java.io.*;
import java.util.*;
public class EncodeStream {
	public static void main(String[] args) throws IOException
	{
		//writeFile();
		//readFile();
		encode_demo();
	}
	public static void writeFile() throws IOException
	{
		//OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk.txt"),"GBK");
		//osw.write("你好");
		//osw.close();
		
		OutputStreamWriter osw2 = new OutputStreamWriter(new FileOutputStream("utf.txt"),"UTF-8");
		osw2.write("你好");
		osw2.close();
	}
	public static void readFile() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk.txt"),"GBK");
		char[] buf = new char[10];
		int len=0;
		len=isr.read(buf);
		String s=new String(buf,0,len);
		//System.out.println(len);
		System.out.println(s);
		
	}
	
	public static void encode_demo() throws IOException
	{
		String s ="你好";
		byte[] b1 = s.getBytes("GBK");
		System.out.println(Arrays.toString(b1));
	}
	
	

	
}
