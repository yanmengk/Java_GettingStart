package chuanzhi;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;


public class MyIEByGUI2 {
	public static void main(String[] args) throws Exception
	{
		new MyWindow3();
	}

}

class MyWindow3 
{
	private Frame f;
	private TextField tf;	
	private Button but;
	private TextArea ta;
	
	//对话框设计的内容：对话框、“确定”按钮、label标签
	private Dialog d;
	private Button okbut;
	private Label l;
	
	MyWindow3()
	{
		try
		{
			init();
		}
		catch(Exception e)
		{
			
		}
	
	}
	
	private void init() throws Exception
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
						try
						{
							showDir();
						}
						catch(Exception ex)
						{
							
						}
	
						
						
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
				{
					try
					{
						showDir();
						
					}
				    catch(Exception ex)
					{
				    	
					}
					
				}
			
					
			}
		});
	}
	private void showDir() throws Exception
	{
		ta.setText("");
		String urlname=tf.getText();  //   http://114.212.82.169:8080/myweb/1.html
		URL url =new URL(urlname);

		URLConnection con =url.openConnection();

		
		InputStream in =con.getInputStream();
		
		byte[] buf =new byte[1024];
		int len=in.read(buf);
		ta.setText(new String(buf,0,len));
	}
	

	
}