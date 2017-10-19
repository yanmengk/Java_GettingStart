package chuanzhi;
import java.util.regex.*;
import java.util.*;
/*
 * 用正则表达式判断：
 * QQ号只允许5-15位，并且都是数字，还有首位不能是0
 */
public class RegexDemo1 {
	public static void main(String[] args)
	{
		//checkQQ();
		//splitDemo("assertyytuioopln","(.)\\1");//按照叠词来切分
		
		//String str1="assertyytuiooooopln";
		//replaceAllDemo(str1,"(.)\\1+","$1"); //返回asertytuiopln
		//getDemo();
		//test_1();
		ipSort();
	}
	public static void checkQQ()
	{
		String qq="23475";
		String regex="[1-9][0-9]{4,14}";
		Boolean flag =qq.matches(regex);
		if(flag)
		{
			System.out.println(qq+"...is ok");
		}
		else
			System.out.println(qq+"...不合法");
		
	}
	public static void splitDemo(String str,String reg)
	{
		String[] arr=str.split(reg);
		for (String s:arr)
		{
			System.out.println(s);
		}
		
	}
	public static void replaceAllDemo(String str,String reg,String newStr)
	{
		String str1=str.replaceAll(reg, newStr);
		System.out.println(str1);
	}
	
	public static void getDemo()
	{
		String str ="ming tian jiu yao fang jia le, da jia!";
		String reg ="\\b[a-z]{4}\\b";
		Pattern p =Pattern.compile(reg);
		Matcher m=p.matcher(str);
		
		while(m.find())
		{
			System.out.println(m.group());
		}
		
	}
	public static void test_1()
	{
		String str="我我我...我..我要要..要....要学学学...学编编编..编编程....程程";
		
		str=str.replaceAll("\\.","");
		System.out.println(str);
		
		str=str.replaceAll("(.)\\1+","$1");
		System.out.println(str);
	}
	
	public static void ipSort()
	{
		String ip="127.0.0.1 2.2.2.2 114.212.83.171 255.114.0.9 1.1.2.2";
		ip=ip.replaceAll("(\\d+)", "00$1");
		//System.out.println(ip);
		ip=ip.replaceAll("0+(\\d{3})", "$1");
		//System.out.println(ip);
		String[] arr =ip.split(" ");

		
		TreeSet<String> ts=new TreeSet<String>();
		for(String s:arr)
		{
			ts.add(s);
		}
		for(String s:ts)
		{
			System.out.println(s.replaceAll("0*(\\d+)", "$1"));
		}
		
	}


}
