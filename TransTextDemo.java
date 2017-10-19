import java.io.*;
import java.net.*;

/*
* 客户端输入字母数据，发送给服务端，
* 服务端收到后显示在控制台，并将该数据转成大写返回给客户端
* 直到客户端输入over.转换结束.
*
* 创建一个英文大写转换服务器.

* 分析:
* 有客户端和服务端,使用tcp传输
*/

/*
//客户端
1.创建客户端的socket服务，指定目的主机和端口，用到Socket();
2.为了发送数据，获取socket流中的输出流

*/
class TcpClient2
{
	public static void main(String [] args) throws Exception
	{
		Socket s=new Socket("172.28.30.223",10188);

		//键盘输入流

		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		//Socket流的输出流，将流输出到服务器端
		//BufferedWriter bufOut=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

		PrintWriter bufOut=new PrintWriter(s.getOutputStream(),true);

		//Socket流的输入流，将流返回到客户端，读取的是大写信息
		BufferedReader bufrIn =new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line=null;

		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break; 
			//bufOut.write(line);
			//bufOut.newLine();
			//bufOut.flush();
			bufOut.println(line);

			String str=bufrIn.readLine();
			System.out.println("server:"+str);

		}






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

class TcpServer2
{
	public static void main(String [] args) throws Exception
	{
		ServerSocket ss= new ServerSocket(10188);

		Socket s=ss.accept();
		String ip =s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected"); 

		//Socket流的输入流，输入到服务器端
		BufferedReader bufrIn=new BufferedReader(new InputStreamReader(s.getInputStream()));

		//BufferedWriter bufOut=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter bufOut=new PrintWriter(s.getOutputStream(),true);



		String line =null;
		while((line=bufrIn.readLine())!=null)
		{
			System.out.println(line);
			//bufOut.write(line.toUpperCase());
			//bufOut.newLine();
			//bufOut.flush();
			bufOut.println(line.toUpperCase());
		}
		s.close();
		ss.close();




		
		
		
	}
}
