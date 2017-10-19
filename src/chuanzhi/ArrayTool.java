package chuanzhi;

/**
这是一个可以对数组进行操作的工具类，该类中提供了获取最值、进行排序、打印数组等功能。
@author yanmk
@version V1.0
*/

public class ArrayTool 
{
	/**
	空参数构造函数
	*/
	private ArrayTool(){}
	
	/**
	获取一个整形数组的最大值
	@param a 接收一个int类型的数组
	@return 返回一个该数组的最大值
	 */
	public static int getMax(int[] a)
	{
		int temp=a[0];
		for(int i=1;i<a.length;i++)
		{
			if (a[i]>temp)
				temp=a[i];
		}
		return temp;
	}

	/**
	获取一个整形数组的最小值
	@param a 接收一个int类型的数组
	@return 返回一个该数组的最小值
	 */
	public static int getMin(int[] a)
	{
		int temp=a[0];
		for(int i=1;i<a.length;i++)
		{
			if (a[i]<temp)
				temp=a[i];
		}
		return temp;
	}
	/**
	对数组元素进行选择排序
	@param arr 接收一个int类型的数组
	*/
	//对数组元素进行排序--选择排序
	public static void selectSort(int[] arr)
	{
		for (int x=0;x<arr.length-1;x++)
		{
			for (int y=x+1;y<arr.length;y++)
			{
				if (arr[x]>arr[y])
				{
					int temp=arr[x];
					arr[x]=arr[y];
					arr[y]=temp;
				}
			}
			
		}
	}
    /**
    对数组元素进行冒泡排序
     * @param arr 接收一个int类型的数组
     */
	//对数组元素进行排序--冒泡排序
	public static void bubbleSort(int[] arr)
	{
		for (int x=0;x<arr.length-1;x++)
		{
			for (int y=0;y<arr.length-x-1;y++)
			{
				if(arr[y]>arr[y+1])
				{
					/*
					int temp=arr[y];
					arr[y]=arr[y+1];
					arr[y+1]=temp;
					*/
					swap(arr,y,y+1);
				}
			}
		}
	}

	/**
	 * 
	 * @param arr 接收一个int类型的数组
	 * @param a  要置换的位置
	 * @param b  要置换的位置
	 */
	private static void swap(int[] arr,int a,int b)
	{
		int temp =arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}

	/**
	 * 对数组中的元素进行打印，打印格式如“[element1,element2,...]”
	 * @param a 接收一个int类型的数组
	 */
	public static void printArray(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			if (i<a.length-1)
				System.out.print(a[i]+",");
			else
				System.out.print(a[i]);
		}
		System.out.println();
	}
}
