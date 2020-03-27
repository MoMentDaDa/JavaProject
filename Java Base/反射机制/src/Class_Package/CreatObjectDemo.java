package Class_Package;

import java.lang.reflect.Constructor;

class person {
	public person() {
		System.out.println("无参数构造器");
	}

	public person(String name) {
		System.out.println("构造器" + name);
	}

	private person(String name, int age) {
		System.out.println("构造器" + name + age);
	}
}

public class CreatObjectDemo {

	public static void main(String[] args) throws Exception, Exception {
		// 获取字节码文件
		Class<person> clz = person.class;
		// 获取构造器
		Constructor<person> con = clz.getConstructor();
		System.out.println(con);
		// 调用构造器的newInstance方法创建对象，并传入实参
		con.newInstance();
		System.out.println("-----------------");
		// 调用public person(String name)构造器
		con = clz.getConstructor(String.class);
		System.out.println(con);
		con.newInstance("汪哥");
		// 调用private person(String name, int age)构造器
		System.out.println("-----------------");
		con = clz.getDeclaredConstructor(String.class, int.class);
		System.out.println(con);
		con.setAccessible(true);// 设置当前构造器可以访问，枚举设置为私有，反射都不行访问
		con.newInstance("汪哥", 17);
		System.out.println("-----------------");
		clz.newInstance();//直接通过该（class）方法直接创建公共无参对象
	}

}
