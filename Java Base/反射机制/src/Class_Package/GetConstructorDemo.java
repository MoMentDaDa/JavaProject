package Class_Package;

import java.lang.reflect.Constructor;

class user {

	public user() {

	}
	public user(String name) {

	}

	private user(String name, int age) {

	}
}

public class GetConstructorDemo {

	public static void main(String[] args) throws Exception {
		getAll();
		getOne();

	}

	private static void getOne() throws Exception, Exception {
		// 1����ȡ��������������ֽ������
		Class<user> clz = user.class;
		//����1����ȡ���������εĹ�����
		Constructor<user> con = clz.getConstructor();// �÷���ֻ�ܻ�ȡ�����Ĺ�����
		System.out.println(con);
		System.out.println("------------------");
		//3����ȡ������������
		con=clz.getDeclaredConstructor(String.class);
		System.out.println(con);
		System.out.println("------------------");
		//4����ȡ˽��Ȩ�޴������Ĺ�����
		con=clz.getDeclaredConstructor(String.class,int.class);
		System.out.println(con);
		
	}

	private static void getAll() throws Exception, Exception {
		// 1����ȡ��������������ֽ������
		Class<user> clz = user.class;
		// 2����ȡ�������еĹ�����
		Constructor<?>[] con = clz.getConstructors();// �÷���ֻ�ܻ�ȡ�����Ĺ�����
		System.out.println(con.length);
		for (Constructor<?> c : con) {
			System.out.println(c);
		}
		System.out.println("------------------");
		con = clz.getDeclaredConstructors();// ��ȡ���е����й����������ͷ���Ȩ���޹�
		System.out.println(con.length);
		for (Constructor<?> c : con) {
			System.out.println(c);
		}
		System.out.println("------------------");
	}

}
