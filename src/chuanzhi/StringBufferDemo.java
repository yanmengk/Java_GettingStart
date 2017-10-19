package chuanzhi;

public class StringBufferDemo {
		public static void main(String[] args)
		{
			StringBuffer sb = new StringBuffer();
			//StringBuffer sb = new StringBuffer(“abc”);
			sb.append("abc").append(true);
			sb.insert(1, "kk");
			//System.out.println(sb);
			Boolean b = Boolean.parseBoolean("rUE");
			//System.out.println(b);
			
			System.out.println(Integer.toHexString(16));
			int x= Integer.parseInt("110",2);
			System.out.println(x); 
		}

}

