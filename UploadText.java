import java.net.*;
import java.io.*;

class TcpClient
{
	public static void main(String[] args) throws Exception
	{
		Socket s=new Socket("172.28.12.236",10077);

		BufferedReader bufr = new BufferedReader(new FileReader("TcpDemo.java"));

        //客户端的输出流
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		String line=null;
		while((line=bufr.readLine())!=null)
		{
			out.println(line);
		}
		s.shutdownOutput();//关闭客户端的输出流，相当于给流中加一个结束标记-1.

		//客户端的输入流，接收来自服务器的响应消息

		//PrintReader in = new PrintReader(s.getInputStream());
		BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str =in.readLine();
		System.out.println(str);

		bufr.close();
		s.close();
		
		
		
	}
}
class TcpServer
{
	public static void main(String[] args) throws Exception
	{
		
		ServerSocket ss=new ServerSocket(10077);
		Socket s=ss.accept();

		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected");

        
        //服务器的输入流，接收来自客户端的消息内容
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));


		//将文件写入到TcpDemo.txt
        PrintWriter pw = new PrintWriter(new FileWriter("TcpDemo.txt"),true);
		
		
		String line=null;
		while((line=in.readLine())!=null)
		{
			pw.println(line);
	
		}

		//服务器端的输出流，回送给客户端相应的信息。
		PrintWriter out= new PrintWriter(s.getOutputStream(),true);
		out.println("上传成功！");

        pw.close();
		s.close();
		ss.close();










	}
}
