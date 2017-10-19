import java.net.*;
import java.io.*;

class PicThread implements Runnable
{
	private Socket s;
	PicThread(Socket s)
	{
		this.s=s;
	}
	public void run()
	{
		int count=1;
		String ip=s.getInetAddress().getHostAddress();
		try
		{
			System.out.println(ip+"......connected");
			InputStream in = s.getInputStream();



			File file = new File(ip+".jpg");
			while(file.exists())
				file=new File(ip+"("+(count++)+")"+".jpg");


			FileOutputStream fos =new FileOutputStream(file);

			byte[] buf=new byte[1024];
			int len=0;
			while((len=in.read(buf))!=-1)
			{
				fos.write(buf,0,len);

			}

			OutputStream out =s.getOutputStream();
			out.write("上传图片成功！".getBytes());
			s.close();

			fos.close();

			}
			catch(Exception e)
			{
				throw new RuntimeException(ip+"上传失败！");

			}

	}

}

class TcpClient4
{
	public static void main(String[] args) throws Exception
	{

		if(args.length!=1)
		{
			System.out.println("请选择一个jpg格式的图片！");
			return;
		}
		File file = new File(args[0]);
		if(!file.getName().endsWith("jpg"))
		{
			System.out.println("图片格式只能用jpg");
			return;
		}
		if(!(file.exists()&&file.isFile()))
		{
			System.out.println("该内容要么存在，要么不是文件");
			return;

		}
		if(file.length()>=1024*1024*10)
		{
			System.out.println("内容过大！没安好心");
		}



		Socket s=new Socket("172.28.12.236",10808);

		FileInputStream fis = new FileInputStream(file);

		OutputStream out =s.getOutputStream();

		byte[] buf=new byte[1024];

		int len=0;
		while((len=fis.read(buf))!=-1)
		{
			out.write(buf,0,len);
		}
		s.shutdownOutput();


		byte[] bufIn=new byte[100];

		InputStream in = s.getInputStream();
		int len2=in.read(bufIn);

		System.out.println(new String(bufIn,0,len2));

		fis.close();
		s.close();

		
	}
}
class TcpServer4
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss=new ServerSocket(10808);

		while(true)
		{
			Socket s=ss.accept();

		  	new Thread(new PicThread(s)).start();
		}
	

		//ss.close();


	}
}
