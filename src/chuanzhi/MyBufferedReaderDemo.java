package chuanzhi;
import java.io.*;
public class MyBufferedReaderDemo {
	public static void main(String[] args) throws IOException
	{
		//不带行号的
		/*
		MyBufferedReader br = new MyBufferedReader(new FileReader("bw.txt"));
		String line =null;
		while((line=br.myReadLine())!=null)
		{
			System.out.println(line);
		}
		br.myClose();
		*/
		//带行号的
		MyLineNumberReader mlnr = new MyLineNumberReader(new FileReader("/Users/yanmk/Documents/workspace/chuanzhi/src/chuanzhi/DuoTaiDemo.java"));
		String line =null;
		mlnr.setLineNumber(100);
		while((line=mlnr.myReadLine())!=null)
		{
			System.out.println(mlnr.getLineNumber()+"::"+line);
		}
		mlnr.myClose();
	}

}

class MyBufferedReader 
{
	private FileReader r;
	MyBufferedReader(FileReader r)
	{
		this.r=r;
	}
	public String myReadLine() throws IOException
	{
		StringBuilder sb = new StringBuilder();
		int chs=0;
		while((chs=r.read())!=-1)
		{
			if(chs=='\n')
				return sb.toString();
			sb.append((char)chs);
		}
		if (sb.length()!=0)
			return sb.toString();
		return null;
	}
	public void myClose() throws IOException
	{
		r.close();
	}
	
}
class MyLineNumberReader extends MyBufferedReader
{
	private int lineNumber;
	MyLineNumberReader(FileReader r)
	{
		super(r);
	}
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber=lineNumber;
	}
	public int getLineNumber()
	{
		return lineNumber;
	}
	
	public String myReadLine() throws IOException
	{
		lineNumber++;
		return super.myReadLine();
	}
}
