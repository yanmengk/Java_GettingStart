package chuanzhi;
import java.io.*;
import java.net.*;

public class UrlConnectionDemo {
	public static void main(String[] args) throws Exception
	{
		URL url =new URL("http://114.212.82.169:8080/myweb/1.html");
		/*System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		System.out.println(url.getFile());
		System.out.println(url.getQuery());*/
		URLConnection con =url.openConnection();
		//System.out.println(con);
		
		InputStream in =con.getInputStream();
		
		byte[] buf =new byte[1024];
		int len=in.read(buf);
		System.out.println(new String(buf,0,len));
	}

	

}
