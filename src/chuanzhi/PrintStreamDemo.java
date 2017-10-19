package chuanzhi;
import java.io.*;
public class PrintStreamDemo {
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter pw = new PrintWriter(new FileWriter("printstream.txt"),true);
		
		
		String line=null;
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			pw.println(line.toUpperCase());
			//pw.flush();
		}
		pw.close();
		bufr.close();
		
	}


}
