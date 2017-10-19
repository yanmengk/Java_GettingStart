package chuanzhi;
import java.io.*;



public class FIleWriterDemo 
{
	public static void main(String[] args) throws IOException
	{
		FileWriter fw = new FileWriter("demo.txt");
		fw.write("abcdef");
		fw.flush();
		fw.close();
		//fw.write("www");
	}

}
