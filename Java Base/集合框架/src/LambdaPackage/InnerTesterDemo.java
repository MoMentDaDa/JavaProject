package LambdaPackage;

public class InnerTesterDemo {

	public static void main(String[] args) {
//��ʽһ��ʹ�������ڲ���
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Hello World");
			}
		}).start();
		
//��ʽ����ʹ��Lambada���ʽ
		new Thread(() -> System.out.println("Hello World")).start();
		
// ��ʽ����ʹ��Lambada���ʽ
		Runnable race = () -> System.out.println("Hello World");
		new Thread(race).start();

	}

}
