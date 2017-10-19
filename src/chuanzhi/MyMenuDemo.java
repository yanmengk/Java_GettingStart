package chuanzhi;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyMenuDemo {
	public static void main(String[] args)
	{
		new MyMenu();
	}

}
class MyMenu
{
	private Frame f;
	private MenuBar mb;
	private Menu m;
	private TextArea ta;
	private MenuItem mi1;
	private MenuItem mi2;
	private MenuItem mi3;
	private FileDialog fd1;
	private File file;

	MyMenu()
	{
		init();
	}
	private void init()
	{
		f=new Frame("my window");		
		f.setBounds(100,300,800,500);
		//f.setLayout(new FlowLayout());
		ta=new TextArea();
		mb=new MenuBar();
		m=new Menu("文件");
		mi1=new MenuItem("打开");
		mi2=new MenuItem("保存");
		mi3=new MenuItem("退出");
		
		fd1=new FileDialog(f,"我要打开",FileDialog.LOAD);
		
		


		
		f.add(ta);
		mb.add(m);
	
		m.add(mi1);
		m.add(mi2);
		m.add(mi3);
		f.setMenuBar(mb);	
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
		
		mi1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				//System.exit(0);
				fd1.setVisible(true);
				String dirPath=fd1.getDirectory();
				String fileName=fd1.getFile();
				if(dirPath==null||fileName==null)
					return;
				ta.setText("");
				file = new File(dirPath,fileName);
				
				try
				{
					BufferedReader bufr= new BufferedReader(new FileReader(file));
					String line=null;
					while((line=bufr.readLine())!=null)
					{
						ta.append(line+"\n");
					}
					bufr.close();
						
				}
				catch(Exception exc)
				{
					throw new RuntimeException("读取失败");
				}
			}
		});
		
		mi2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(file==null)
						{
							fd1.setVisible(true);
							String dirPath=fd1.getDirectory();
							String fileName=fd1.getFile();
							
							if(dirPath==null||fileName==null)
								return;
							//ta.setText("");
							file = new File(dirPath,fileName);
						}
						
						
						try
						{
							BufferedWriter bufw= new BufferedWriter(new FileWriter(file));
							//String line=null;
							String text=ta.getText();
							bufw.write(text);
						
							bufw.close();
								
						}
						catch(Exception exc)
						{
							throw new RuntimeException("写入失败");
						}
					}
						
					
				});
		
		
		mi3.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
	}
	
	
}