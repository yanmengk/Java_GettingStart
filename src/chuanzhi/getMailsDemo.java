package chuanzhi;
import java.io.*;
import java.net.*;
import java.util.regex.*;




public class getMailsDemo {
	public static void main(String[] args) throws Exception
	{
		getMails();
	}
	public static void getMails() throws Exception
	{
		URL url = new URL("http://114.212.84.126:8080/myweb/mail.html");
		
		URLConnection conn=url.openConnection();
		
		BufferedReader bufIn =new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String line =null;
		String reg="\\w+(\\.)*\\w*@\\w+(\\.\\w+)+";
		
		Pattern p =Pattern.compile(reg);
		
		while((line=bufIn.readLine())!=null)
		{
			Matcher m=p.matcher(line);
			while(m.find())
			{
				System.out.println(m.group());
			}
		}

		
		
	}


}

