package FileStreamPackage;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PropertiesTestDemo {
	public static void main(String[] args) {
		Properties p = System.getProperties();
		Set<Entry<Object, Object>> entrySet = p.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		System.out.println("------------------");
		String val = System.getProperty("user.dir");
		System.out.println(val);
	}
}
