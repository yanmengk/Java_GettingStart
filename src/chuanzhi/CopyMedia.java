package chuanzhi;
import java.io.*;
public class CopyMedia {
	public static void main(String[] args) throws IOException
	{
		long start =System.currentTimeMillis();
		copy_2();
		long end = System.currentTimeMillis();
		System.out.println("历时："+(end-start)+"毫秒");
	}
	
	//通过字节流的缓冲区完成复制
	public static void copy_1() throws IOException
	{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/Users/yanmk/Movies/视频/111.mp4"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/Users/yanmk/Movies/视频/ymk.mp4"));
		
		int len=0;
		while((len=bis.read())!=-1)
		{
			bos.write(len);
		}
		bis.close();
		bos.close();
	}
	public static void copy_2() throws IOException
	{
		MyBufferedInputStream bis = new MyBufferedInputStream(new FileInputStream("/Users/yanmk/Movies/视频/ymk.mp4"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/Users/yanmk/Movies/视频/ymk2.mp4"));
		int len=0;
		while((len=bis.myRead())!=-1)
		{
			bos.write(len);
		}
		bis.myClose();
		bos.close();
	}
	

}
class MyBufferedInputStream
{
	private InputStream in;
	private byte[] buf =new byte[1024];
	private int pos=0,count=0;
	
	MyBufferedInputStream(InputStream in)
	{
		this.in= in;
	}
	
	//一次读一个字节，从缓冲区（字节数组）中获取 
	public int myRead() throws IOException
	{
		if (count==0)
		{
			count=in.read(buf);
			if (count<0)
				return -1; 
			pos=0; 
			byte b = buf[pos];
			count--;
			pos++;	
			return b&0xff;
		}
		else if (count>0)
		{
			byte b = buf[pos];
			count--;
			pos++;		
			return b&0xff;
		}
		return -1;
		
		
	}
	
	public void myClose() throws IOException
	{
		in.close();
	}
	
	
	
	
	
	
	
	
	
}