package chuanzhi;
import java.util.*;

/*
 * 需求：对学生对象的年龄进行升序排序
 * 因为数据是以键值对的形式存在的，所以要使用可以排序的Map集合：TreeMap
 */
public class TreeSetTest2 {
	public static void main(String[] args)
	{
		TreeMap<Student8,String> tm = new TreeMap<Student8,String>(new MyNameComparator());
		tm.put(new Student8("lisi1",21), "qingdao");
		tm.put(new Student8("blisi4",24), "tianjin");
		tm.put(new Student8("lisi3",23), "nanjing");
		
		tm.put(new Student8("alisi2",22), "shanghai");
		
		
		Set<Map.Entry<Student8,String>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Student8,String>> it = entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry<Student8,String> me = it.next();
			System.out.println(me.getKey()+"......."+me.getValue());
		}
	}

}

class MyNameComparator implements Comparator<Student8>
{
	public int compare(Student8 s1,Student8 s2)
	{
		int num = s1.getName().compareTo(s2.getName());
		if (num==0)
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		return num;
	}
	
}

	
