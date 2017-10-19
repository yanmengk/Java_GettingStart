package chuanzhi;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;


public class MyIEByGUI {
	public static void main(String[] args) throws Exception
	{
		new MyWindow2();
	}

}

class MyWindow2 
{
	private Frame f;
	private TextField tf;	
	private Button but;
	private TextArea ta;
	
	//对话框设计的内容：对话框、“确定”按钮、label标签
	private Dialog d;
	private Button okbut;
	private Label l;
	
	MyWindow2()
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
		String url=tf.getText();  //   http://114.212.82.169:8080/myweb/1.html
		int index1=url.indexOf("//")+2;
		int index2=url.indexOf("/",index1);
		String str=url.substring(index1, index2);
		String arr[] =str.split(":");
		String ip=arr[0];
		int port=Integer.parseInt(arr[1]);
		String path=url.substring(index2);
		
		
		Socket s = new Socket(ip,port);
		
		//发送请求，指明需要请求什么内容
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		//out.println("GET /myweb/1.html HTTP/1.1");
		out.println("GET "+path+" HTTP/1.1");
		out.println("Accept: */*");
		out.println("Accept-Language: zh-CN");
		out.println("Host: 114.212.82.169:10111");
		out.println("Connection: closed");
		out.println();

		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line =null;
		while((line=bufr.readLine())!=null)
		{
			//System.out.println(line);
			ta.append(line+"\n");
		}
		s.close();
		

	}
	

	
}