import java.net.*;
import java.io.*;

class UserThread implements Runnable
{
	private Socket s;
	UserThread(Socket s)
	{
		this.s=s;
	}
	public void run()
	{
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected");
		try
		{
			for(int x=0;x<3;x++)
			{

				BufferedReader bufIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
				String name =bufIn.readLine();

				BufferedReader bufr=new BufferedReader(new FileReader("users.txt"));

				PrintWriter out =new PrintWriter(s.getOutputStream(),true);
				boolean flag =false;
				String line =null;
				while((line=bufr.readLine())!=null)
				{
					if(line.equals(name))
					{
						flag=true;
						break;
					}
				}

				if(flag)
				{
					System.out.println(name+",已登录");
					out.println(name+"欢迎光临");
					break;
				}
				else 
				{
					System.out.println(name+",用户名不存在");
					out.println(name+"登录失败");
				}
				if(name==null)
					break;

			}
			//bufr.close();
			//s.close();

		}
		catch(Exception e)
		{
			throw new RuntimeException(ip+"校验失败！");
		}


		
	}

}

class LoginClient
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("172.28.12.236",10097);

		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		for(int x=0;x<3;x++)
		{
			String line =bufr.readLine();
			//if(line==null)
				//break;
			out.println(line);

			String info=bufIn.readLine();
			System.out.println("info:"+info);

			if(info.contains("欢迎"))
				break;

		}

		bufr.close();
		s.close();
		
		
	}
}
class LoginServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(10097);

		
		while(true)
		{
			Socket s = ss.accept();
			new Thread(new UserThread(s)).start();




		}

	


	}
}
