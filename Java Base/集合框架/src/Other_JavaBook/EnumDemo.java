package Other_JavaBook;

import java.util.EnumMap;
import java.util.Map.Entry;
import java.util.*;

public class EnumDemo {
	enum Gender {// 定义Gender内部类
		Female("女性"), Male("男性");
		private String description;

		private Gender(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}

	enum Color {// 颜色类枚举类
		Red, Blue, Yellow, Green
	}

	public static void main(String[] args) {
		// 遍历所有Gender类的常量
		for (Gender g : Gender.values())
			System.out.println(g.name() + " " + g.getDescription());
		Gender g = Gender.valueOf("Female");
		System.out.println(g.getDescription());
		System.out.println("------------------");

		// EnumSet的使用
		EnumSet<Color> colorSet = EnumSet.allOf(Color.class);
		for (Color c : colorSet)
			System.out.println(c);
		System.out.println("------------------");

		// EnumMap的使用
		EnumMap<Color, String> colorMap = new EnumMap<Color, String>(Color.class);
		colorMap.put(Color.Red, "红色");
		colorMap.put(Color.Blue, "蓝色");
		colorMap.put(Color.Yellow, "黄色");
		colorMap.put(Color.Green, "绿色");
		Set<Map.Entry<Color, String>> set = colorMap.entrySet();
		for (Map.Entry entry : set)
			System.out.println(entry.getKey() + ":" + entry.getValue());
	}
}
