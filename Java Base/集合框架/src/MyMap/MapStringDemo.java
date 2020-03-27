package MyMap;

import java.nio.charset.Charset;
import java.util.*;


public class MapStringDemo {
//利用Map特点实现字符串个数的计算
	public static void main(String[] args) {
		String sb="agjlakglddaafdkjnvafjwfa";
		char[] ch=sb.toCharArray();
		Map<Character,Integer> map=new HashMap<>();
		for(char c:ch) {
			if(map.containsKey(c)){
				Integer a=map.get(c);
				++a;
				map.put(c, a);
			}else {
				map.put(c, 1);
			}
			
		}
		System.out.println(map);

	}

}
