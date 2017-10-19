import java.io.*;
import java.net.*;

/*
//客户端
1.创建客户端的socket服务，指定目的主机和端口，用到Socket();
2.为了发送数据，获取socket流中的输出流

*/
class TcpClient
{
	public static void main(String [] args) throws Exception
	{
		Socket s=new Socket("172.28.30.223",10070);
		
		OutputStream os=s.getOutputStream();
		os.write("服务器，你好呀".getBytes());

		//增加 接收来自服务器的消息
		InputStream is=s.getInputStream();
		byte[] buf =new byte[1024];
		int len=is.read(buf);
		System.out.println(new String(buf,0,len));



		s.close();




	}
}
/*
服务端：
1.建立服务端的socket服务，用到ServerSocket();并监听一个端口
2.获取连接过来客户端对象
  通过ServerSocket的accept方法，没有连接就会等，所以此方法为阻塞式
3.客户端发过来数据，那么服务端要使用对应的客户端对象，并获取该客户端对象的读取流来读取发过来的数据
并在控制台打印
4.关闭服务器端（可选）




*/

class TcpServer
{
	public static void main(String [] args) throws Exception
	{
		ServerSocket ss=new ServerSocket(10070);
		
		Socket s=ss.accept();
		
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected");
		
		InputStream is =s.getInputStream();
		byte[] buf =new byte[1024]; 
		int len=is.read(buf);
		
		String data=new String(buf,0,len);
		System.out.println(data);

		//增加 回发给客户端的消息
        Thread.sleep(5000);
		OutputStream os=s.getOutputStream();
		os.write("哥们收到，你也好".getBytes());


		
		s.close();
		ss.close();//可选
		
		
		
		
	}
}
