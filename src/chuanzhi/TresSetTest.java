package chuanzhi;


import java.util.*;

public class TresSetTest {
	public static void main(String[] args)
	{
		TreeSet ts = new TreeSet(new StringLengthCompare());
		ts.add("abc");
		ts.add("bcgt");
		ts.add("bacgh");
		ts.add("abcgh");
		
		ts.add("cdomplm");
		
		Iterator it = ts.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
	}

}

class StringLengthCompare implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		String s1=(String)o1;
		String s2=(String)o2;
		int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
		if (num == 0)
				return s1.compareTo(s2);
		return num;
		
	}
}