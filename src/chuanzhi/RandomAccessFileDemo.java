package chuanzhi;

import java.io.*;

public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException
	{
		//writeFile();
		//writeData();
		readData();
	}
	public static void writeFile() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");
		raf.write("李四".getBytes());
		raf.writeInt(97);
		raf.write("王五".getBytes());
		raf.writeInt(98);
		raf.seek(10*3);
		raf.write("周期".getBytes());
		raf.writeInt(100);
	}
	public static void readFile() throws IOException
	{
		
	}
	
	public static void writeData() throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
		dos.writeInt(12);
		dos.writeBoolean(true);
		dos.writeDouble(1234.567);
		dos.close();
	}
	public static void readData() throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
		int num =dis.readInt();
		Boolean b = dis.readBoolean();
		double d = dis.readDouble();
		System.out.println("num="+num);
		System.out.println("b="+b);
		System.out.println("d="+d);
		
	}

		

}
