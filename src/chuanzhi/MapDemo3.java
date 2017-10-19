package chuanzhi;

import java.util.*;

public class MapDemo3 {
	public static void main(String[] args)
	{
		HashMap<String,List> czbk = new HashMap<String,List>();
		List<Student7> yure = new ArrayList<Student7>();
		List<Student7> jiuye = new ArrayList<Student7>();
		czbk.put("yureban",yure);
		czbk.put("jiuyeban",jiuye);
		
		
		yure.add(new Student7("01","zhangsan"));
		yure.add(new Student7("02","zhaowu"));
		
		jiuye.add(new Student7("02","wangliu"));
		jiuye.add(new Student7("01","lisi"));
		
		Set<String> keySet=czbk.keySet();
		Iterator<String> it =keySet.iterator(); 
		while(it.hasNext())
		{
			String s =it.next();
			System.out.println(s);
			List<Student7> stu =czbk.get(s);
			getContent(stu); 
		}
	}
	public static void getContent(List<Student7> list)
	{
		
		Iterator<Student7> it =list.iterator();
		while(it.hasNext())
		{
			Student7 s= it.next();
		
			System.out.println(s);
		}
		
		
	}

}

class Student7
{
	private String id;
	private String name;
	Student7(String id,String name)
	{
		this.id=id;
		this.name=name;
	}
	public String getID()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String toString()
	{
		return id+":"+name;
	}
}