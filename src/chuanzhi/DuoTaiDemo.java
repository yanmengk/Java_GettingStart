package chuanzhi;

public class DuoTaiDemo 
{
	public static void main(String[] args)
	{
		function(new Cat());
		function(new Dog());	
	}
	
	public static void function(Animal a)
	{
		a.eat();
		
		if (a instanceof Cat)
		{
			Cat c = (Cat)a;
			c.catchMouse();
		}
		else if (a instanceof Dog)
		{
			Dog d = (Dog)a;
			d.kanJia();
		}

	}
	

}

abstract class Animal
{
	public abstract void eat();
}

class Cat extends Animal
{
	public void eat()
	{
		System.out.println("吃鱼");
	}
	public void catchMouse()
	{
		System.out.println("抓老鼠");
	}
	
}

class Dog extends Animal
{
	public void eat()
	{
		System.out.println("吃骨头");
	}
	public void kanJia()
	{
		System.out.println("看家");
	}
}

class Pig extends Animal
{
	public void eat()
	{
		System.out.println("吃饲料");
	}
	public void gongDi()
	{
		System.out.println("拱地");
	}
	
}