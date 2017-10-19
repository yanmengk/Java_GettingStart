package chuanzhi;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyWindowDemo {
	public static void main(String[] args)
	{
		new MyWindow();
	}

}
class MyWindow
{
	private Frame f;
	private TextField tf;	
	private Button but;
	private TextArea ta;
	
	//对话框设计的内容：对话框、“确定”按钮、label标签
	private Dialog d;
	private Button okbut;
	private Label l;
	
	MyWindow()
	{
		init();
	}
	
	private void init()
	{
		f=new Frame("my window");		
		f.setBounds(100,300,800,500);
		f.setLayout(new FlowLayout());
		
		tf=new TextField(60);
		
		but=new Button("转到");
		
		ta=new TextArea(20,60);
		
		
		
		d=new Dialog(f,"提示信息：",true);
		okbut=new Button("确定");
		l=new Label();
		d.add(l);
		d.add(okbut);
		
		d.setBounds(200,100,50,60);
		d.setLayout(new FlowLayout());
		
		//d.setVisible(true);
		
		
		
		
		f.add(tf);
		f.add(but);
		f.add(ta);
		
		
		myEvent();
		
		
		f.setVisible(true);
		
		
		
		
		
		
	}
	private void myEvent()
	{
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
			
		});
		but.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						showDir();
	
						
						
					}
				
				}
				);
		okbut.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						d.setVisible(false);
					}
		});
		d.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				d.setVisible(false);
			}
			
		});
		tf.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					showDir();
			}
		});
	}
	private void showDir()
	{
		String dirpath=tf.getText();
		File dir = new File(dirpath);
		if(dir.exists() &&dir.isDirectory())
		{
			ta.setText("");
			String[] names=dir.list();
			for(String name:names)
			{
				ta.append(name+"\n");
			}
			
		}
		else
		{
			l.setText("您输入的信息："+dirpath+"有误，请更改！");
			d.setVisible(true);
		}
	}
	

	
}
