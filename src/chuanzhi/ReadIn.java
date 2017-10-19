package chuanzhi;
import java.io.*;
public class ReadIn {
	public static void main(String[] args) throws IOException
	{
		//有点类似字符流中缓冲区技术中的readLine方法，一次读取一行，方法2将使用转换流实现
		//方法一
		/*
		InputStream in = System.in;
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int ch=in.read();
			if(ch=='\n')
			{
				String s=sb.toString();
				if ("over".equals(s))
					break;
				System.out.println(s.toUpperCase());
				sb.delete(0, sb.length());
			}
			else
				sb.append((char)ch);
		}
		*/
		//通过转换流实现上述功能
		//InputStream in = System.in;
		//InputStreamReader isr = new InputStreamReader(in);
		//BufferedReader br = new BufferedReader(isr);
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("out.txt")));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));
		
		String s=null;
		while((s=br.readLine())!=null)
		{
			if("over".equals(s))
				break;
			bw.write(s.toUpperCase());
			bw.newLine();
			bw.flush();
		}
		br.close();
	}

}
