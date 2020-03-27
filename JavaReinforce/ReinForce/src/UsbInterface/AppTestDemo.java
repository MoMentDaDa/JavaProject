package UsbInterface;

public class AppTestDemo {

	public static void main(String[] args) {
		// 创建主板对象
		Motherboard m = new Motherboard();
		// 创建鼠标对象
		MouseDemo s = new MouseDemo();
		m.insert(s);// 将鼠标插入主板
		s.saveData1();
		// m.insert(k);由于方法只能插入Mouse类型的对象，所以当创建一个键盘对象时，再接入主板便会类型报错
		// 创建键盘对象
		KeyBoardDemo k = new KeyBoardDemo();
		m.insert(k);
		k.dowork();
		System.out.println("-----------------------");
//使用多态方式将外设插入主板，并实现通信
		m.install("鼠标", s);
		m.install("键盘", k);
		m.dowork();
		//卸载鼠标
		m.uninstall("鼠标");
		System.out.println("--------------");
		m.dowork();

		System.out.println("--------------");
//使用内名内部类实现一次性外设的安装和卸载
		m.install("打印机", new Usb() {
			public void saveData() {
				System.out.println("这是打印机");

			}
		});
		m.dowork();
	}

}
