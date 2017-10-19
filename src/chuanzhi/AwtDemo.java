package chuanzhi;
import java.awt.*;
import java.awt.event.*;
public class AwtDemo {
	public static void main(String[] args)
	{
		Frame f=new Frame("my awt demo");
		Button b= new Button("我是一个按钮");
		f.add(b);
		
		
		f.setSize(600,400);
		f.setLayout(new FlowLayout());
		f.setLocation(300,300);
		
		f.addWindowListener(new WindowAdapter()
				{
			public void windowClosing(WindowEvent e)
			{
				System.out.println("我关");
				System.exit(0);
			}
			public void windowOpened(WindowEvent e)
			{
				System.out.println("我被打开啦");
			}
			public void windowActivated(WindowEvent e)
			{
				System.out.println("我被激活啦hahaha");
			}
			
				});
		
		
		
		f.setVisible(true);
		System.out.println("hello world!");
	}

}
