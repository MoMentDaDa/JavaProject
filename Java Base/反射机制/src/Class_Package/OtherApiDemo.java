package Class_Package;

import java.lang.reflect.Modifier;
enum Gender{
	Man,Woman,No;
}
public class OtherApiDemo {

	public static void main(String[] args) {
		//��ȡ�������η�
		Class clz=OtherApiDemo.class;
		int mod=clz.getModifiers();//��Ϊ�ײ��ʹ��int���������η�
		String m=Modifier.toString(mod);
		System.out.println(m);
		//��ȡ����
		System.out.println(clz.getName());
		System.out.println(clz.getPackage());
		System.out.println(clz.getSimpleName());
		System.out.println(clz.getSuperclass());
		System.out.println(Gender.Man.getClass());
	}

}
