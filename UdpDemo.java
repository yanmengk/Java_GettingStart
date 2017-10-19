import java.net.*;
import java.io.*;

class UdpSend
{
	public static void main(String[] args) throws Exception
	{
		//1.创建UDP服务，通过DatagramSocke对象
		DatagramSocket ds=new DatagramSocket(8888);
		//2.确定数据，并封装成数据包DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
		//byte[] buf="udp hahah wolaile".getBytes();
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=bufr.readLine())!=null)
		{
			if("886".equals(line))
				break;
			byte[] buf=line.getBytes();
			DatagramPacket dp=new DatagramPacket
					(buf,buf.length,InetAddress.getByName("172.28.30.223"),10010);
			//3.通过socket服务将已有的数据包发送出去，send方法
			ds.send(dp);
			
		}
		
		
		
		
		//4.关闭资源
		ds.close();
	}
}
class UdpReceive
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket ds=new DatagramSocket(10010);
		while(true)
		{
			byte[] buf = new byte[1024];
			DatagramPacket dp=new DatagramPacket(buf,buf.length);
			
			ds.receive(dp);
			//通过数据包的方法获取其中的数据
			String ip=dp.getAddress().getHostAddress();
			String data=new String(dp.getData(),0,dp.getLength());
			int port =dp.getPort();
			//打印到控制台
			System.out.println(ip+"::"+data+"::"+port);
			
		}
		//ds.close();
		
	}
}
