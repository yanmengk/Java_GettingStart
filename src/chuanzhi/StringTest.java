package chuanzhi;

 /*功能：
  * 操作一：去掉字符串两端的空格，不能用trim()方法
  * 操作二：对字符串内容进行反转
  * 操作三：获取字符串中某一子串出现的次数
 */
public class StringTest {
	public static void main(String[] args)
	{
		/*
		String s="   abd def  ";
		System.out.println("("+s+")");
		s=myTrim(s);
		System.out.println("("+s+")");
		*/
		
		/*
		String s="ab c d  efg";
		System.out.println("("+s+")");
		
		System.out.println("("+reverseString(s)+")");
		*/
		/*
		String s="abckkrfgkkekktykky";
		int count=getSubCount_2(s,"kk");
		System.out.println(count);
		*/
		
		String s1="abcwerthelloyuiodef";
		String s2="cvhellobnm";
		System.out.println(getMaxSubString(s1,s2));
	}
	
	//操作一：去掉字符串两端的空格，不能用trim()方法
	public static String myTrim(String str)
	{
		int start=0,end=str.length()-1;
		while(start<=end && str.charAt(start)==' ')
		{
			start++;
		}
		while(start<=end && str.charAt(end)==' ')
		{
			end--;
		}
		return str.substring(start, end+1);
	}
	
	//操作二：对字符串内容进行反转
	//思路：1.将字符串变成数组 2.对数组进行反转 3.再将数组变为字符串
	public static String  reverseString(String str,int start,int end)
	{
		char[] chr=str.toCharArray();
		reverse(chr,start,end);
		return new String(chr);		
	}
	public static String reverseString(String str)
	{
		return reverseString(str,0,str.length());
	}
		
	private static void reverse(char[] arr,int x,int y)
	{
		for(int start=x,end=y-1;start<end;start++,end--)
		{
			swap(arr,start,end);
		}	
	}
	
	private static void swap(char[] arr,int m,int n)
	{
		char temp=arr[m];
		arr[m]=arr[n];
		arr[n]=temp;
	}
	//操作三：获取字符串中某一子串出现的次数
	//方法1：
	public static int getSubCount(String s,String key)
	{
	    int count=0;
		int index;
		while((index=s.indexOf(key))!=-1)
		{
			s=s.substring(index+key.length());
			count++;
		}
		return count;
	}
	public static int getSubCount_2(String s,String key)
	{
	    int count = 0;
		int index = 0;
		while((index=s.indexOf(key,index))!=-1)
		{
			index=index+key.length();
			count++;
		}
		return count;
	}
	//操作四：获取两个字符串中最大相同子串。第一个动作：将短的那个串进行长度依次的子串打印。
	//"abcwerthelloyuiodef"
	//"cvhellobnm"
	//思路：1.将短的那个子串按照长度递减的方式获取到。
	//    2.将每获取到的子串去长串中判断是否包含，如果包含，则已经找到！
	
	public static String getMaxSubString(String s1,String s2)
	{
		for(int x=0;x<s2.length();x++)
		{
			for(int y=0,z=s2.length()-x;z!=s2.length()+1 ;y++,z++)
			{
				String temp = s2.substring(y, z);
				if (s1.contains(temp))
					return temp;
			}
		}
		return "";
	}

}
