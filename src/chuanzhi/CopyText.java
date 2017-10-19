package chuanzhi;
import java.io.*;
public class CopyText {
	public static void main(String[] args)
	{
		copy();
	}
	public static void copy()
	{
		FileWriter fw =null;
		FileReader fr =null;
		try
		{
			fw = new FileWriter("/Users/yanmk/Documents/workspace/chuanzhi/src/chuanzhi/FileReaderDemo.txt");
					
			fr = new FileReader("/Users/yanmk/Documents/workspace/chuanzhi/src/chuanzhi/FileReaderDemo.java");
					
			
			char[] buf = new char[1024];
			int len=0;
			while((len=fr.read(buf))!=-1)
			{
				fw.write(buf,0,len);	
			}	
		}
		catch(IOException e)
		{
			throw new RuntimeException("读写失败");
		}
		finally
		{
			if(fw!=null)
				try{fw.close();	}
			    catch(IOException e)
			    {
				    System.out.println(e.toString());
			    }
			
			if(fr!=null)
				try{
					fr.close();	
				}
					
			    catch(IOException e)
			   {
				    System.out.println(e.toString());
			   }
			
		}
	 
		 
	}

}
