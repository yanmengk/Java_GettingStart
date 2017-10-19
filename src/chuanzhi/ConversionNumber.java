package chuanzhi;

//将十进制的数转换为二进制、八进制、十六进制
public class ConversionNumber {
	public static void main(String[] args)
	{
		//toBinary(8);
		//toHex_2(60);
		//toHex_2(60);
		toBin_2(6);
		//toHex_3(60);
		//toOctal(60);
	}
/*	
	//十进制转二进制
	public static void toBinary(int num)
	{
		StringBuffer sb=new StringBuffer();
		while(num!=0)
		{
			sb.append(num%2);
			num /=2;

		}
		System.out.print(sb.reverse());
		//System.out.print(sb);
	}
	
	//十进制转十六进制
	public static void toHex(int num)
	{
		
		StringBuffer sb= new StringBuffer();
		for (int x=0;x<8;x++)
		{
			int temp=num & 15;
			if (temp>9)
				sb.append((char)(temp-10+'A'));
			else
				sb.append(temp);
			num=num >>> 4;			
		}
		System.out.println(sb.reverse());
	}

	//查表法--十进制转十六进制 have Problem 
	public static void toHex_2(int num)
	{
		char[] chr = new char[]{'0','1','2','3',
				'4','5','6','7',
				'8','9','A','B',
				'C','D','E','F'};
		
		char[] arr=new char[8];
		int pos=arr.length;
		while (num!=0 )
		{
			int temp = num & 15;
			arr[--pos] = chr[temp];
			num = num >>> 4;
		}
		for (int x=pos;x<arr.length;x++)
		{
			System.out.print(arr[x]+",");
		}
	}

*/
//---------------------------------------------------------------优化后
	public static void conversion(int num,int base,int offset)
	{
		char[] chr = new char[]{'0','1','2','3',
				'4','5','6','7',
				'8','9','A','B',
				'C','D','E','F'};
		char[] arr=new char[32];
		
		int pos=arr.length;
		while (num!=0 )
		{
			int temp = num & base ;
			arr[--pos] = chr[temp];
			num = num >>> offset;
		}
		for (int x=pos;x<arr.length;x++)
		{
			System.out.print(arr[x]);
		}
	}
	
	public static void toBin_2(int num)
	{
		conversion(num,1,1);
	}
	public static void toHex_3(int num)
	{
		conversion(num,15,4);
	}
	public static void toOctal(int num)
	{
		conversion(num,7,3);
	}
	}

	 


