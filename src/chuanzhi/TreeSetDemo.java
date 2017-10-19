package chuanzhi;
import java.util.*;

/*需求：
 * 往TreeSet集合中存储自定义对象学生
 * 想按照学生的年龄进行排序
 *   
 * （记住，排序时，当主要条件相同时，一定要判断一下次要条件）
 */

public class TreeSetDemo {
	public static void main(String[] args)
	{
		TreeSet  ts = new TreeSet(new MyCompare());
		ts.add(new Student0("lisi001",20));
		ts.add(new Student0("lisi001",30));
		ts.add(new Student0("lisi003",15));
		ts.add(new Student0("lisi002",20));
		ts.add(new Student0("lisi002",20));
		ts.add(new Student0("lisi009",12));
		
		Iterator it =ts.iterator();
		while(it.hasNext())
		{
			Student0 s =(Student0)it.next(); 
			System.out.println(s.getName()+"...."+s.getAge());
		}
	}

}

class Student0 implements Comparable //该接口强制让学生具有比较性
{
	private String name;
	private int age;
	Student0(String name,int age)
	{
		this.name = name;
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
	public int compareTo(Object obj)
	{
		if(!(obj instanceof Student0))
			throw new RuntimeException();
		Student0 st = (Student0)obj;
		if (this.age > st.age)
			return 1;
		if (this.age == st.age)
		{
			return this.name.compareTo(st.name);
		}
			
		return -1;

	}

}
//第二种排序方式：比较器
class MyCompare implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		Student0 s1 = (Student0)o1;
		Student0 s2 = (Student0)o2;
		int num= s1.getName().compareTo(s2.getName());
		if (num==0)
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		return num;
		
	}
}

