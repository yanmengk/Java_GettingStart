package chuanzhi;

import java.io.*;

public class FileWriterTest {
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("/Users/yanmk/Documents/workspace/chuanzhi/src/chuanzhi/FileWriterDemo2.java");
		char[] ch =new char[1024];
		int num=0;
		while((num=fr.read(ch))!=-1)
		{
			System.out.print(new String(ch,0,num));
		}
		fr.close();
	}

}
