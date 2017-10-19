package chuanzhi;
import java.util.*;
/*任务：
 * 学生Student,地址String
 * 学生属性：姓名，年龄
 * 注意:姓名和年龄相同的视为同一个学生，保证学生的唯一性。
 * 每一个学生都有对应的归属地
 * 
 * 思路：
 * 1.描述学生
 * 2.定义Map容器，将学生作为键，地址作为值，存入
 * 3.获取Map集合中的元素
 */

public class TreeSetTest1 {
	public static void main(String[] args)
	{
		HashMap<Student8,String> hs = new HashMap<Student8,String>();
		//hs.put(new Student8("lisi1",21), "beijing");
		hs.put(new Student8("lisi1",21), "qingdao");
		hs.put(new Student8("lisi2",22), "shanghai");
		hs.put(new Student8("lisi3",23), "nanjing");
		hs.put(new Student8("lisi4",24), "tianjin");
		//hs.put(new Student8("lisi5",19), "zhengzhou");
		
		//获取元素的第一种方法：
		Set<Student8> keySet =hs.keySet();
		Iterator<Student8> iter = keySet.iterator();
		while(iter.hasNext())
		{
			Student8 s = iter.next();
			System.out.println(s+"..."+hs.get(s));
		}
		
		
		//获取元素的第二种方法：
		/*
		Set<Map.Entry<Student8, String>> entrySet = hs.entrySet();
		
		Iterator<Map.Entry<Student8, String>> it =entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry<Student8, String> me = it.next();
			System.out.println("key:"+me.getKey()+"...."+"value:"+me.getValue());
			
		}
		*/
		
	}

}

class Student8 implements Comparable<Student8> 
{
	private String name;
	private int age;
	
	Student8(String name,int age)
	{
		this.name= name;
		this.age = age;
	}
	
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public int hashCode()
	{
		return name.hashCode()+age*39;
	}
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Student8))
			throw new ClassCastException("类型不匹配");
		Student8 s = (Student8)obj;
		

		return this.name.equals(s.name) && this.age==s.age;
	}

	public int compareTo(Student8 s) {
		
		int num =new Integer(this.age).compareTo(new Integer(s.age));
		if (num==0)
			return this.name.compareTo(s.name);
		return num;
	}

	public String toString()
	{
		return name+":"+age;
	}
	
}