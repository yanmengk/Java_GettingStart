package chuanzhi;
import java.io.*;
public class ObjectStreamDemo {
	public static void main(String[] args) throws Exception
	{
		//writeFile();
		readFile();
	}
	

	public static void writeFile() throws Exception
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persons.object"));
		
		oos.writeObject(new Persons("lisi",55));
		
		oos.close();
		
	}
	
	public static void readFile() throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persons.object"));
		
		Persons p=(Persons)ois.readObject();
		System.out.println(p);
		ois.close();
	}
	

}
class Persons implements Serializable
{
	String name;
	int age;
	Persons(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public String toString()
	{
		return name+":"+age;
	}
}
