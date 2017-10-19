package chuanzhi;
import java.util.*;
public class MapDemo2 {
	public static void main(String[] args)
	{
		HashMap<String,String> yure = new HashMap<String,String>();
		
		HashMap<String,String> jiuye = new HashMap<String,String>();
		
		
		HashMap<String,HashMap<String,String>> czbk = new HashMap<String,HashMap<String,String>>();
		czbk.put("yrban",yure);
		czbk.put("jyban",jiuye);
		
		
		yure.put("01","zhangsan");
		yure.put("02","lisi");
		jiuye.put("01","wangwu");
		jiuye.put("02","zhaoliu");
		
		Set<Map.Entry<String,HashMap<String,String>>> entrySet = czbk.entrySet();
		Iterator<Map.Entry<String,HashMap<String,String>>> it =entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry<String,HashMap<String,String>> me =it.next();
			String banji =me.getKey( );
			HashMap<String,String> content =me.getValue();
			System.out.println(banji);
			getContent(content); 
		}
		
		
		
		
	}
	public static void getContent(HashMap<String,String> hm)
	{
		Set<Map.Entry<String,String>> entrySet = hm.entrySet();
		Iterator<Map.Entry<String,String>> it =entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry<String,String> me = it.next();
			String number = me.getKey();
			String name = me.getValue();
			System.out.println(number+":"+name);
		}
		
		
	}

}
