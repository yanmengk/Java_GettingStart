package chuanzhi;
import java.io.*;

public class FileWriterDemo2 {
	public static void main(String[] args)
	{
		FileWriter fw =null;
		try
		{
			//fw = new FileWriter("demo.txt");
			fw = new FileWriter("demo.txt",true);
			//fw.write("abcdef");
			fw.write("nihao\nxiexie");
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			try
			{
				if(fw!=null)
					fw.close();	
			}
			catch(IOException e)
			{
				System.out.println(e.toString());
			}
			
		}
		
	}

}
