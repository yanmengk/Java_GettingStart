package chuanzhi;

import java.net.*;
public class IPDemo {
	public static void main(String[] args) throws Exception
	{
/*		InetAddress i =InetAddress.getLocalHost();
		System.out.println(i.toString());
		
		
		System.out.println(i.getHostName());
		System.out.println(i.getHostAddress());*/
		InetAddress ia =InetAddress.getByName("yanmk-Mac.local");
		//InetAddress ia =InetAddress.getByName("www.baidu.com");
		//InetAddress ia =InetAddress.getByName("iip.nju.edu.cn");
		//InetAddress ia2=InetAddress.getByName("172.28.173.201");
		
		//System.out.println(ia2);
		System.out.println(ia.getHostAddress());
		//System.out.println(ia.getHostName());
	} 
	
}
