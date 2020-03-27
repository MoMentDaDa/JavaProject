package Class_Package;

import java.lang.reflect.Method;

class Worker {
	public void dowork() {
		System.out.println("�޲���");
	}

	public static void dowork(String name) {
		System.out.println("String:"+name);
	}

	private String sayHello(String name, int age) {
		System.out.println("Hello word");
		return name + "," + age;
	}
}

// ʹ�÷����ȡ���еķ���
public class GetMethodDemo {

	public static void main(String[] args) throws Exception {
		// getALL();
		// getOne();
		useMethod();
	}

	// ʹ�û�ȡ��ʹ�õķ���
	private static void useMethod() throws Exception, Exception {
		// ��ȡ�ֽ����ļ�
		Class clz = Worker.class;
		// ��ȡdowork����
		Method me = clz.getMethod("dowork");
		System.out.println(me);
		Object ret=me.invoke(clz.newInstance());//�޲���
		System.out.println(ret);//null
		System.out.println("-------------");
		me=clz.getMethod("dowork", String.class);
		ret=me.invoke(clz.newInstance(), "��");//String��
		System.out.println(ret);//null
		System.out.println("-------------");
		me=clz.getDeclaredMethod("sayHello", String.class,int.class);
		me.setAccessible(true);//����Ϊ���Է���˽�еĳ�Ա
		ret=me.invoke(clz.newInstance(), "wang",17);//Ӧ��������Ϊ�ɷ��� Hello word
		System.out.println(ret);
		System.out.println("-------------");
		//ִ�о�̬����
		me=clz.getMethod("dowork", String.class);
		ret=me.invoke(null, "lucy");
		System.out.println("-------------");
		
		
	}

	// ��ȡ�����ض��ķ���
	private static void getOne() throws Exception, Exception {
		// ��ȡ�ֽ����ļ�
		Class clz = Worker.class;
		// ��ȡdowork����
		Method me = clz.getMethod("dowork");
		System.out.println(me);
		System.out.println("------------");
		// ��ȡpublic static void dowork(String name)����
		me = clz.getMethod("dowork", String.class);
		System.out.println(me);
		System.out.println("------------------------");
		// ��ȡprivate String sayHello(String name,int age)����
		me = clz.getDeclaredMethod("sayHello", String.class, int.class);// ʹ��Declared���Ժ��Է�����Ȩ�����η�
		System.out.println(me);
		System.out.println("-----------");
	}

	private static void getALL() {
		Class clz = Worker.class;
		Method[] me = clz.getMethods();// ��ȡ���й����ķ����������̳й�����
		System.out.println(me.length);
		for (Method m : me) {
			System.out.println(m);
		}
		System.out.println("-----------");
		me = clz.getDeclaredMethods();// �÷���ֻ���ȡ����ķ������������̳кͷ���Ȩ���޹�
		System.out.println(me.length);
		for (Method m : me) {
			System.out.println(m);
		}
	}

}
