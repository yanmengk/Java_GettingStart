package chuanzhi;
import java.util.*;


public class CollectionsDemo {
	public static void main(String[] args)
	{
		sortDemo();
	}
	public static void sortDemo()
	{
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("aaa");
		list.add("zz");
		list.add("kkkkk");
		list.add("qq");
		list.add("z");
		
		//Collections.sort(list);
		//System.out.println(list);
		
		Collections.sort(list,new StrLenComparator1());
		System.out.println(list);
		int index=Collections.binarySearch(list, "aaaa",new StrLenComparator1());
		System.out.println("index:"+index);
	    //System.out.println(list);
	}

}
class StrLenComparator1 implements Comparator<String>
{
	public int compare(String s1,String s2)
	{
		if(s1.length()>s2.length())
			return 1;
		if (s1.length()<s2.length())
			return -1;
		return s1.compareTo(s2);
			
	}


}
