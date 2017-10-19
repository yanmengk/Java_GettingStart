package chuanzhi;
import java.io.*;
public class FileReaderDemo {
	public static void main(String[] args) throws IOException
	{
		/*
		FileReader fr = new FileReader("demo.txt");
		
		int ch=0;
		while((ch=fr.read())!=-1)
		{
			System.out.println((char)ch);
		}
		fr.close();
		*/
		/*
		FileReader fr = new FileReader("demo.txt");
		char[] ch =new char[3];
		int num=0;
		while((num=fr.read(ch))!=-1)
		{
			System.out.println("num="+num+"..."+new String(ch,0,num));
		}
		fr.close();
		*/
		FileReader fr = new FileReader("/Users/yanmk/Documents/workspace/chuanzhi/src/chuanzhi/ExceptionDemo.java");
		LineNumberReader lnr = new LineNumberReader(fr);
		String line = null;
		while((line=lnr.readLine())!=null)
		{
			System.out.println(lnr.getLineNumber()+":"+line);
		}
		lnr.close();
	}

}
