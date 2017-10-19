package chuanzhi;
import java.util.*;


/*练习：“xcvasdfxcvdfjahfjkahkjhk”获取该字符串中的字母及其出现的次数。
 * 希望打印结果为： a(1)c(2)......
 * 
 * 通过结果发现，每一个字母都有对应的次数。
 * 说明字母与次数之间存在映射关系。因此考虑使用Map集合。
 * 
 * 思路：
 * 1，将字符串转换成字符数组，因为要对每一个字母进行操作。
 * 2.定义一个Map集合。因为打印的字母有顺序，所以使用TreeSet集合。
 * 3.遍历字符数组：
 *      将每一个字母作为键去查Map集合
 *      如果返回为null，将该字母和1存入到Map集合中
 *      如果返回不为null，说明该字母已经在Map集合中存在并且有对应次数，
 *                      则将次数自增1，然后将该字母与自增后的次数存入到Map集合中，覆盖掉原来的键所对应的值
 * 4.将Map集合中的数据变成指定的字符串形式返回。
 */


public class MapTest {
	public static void main(String[] args)
	{
		String s=charCount("xcvasdfxcvdfjahfjkahkjhk");
		System.out.print(s);
	}
	
	public static String charCount(String str)
	{
		char[] chs = str.toCharArray();
		
		TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();
		
		int count=0;
		for(int x=0;x<chs.length;x++)
		{
			Integer value= tm.get(chs[x]);
			
			if(value==null)
				tm.put(chs[x],1);
			else
			{
				value++;
				tm.put(chs[x],value);
			}
			/*
			if(value!=null)
				count=value;
			count++;
			tm.put(chs[x], count);
			count=0;
			*/
		
			
		}
		
		//System.out.println(tm);
		
		StringBuilder sb = new StringBuilder();
		Set<Map.Entry<Character,Integer>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Character,Integer>> it = entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry<Character,Integer> me = it.next();
			Character key =me.getKey();
			Integer value = me.getValue();
			sb.append(key+"("+value+")");
			
			
		}
		
		
		
		return sb.toString();
	}

}
