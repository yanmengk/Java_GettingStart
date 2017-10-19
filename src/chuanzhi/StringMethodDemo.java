package chuanzhi;

public class StringMethodDemo {
	public static void main(String[] args)
	{
		StringMethod sm= new StringMethod();
		//sm.method_get();
		//sm.method_trans();
		//sm.method_split();
		sm.method_sub();
	}
	

}
class StringMethod
{
	public void method_get()
	{
		String s1="abcdefgabhijk";
		System.out.println(s1.length());	
		System.out.println(s1.charAt(4));
		System.out.println(s1.indexOf("a",3));
		System.out.println(s1.indexOf("a"));
		System.out.println(s1.indexOf("cd"));
		System.out.println(s1.indexOf("ab",3));
		System.out.println(s1.lastIndexOf("cd"));
	}
	
	public  void method_is()
	{
		String s2="gabhijkmnb";
		String s3="gabhijkmnB";
		System.out.println(s2.contains("hij"));	
		System.out.println(s2.isEmpty());	
		System.out.println(s2.startsWith("g"));	
		System.out.println(s2.endsWith("mb"));	
		//System.out.println(s2.equals(s3));
		System.out.println(s2.equalsIgnoreCase(s3));
	}
	public void method_trans()
	{
		char[] arr={'a','b','c','d','e'};
		String str=new String(arr,1,3);
		//System.out.println(str);
		String s2="gabhi";
		char[] arr2=s2.toCharArray();
		for(int i=0;i<arr2.length;i++)
		{
			System.out.println(arr2[i]);
		}
		
	}
	public void method_split()
	{
		String s="zhangsan,lisi,wangwu";
		String[] arr=s.split(",");
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	public void method_sub()
	{
		String s="abcdef";
		System.out.println(s.substring(0, s.length()));

	}

}