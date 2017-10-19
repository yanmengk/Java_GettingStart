package chuanzhi;

import java.util.Arrays;

public class ArrayDemo {
	public static void main(String[] args)
	{
		//System.out.println(getResult(4));
		//print99();
		int[] arr = new int[]{1,2,4,5,7,9};
		//printArray(arr);
		//printSumArray(arr);
		//int m=getMax(arr);
		//System.out.print(m);
		//selectSort(arr);
		//bubbleSort(arr);
		//java自带的排序功能--直接调用
		//Arrays.sort(arr);
		//printArray(arr);
		//System.out.print(5/2);
		int key=40;
		int index=halfSearch_2(arr,key );
		System.out.print(index);
	}
	
	public static int getResult(int num)
	{
		return num*3+4;
	}
	
	public static void print99()
	{
		for (int x=1;x<=9;x++)
		{
			for (int y=1;y<=x;y++)
			{
				System.out.print(y+"*"+x+"="+y*x+"\t");
			}
			System.out.println();
		}
	}
	
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
	
	public static void printSumArray(int[] a)
	{
		int sum=0;
		for(int i=0;i<a.length;i++)
		{
			sum +=a[i];
		}
		System.out.println(sum);
	}
	
	public static int getMax(int[] a)
	{
		int temp=a[0];
		for(int i=1;i<a.length;i++)
		{
			if (a[i]<temp)
				temp=a[i];
		}
		return temp;
	}
	
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
	
	public static void swap(int[] arr,int a,int b)
	{
		int temp =arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	//对有序数组元素的折半查找--方法一
	public static int halfSearch(int[] arr,int key)
	{
		int min=0,max=arr.length-1,mid=(min+max)/2;
		while(key!=arr[mid])
		{
			if (key<arr[mid])
				max=mid-1;
			else if (key>arr[mid])
				min=mid+1;

		   if (min>max)
				return -1;
		   
			mid=(min+max)/2;

		}
		return mid;
	}
	
	//折半查找的第二种方法
	public static int halfSearch_2(int[] arr,int key)
	{
		int min=arr[0],max=arr.length-1,mid;
		while(min<=max)
		{
			mid=(min+max)/2;
			if (key<arr[mid])
				max=mid-1;
			else if (key>arr[mid])
				min=mid+1;
			else
				return mid;
		}
		return -1;
	}

}
