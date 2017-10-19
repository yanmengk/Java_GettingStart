package chuanzhi;
import java.io.*;
import java.util.*;

public class JavaFileList {
	public static void main(String[] args) throws IOException
	{
		File dir = new File("/Users/yanmk/Documents/workspace/chuanzhi");
		List<File> list = new ArrayList<File>();
		fileToList(dir,list);
		//System.out.println(list.size());
		
		File file = new File(dir,"javalist.txt");
		writeToFile(list,file.toString());
		
	}
	
	public static void fileToList(File dir,List<File> list)
	{
		File[] files =dir.listFiles();
		for(File f:files)
		{
			if(f.isDirectory())
				fileToList(f,list);
			else
			{
				if(f.getName().endsWith(".java"))
					list.add(f);
			}
				
		}
	}

	public static void writeToFile(List<File> list,String name) throws IOException
	{
		BufferedWriter bufw =null;
		try
		{
			bufw = new BufferedWriter(new FileWriter(name));
			for(File f:list)
			{
				String path=f.getAbsolutePath();
				bufw.write(path);
				bufw.newLine();
				bufw.flush();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		finally
		{
			try
			{
				if(bufw!=null)
					bufw.close();
			}
			catch(Exception e)
			{
					throw e;
			}
		}
	}
}
