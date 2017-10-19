package chuanzhi;

import java.io.*;

//复制图片（字节流）
public class CopyPic {
	public static void main(String[] args)
	{
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try
		{
			fos = new FileOutputStream("/Users/yanmk/Documents/workspace/chuanzhi/gg.png");
			fis = new FileInputStream("/Users/yanmk/Documents/workspace/chuanzhi/1.png");
			
			byte[] buf = new byte[1024];
			int len=0;
			while((len=fis.read(buf))!=-1)
			{
				fos.write(buf,0,len);
			}
		}
		catch(IOException e)
		{
			throw new RuntimeException("复制图片失败");
		}
		finally
		{
			try
			{
				if(fis!=null)
					fis.close();
			}
			catch(IOException e)
			{
				throw new RuntimeException("读取关闭失败");
			}
			try
			{
				if(fos!=null)
					fos.close();
			}
			catch(IOException e)
			{
				throw new RuntimeException("写入关闭失败");
			}
			
		}
		
	}

}
