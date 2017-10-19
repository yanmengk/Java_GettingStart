package chuanzhi;
import java.io.*;
import java.net.*;

public class ChatDemo 
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket ds_send=new DatagramSocket();
		DatagramSocket ds_rece=new DatagramSocket(10090);
		new Thread(new Send(ds_send)).start();
		new Thread(new Rece(ds_rece)).start();
	}

} 

class Send implements Runnable
{
	private DatagramSocket ds;
	Send(DatagramSocket ds)
	{
		this.ds=ds;

	}
	public void run()
	{
		try
		{
			BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
			String line=null;
			while((line=bufr.readLine())!=null)
			{
				if("886".equals(line))
					break;
				byte[] buf=line.getBytes();
				DatagramPacket dp =new DatagramPacket(buf,buf.length,InetAddress.getByName("172.28.30.223"),10090);
				ds.send(dp);
				
				
			}
			ds.close();
				
		}
		catch(Exception e)
		{
			throw new RuntimeException("发送端失败");
		}
	}

}

class Rece implements Runnable
{
	private DatagramSocket ds;
	Rece(DatagramSocket ds)
	{
		this.ds=ds;

	}
	public void run()
	{
		try
		{
			while(true)
			{
				byte[] buf=new byte[1024];
				DatagramPacket dp =new DatagramPacket(buf,buf.length);
				ds.receive(dp);
				
				String ip=dp.getAddress().getHostAddress();
				String data=new String(buf,0,dp.getLength());
				System.out.println(ip+"::"+data);
				
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException("接收端失败");
		}
	}
}
