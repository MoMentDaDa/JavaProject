package UsbInterface2;

import java.io.InputStream;
import java.util.Map.Entry;

import UsbInterface.Usb;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Motherboard {
	private static Map<String, Usb2> m = new HashMap<String, Usb2>();
	static {
		Properties p = new Properties();
		try {
			// 先获得当前线程类文件，再从ClassPath根路径加载Propertise文件
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("install.properties");
			//读取properties文件，创建USB2对象
			p.load(in);
			Set<Entry<Object, Object>> en = p.entrySet();
			for (Entry<Object, Object> entry : en) {
				String className = entry.getValue().toString();
				Usb2 usbObject = (Usb2) Class.forName(className).newInstance();
				m.put(entry.getKey().toString(), usbObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dowork() {
		for (Usb2 usb : m.values()) {
			usb.saveData();
		}
	}
}
