package Class_Package;

import java.lang.reflect.Method;
import java.util.Arrays;

class Employee {
	public static void dowork(int... arr) {
		System.out.println("��̬����1���ã�" + Arrays.toString(arr));
	}

	public void dowork2(String... arr) {
		System.out.println("�Ǿ�̬����2����," + Arrays.toString(arr));
	}
	private String sayHello(String name, int age) {
		System.out.println("Hello word:"+name+age);
		return name + "," + age;
	}
}

// ʹ�÷����������������ɱ������
public class ArrayInvokeMethodDemo {

	public static void main(String[] args) throws Exception, Exception {
		Class clz = Employee.class;
		// ���һ������Ԫ��Ϊ��������
		Method me = clz.getMethod("dowork", int[].class);
		// me.invoke(null, 1,2,3,4,5);��ʾ�������
		me.invoke(null, new int[] { 1, 2, 3, 4, 5 });
		me.invoke(null, new Object[]{new int[]{1,2,3,4,5}});
		// ���2������Ԫ��Ϊ��������
		me=clz.getMethod("dowork2", String[].class);
		System.out.println(me);
		//me.invoke(null, "A","B","C");����
		//me.invoke(null, new String[]{"A","B","C"});����
		me.invoke(clz.newInstance(), new Object[]{new String[]{"A","B","C"}});
		//���ö������ʽ
		me=clz.getDeclaredMethod("sayHello",String.class,int.class);
		System.out.println(me);
		me.setAccessible(true);
		me.invoke(clz.newInstance(),new Object[]{"Lucy",18});//ʹ��Object���鴫�ݲ���
	}

}
