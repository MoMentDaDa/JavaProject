package wang.lifeCycle;

public class MyDataSource {
	public MyDataSource() {
		System.out.println("执行构造器");
	}

	public void open() {
		System.out.println("打开资源");
	}

	public void close() {
		System.out.println("释放资源");
	}

	public void doWork() {
		System.out.println("执行工作");
	}

}
