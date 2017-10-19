package chuanzhi;
import java.io.*;

public class CopyTextByBuffer {
	public static void main(String[] args)
	{
		BufferedReader br =null;
		BufferedWriter bw =null;
		
		try
		{
			br = new BufferedReader(new FileReader("/Users/yanmk/Documents/workspace/chuanzhi/src/chuanzhi/FIleWriterDemo.java"));
			bw = new BufferedWriter(new FileWriter("/Users/yanmk/Documents/workspace/chuanzhi/src/chuanzhi/FIleWriterDemo.txt"));
			
			String s=null;
			while((s=br.readLine())!=null)
			{
				bw.write(s);
				bw.newLine();
				bw.flush();
			}
		}
		catch(IOException e)
		{
			throw new RuntimeException("读写失败");
		}
		finally
		{
			try
			{
				if(br!=null)
					br.close();
			}
			catch(IOException e)
			{
				throw new RuntimeException("读取关闭失败");
			}
			
			try
			{
				if(bw!=null)
					bw.close();
			}
			catch(IOException e)
			{
				throw new RuntimeException("写入关闭失败");
			}
		}
	}

}
