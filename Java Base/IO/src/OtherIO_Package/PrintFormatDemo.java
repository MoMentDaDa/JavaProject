package OtherIO_Package;
//Java��ʽ�����
public class PrintFormatDemo {

	public static void main(String[] args) {
		String name="��";
		int age=17;
		//��ͳ�������
		System.out.println("����:"+name+",���䣺"+age);
		String str="������"+name+",���䣺"+age;
		System.out.println(str);
			
		//��ʽ�������ʽ
		String format="����:%s,����:%d";
		Object[] data={"��",17};
		System.out.printf(format,data);
		System.out.println();
		//�򻯷�ʽ
		System.out.printf("����:%s,����:%d","wang",18);
		

	}

}
