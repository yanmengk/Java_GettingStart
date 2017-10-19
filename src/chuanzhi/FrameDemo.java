package chuanzhi;
import java.awt.*;
import java.awt.event.*;

public class FrameDemo {
	public static void main(String[] args)
	{
		new MyFrameDemo();
	}
	
	

}
class MyFrameDemo
{
	private Frame f;
	private Button but;
	private TextField tf;
	MyFrameDemo()
	{
		init();
	}
	private void init()
	{
		f=new Frame("my frame demo");
		f.setBounds(300,600,800,600);
		f.setLayout(new FlowLayout());
		//tf.setColumns(20);
		but=new Button("my button");
		tf=new TextField(20);
		f.add(but);
		f.add(tf);
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
/*		but.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("button well done!");
				System.exit(0);
			}
				});*/
		
/*		but.addMouseListener(new MouseAdapter()
				{
			private int Entercount=1;
			private int Clickcount=1;
			public void mouseEntered(MouseEvent e)
			{
				
				System.out.println("进入button"+Entercount++);
			}
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==2)
					System.out.println("点击button"+Clickcount++);
			}
				});*/
/*		but.addKeyListener(new KeyAdapter()
				{
			public void keyPressed(KeyEvent e)
			{
				if(e.isControlDown()&&e.getKeyCode()==e.VK_ENTER)
					System.exit(0);
				//System.out.println(e.getKeyChar()+"..."+e.getKeyCode());
				//System.out.println(e.getKeyText(e.getKeyCode())+"..."+e.getKeyCode());
			}
				});*/
		tf.addKeyListener(new KeyAdapter()
				{
					
					public void  keyTyped(KeyEvent e)//public void  keyPressed(KeyEvent e)
					{
						int code =e.getKeyCode();
						//if((code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9))
				/*		if(code>=KeyEvent.VK_0 &&code<=KeyEvent.VK_9)
							return;
						else
						{ 
							e.consume();
							System.out.println("输入不合法");
							
					
						}*/
						if (!Character.isDigit(e.getKeyChar())) 
						{//不是则取消
							e.consume();
							System.out.println("输入不合法");
						}
				
					}
				});
		
	
	}
	
}
