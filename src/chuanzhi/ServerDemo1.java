package chuanzhi;
import java.io.*;
import java.net.*;

public class ServerDemo1 {
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(13001);
		
		Socket s =ss.accept();
		
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		
		
		InputStream is=s.getInputStream();
		byte[] buf =new byte[1024];
		int len=is.read(buf);
		System.out.print(new String(buf,0,len));
		
		
		PrintWriter out=new PrintWriter(s.getOutputStream(),true);
		out.println("客户端你好");
		
		s.close();

		ss.close();
	}

}
