package chuanzhi;
import java.io.*;

public class BufferedWriterDemo {
	public static void main(String[] args) throws IOException
	{
		/*
		FileWriter fw = new FileWriter("bw.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for (int x=0;x<5;x++)
		{
			bw.write("abcd"+x);
			bw.newLine();
			bw.flush();
		}
		

		bw.close();
		*/
		FileReader fr =new FileReader("bw.txt");
		BufferedReader br = new BufferedReader(fr);
		String s;
		while((s=br.readLine())!=null)
		{
			System.out.println(s);
		}
		br.close();
	}

}
