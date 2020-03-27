package Other_JavaBook;

import java.util.EnumMap;
import java.util.Map.Entry;
import java.util.*;

public class EnumDemo {
	enum Gender {// ����Gender�ڲ���
		Female("Ů��"), Male("����");
		private String description;

		private Gender(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}

	enum Color {// ��ɫ��ö����
		Red, Blue, Yellow, Green
	}

	public static void main(String[] args) {
		// ��������Gender��ĳ���
		for (Gender g : Gender.values())
			System.out.println(g.name() + " " + g.getDescription());
		Gender g = Gender.valueOf("Female");
		System.out.println(g.getDescription());
		System.out.println("------------------");

		// EnumSet��ʹ��
		EnumSet<Color> colorSet = EnumSet.allOf(Color.class);
		for (Color c : colorSet)
			System.out.println(c);
		System.out.println("------------------");

		// EnumMap��ʹ��
		EnumMap<Color, String> colorMap = new EnumMap<Color, String>(Color.class);
		colorMap.put(Color.Red, "��ɫ");
		colorMap.put(Color.Blue, "��ɫ");
		colorMap.put(Color.Yellow, "��ɫ");
		colorMap.put(Color.Green, "��ɫ");
		Set<Map.Entry<Color, String>> set = colorMap.entrySet();
		for (Map.Entry entry : set)
			System.out.println(entry.getKey() + ":" + entry.getValue());
	}
}
