package LambdaPackage;

public class InnerTesterDemo {

	public static void main(String[] args) {
//方式一：使用匿名内部类
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Hello World");
			}
		}).start();
		
//方式二：使用Lambada表达式
		new Thread(() -> System.out.println("Hello World")).start();
		
// 方式三：使用Lambada表达式
		Runnable race = () -> System.out.println("Hello World");
		new Thread(race).start();

	}

}
