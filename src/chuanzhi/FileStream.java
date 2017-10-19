package chuanzhi;

import java.io.*;

public class FileStream {
	public static void main(String[] args) throws IOException
	{
		//writeFile();
		//readFile_1();
		readFile_2();
		//readFile_3();
	}
	public static void writeFile() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("fos.txt");
		fos.write("abcde".getBytes());
		fos.close();
	}
	
	public static void readFile_1() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");
		int num=0;
		while((num=fis.read())!=-1)
		{
			System.out.println((char)num);
		}
		fis.close();
	}
	
	public static void readFile_2() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");
		byte chr[] =new byte[1024];
		int len=0;
		while((len=fis.read(chr))!=-1)
		{
			System.out.println(new String(chr,0,len));
		}
	}
	
	public static void readFile_3() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");
		byte chr[] =new byte[fis.available()];
		fis.read(chr);
		System.out.println(new String(chr));
	}

}
