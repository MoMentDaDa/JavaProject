package Class_Package;

import java.lang.reflect.Constructor;

class person {
	public person() {
		System.out.println("�޲���������");
	}

	public person(String name) {
		System.out.println("������" + name);
	}

	private person(String name, int age) {
		System.out.println("������" + name + age);
	}
}

public class CreatObjectDemo {

	public static void main(String[] args) throws Exception, Exception {
		// ��ȡ�ֽ����ļ�
		Class<person> clz = person.class;
		// ��ȡ������
		Constructor<person> con = clz.getConstructor();
		System.out.println(con);
		// ���ù�������newInstance�����������󣬲�����ʵ��
		con.newInstance();
		System.out.println("-----------------");
		// ����public person(String name)������
		con = clz.getConstructor(String.class);
		System.out.println(con);
		con.newInstance("����");
		// ����private person(String name, int age)������
		System.out.println("-----------------");
		con = clz.getDeclaredConstructor(String.class, int.class);
		System.out.println(con);
		con.setAccessible(true);// ���õ�ǰ���������Է��ʣ�ö������Ϊ˽�У����䶼���з���
		con.newInstance("����", 17);
		System.out.println("-----------------");
		clz.newInstance();//ֱ��ͨ���ã�class������ֱ�Ӵ��������޲ζ���
	}

}
