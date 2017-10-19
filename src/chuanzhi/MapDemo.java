package chuanzhi;
import java.util.*;
public class MapDemo {
	public static void main(String[] args)
	{
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("01", "zhangsan1");
		map.put("02", "zhangsan2");
		map.put("04", "zhangsan4");
		map.put("03", "zhangsan3");
     	//map.clear();
	    //map.remove("02");
		
		//System.out.println(map.containsKey("01"));
		//System.out.println(map.containsValue("zhangsan3"));
		//System.out.println(map);
		//System.out.println(map.isEmpty());
		//System.out.println(map.get("09"));
		//System.out.println(map.size());
		//System.out.println(map.values());
		/*
		Set<String> KeySet=map.keySet();
		Iterator<String> it =KeySet.iterator();
		while (it.hasNext())
		{
			String key = it.next();
			String value = map.get(key);
			System.out.println("key:"+key+"..."+"value:"+value);
			
		}
		*/
		Set<Map.Entry<String, String>> EntrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> it = EntrySet.iterator();
		while (it.hasNext())
		{
			Map.Entry<String, String> me =it.next();
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key+":"+value);
		}
		
	}

}
