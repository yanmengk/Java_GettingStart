package chuanzhi;
import java.io.*;
import java.util.*;

public class SequenceDemo {
	public static void main(String[] args) throws IOException
	{
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		
		v.add(new FileInputStream("/Users/yanmk/Downloads/1.txt"));
		v.add(new FileInputStream("/Users/yanmk/Downloads/2.txt"));
		v.add(new FileInputStream("/Users/yanmk/Downloads/3.txt"));
		
		
		Enumeration<FileInputStream> en =v.elements();
		
		SequenceInputStream sis=new SequenceInputStream(en);
		

		FileOutputStream fos = new FileOutputStream("/Users/yanmk/Downloads/4.txt");
		
		int ch=0;
		byte[] buf = new byte[1024];
		while((ch=sis.read(buf))!=-1)
		{
			fos.write(buf,0,ch) ;
		}
		fos.close();
		sis.close();
		
		
		
		
	}
	

}
