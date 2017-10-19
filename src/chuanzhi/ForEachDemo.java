package chuanzhi;
import java.util.*;
public class ForEachDemo {
	public static void main(String[] args)
	{
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("a1");
		al.add("b2");
		al.add("c3");
		
		for(String s: al)
		{
			System.out.println(s);
		}
		
	}

}
