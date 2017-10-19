package chuanzhi;
import java.io.*;
public class FileDemo {
	public static void main(String[] args)
	{
		//listRootsDemo();
		//listDemo();
		
		//File dir = new File("/Users/yanmk/Downloads/");
		//showDir(dir,0);
		File dir = new File("/Users/yanmk/Downloads/");
		removeDir(dir);
	}
	public static void listRootsDemo()
	{
		File[] files = File.listRoots();
		for(File f:files)
		{
			System.out.println(f);
		}
	
	}
	public static void listDemo()
	{
		File f = new File("/Users");
		String[] names =f.list();
		for(String name:names)
		{
			System.out.println(name);
		}
	
	}
	
	public static void showDir(File dir,int l)
	{
		System.out.println(getLevel(l)+dir);
		l++;
		File[] files =dir.listFiles();
		for(int x=0;x<files.length;x++)
		{
			if(files[x].isDirectory())
				showDir(files[x],l);
			else
				System.out.println(getLevel(l)+files[x]);
		}
		
	}
	public static String getLevel(int l)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("|--");
		for(int x=0;x<l;x++)
		{
			sb.insert(0, "|  ");
		}
		return sb.toString();
	
	}
	public static void removeDir(File dir)
	{
		File[] files =dir.listFiles();
		for(int x=0;x<files.length;x++)
		{
			if(files[x].isDirectory())
				removeDir(files[x]);
			else
				files[x].delete();
		}
		dir.delete();
		
	}

}
