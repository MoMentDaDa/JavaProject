package UsbInterface;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Motherboard {
	public void insert(MouseDemo w) {
//传统做法，便是有几个外设接入那就的覆写几个插入方法
		System.out.println("鼠标插入主板");
	}

	public void insert(KeyBoardDemo k) {
		System.out.println("键盘插入主板");

	}

//利用接口实现多态，即接口的统一性，可以不用覆写方法
	Map<String, Usb> m = new HashMap<String, Usb>();

//插入方法
	public void install(String name, Usb u) {
		m.put(name, u);
	}

//删除外设
	public void uninstall(String name) {
		m.remove(name);
		System.out.println(name + "被卸载");

	}

	// 创建方法实现外设的工作
	public void dowork() {
		for (Usb m : m.values()) {
			m.saveData();
		}

	}

}
