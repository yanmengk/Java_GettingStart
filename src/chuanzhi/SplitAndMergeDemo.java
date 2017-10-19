package chuanzhi;
import java.io.*;
import java.util.*;


public class SplitAndMergeDemo {
	public static void main(String[] args) throws IOException
	{
		//splitFile();
		merge();
	}
	public static void splitFile() throws IOException
	{
		FileInputStream fis = new FileInputStream("/Users/yanmk/Downloads/girl.jpg");	
		FileOutputStream fos =null;	
		int len=0;
		int count=1;
		
		byte[] buf=new byte[1024*10];
		while((len=fis.read(buf))!=-1)
		{
			fos=new FileOutputStream("/Users/yanmk/Downloads/splitFiles/"+(count++)+".part");
			fos.write(buf,0,len);
			fos.close();
		}
		
		fis.close();
		
		
		
		
		
	}
	public static void merge() throws IOException
	{
		ArrayList<FileInputStream> al= new ArrayList<FileInputStream>();
		
		for(int x=1;x<=7;x++)
		{
			al.add(new FileInputStream("/Users/yanmk/Downloads/splitFiles/"+x+".part"));
		}
		final Iterator<FileInputStream> it =al.iterator();
		
		//此处的匿名内部类没看懂？？？？？
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>()
		{
			public boolean hasMoreElements()
			{
				return it.hasNext();
			}
			public FileInputStream nextElement()
			{
				return it.next();
			}
		};
		
		SequenceInputStream sis = new SequenceInputStream(en);
		
		FileOutputStream fos = new FileOutputStream("/Users/yanmk/Downloads/splitFiles/0.jpg");
		
		byte[] buf = new byte[1024];
		int len=0;
		while((len=sis.read(buf))!=-1)
		{
			fos.write(buf,0,len);
			
		}
		fos.close();
		sis.close();
		
				
	}

}
