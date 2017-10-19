package chuanzhi;

public class DuoTaiDemo3 
{
	public static void main(String[] args)
	{
		MainBoard mb=new MainBoard();
		mb.run();
		mb.usePCI(new NetCard());
		mb.usePCI(new SoundCard());
	}

}

class MainBoard
{
	public void run()
	{
		System.out.println("MainBoard run");
	}
	public void usePCI(PCI p)
	{
		if (p!=null)
		{
		    p.open();
		    p.close();
		}
	}
} 

interface PCI
{
	public void open();
	public void close();

	
}
class NetCard implements PCI
{
	public void open()
	{
		System.out.println("NetCard open");
	}
	public void close()
	{
		System.out.println("NetCard close");
	} 
}
class SoundCard implements PCI
{
	public void open()
	{
		System.out.println("SoundCard open");
	}
	public void close()
	{
		System.out.println("SoundCard close");
	}
}