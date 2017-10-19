package chuanzhi;
import java.io.*;

public class PipedStreamDemo {
	public static void main(String[] args) throws IOException
	{
		PipedInputStream input = new PipedInputStream();

		PipedOutputStream output = new PipedOutputStream();
		
		input.connect(output);
		
		new Thread(new Read(input)).start();

		new Thread(new Write(output)).start();
		
	}

}
class Read implements Runnable{
	private PipedInputStream in;
    Read(PipedInputStream in)
    {
           this.in = in;
    }

    public void run()
    {
    	try
    	{
    		byte[] buf = new byte[1024];
    		int len = in.read(buf);
    		String s = new String(buf,0,len);
    		System.out.println("s="+s);
    		in.close();
    	}
       catch (Exception e) 
       {
    	   throw new RuntimeException("读取管道流失败");
       }

    }

}

class Write implements Runnable
{
	private PipedOutputStream out;
	Write(PipedOutputStream out)
	{
		this.out = out;
    }
    public void run()
    {
        try 
        {
    	     Thread.sleep(5000);
    	     out.write("hi，管道来了！".getBytes());
    	} 
        catch (Exception e) 
        {
    	     throw new RuntimeException("管道输出流失败");
        }

    }

}
