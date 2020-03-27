package Class_Package;

import java.lang.reflect.Modifier;
enum Gender{
	Man,Woman,No;
}
public class OtherApiDemo {

	public static void main(String[] args) {
		//获取本类修饰符
		Class clz=OtherApiDemo.class;
		int mod=clz.getModifiers();//因为底层会使用int来代表修饰符
		String m=Modifier.toString(mod);
		System.out.println(m);
		//获取类名
		System.out.println(clz.getName());
		System.out.println(clz.getPackage());
		System.out.println(clz.getSimpleName());
		System.out.println(clz.getSuperclass());
		System.out.println(Gender.Man.getClass());
	}

}
