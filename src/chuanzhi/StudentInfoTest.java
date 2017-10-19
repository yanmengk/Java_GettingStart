package chuanzhi;
import java.io.*;
import java.util.*;


/*
 * 有五个学生，每个学生有3门课的成绩，
 * 从键盘输入以上数据（包括姓名，3门课成绩），
 * 输入格式：如zhangsan,30,40,60计算出总成绩
 * 并把学生的信息和计算出的总分按从高到低的顺序存放在磁盘文件“stud.txt”中
 * 
 * 
 * 
 * 
 * 1.描述学生对象
 * 2.定义一个可操作学生对象的工具类
 * 
 * 思想：
 * 1.通过获取键盘录入一行数据，并将该行中的信息封装为学生对象
 * 2.因为学生有多个，所以就需要存储，使用到集合，因为要对学生总分进行排序，所以考虑使用TreeSet
 * 3.将集合中的信息写入到文件中。
 */
class StudentY implements Comparable<StudentY>
{
	private String name;
	private int ma,cn,en;
	private int sum;
	StudentY(String name,int ma,int cn,int en)
	{
		this.name=name;
		this.ma=ma;
		this.cn=cn;
		this.en=en;
		sum=ma+cn+en;
	}
	public String getName()
	{
		return name;
	}
	public int getSum()
	{
		return sum;
	}
	public String toString()
	{
		return "student["+name+", "+ma+", "+cn+", "+en+"]";
	}
	public int compareTo(StudentY s)
	{
		int num=new Integer(this.sum).compareTo(new Integer(s.sum));
		if (num==0)
			return this.name.compareTo(s.name);
		return num;
	}
	//为什么要写hashCode和equals
	public int hashCode()
	{
		return name.hashCode()+sum*78;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof StudentY))
			throw new ClassCastException("类型不匹配");
		StudentY s =(StudentY)obj;
		return this.name.equals(s.name) && this.sum==s.sum;
	}
}
class StudentInfoTool
{
	public static Set<StudentY> getStudents() throws Exception
	{
		return getStudents(null);
	}
	public static Set<StudentY> getStudents(Comparator<StudentY> cmp) throws Exception
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		Set<StudentY> stus;//即Set<StudentY> stus=null
		if (cmp==null)
			stus =new TreeSet<StudentY>();
		else
			stus=new TreeSet<StudentY>(cmp);
		
		String line=null;
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			String[] info =line.split(",");
			StudentY stu= new StudentY(info[0],Integer.parseInt(info[1]),
					Integer.parseInt(info[2]),Integer.parseInt(info[3]));
			stus.add(stu);
		}
		bufr.close();
		return stus;
	}
	public static void  write2File(Set<StudentY> stus) throws Exception
	{
		BufferedWriter bufw = new BufferedWriter(new FileWriter("stud.txt"));
		for(StudentY stu:stus)
		{
			bufw.write(stu.toString()+"\t");
			bufw.write(stu.getSum()+"");
			bufw.newLine();
			bufw.flush();
		}
		bufw.close();
	}
	 
}

public class StudentInfoTest {
	public static void main(String[] args) throws Exception
	{
		//Set<StudentY> stus=StudentInfoTool.getStudents();
		
		Comparator<StudentY> cmp=Collections.reverseOrder();
		Set<StudentY> stus=StudentInfoTool.getStudents(cmp);
		StudentInfoTool.write2File(stus);
	}

}
