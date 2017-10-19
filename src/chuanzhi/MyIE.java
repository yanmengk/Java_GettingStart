package chuanzhi;
import java.io.*;
import java.net.*;

/*
 * 创建一个自己的IE浏览器，充当客户端，向Tomcat服务器发送请求，请求Tomcat上的内容。
 */

public class MyIE {
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("114.212.82.169",8080);
		
		//发送请求，指明需要请求什么内容
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		out.println("GET /myweb/1.html HTTP/1.1");
		out.println("Accept: */*");
		out.println("Accept-Language: zh-CN");
		out.println("Host: 114.212.82.169:10111");
		out.println("Connection: closed");
		out.println();

		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line =null;
		while((line=bufr.readLine())!=null)
		{
			System.out.println(line);
		}
		s.close();
		
	}
	
	
	

}
